package ar.edu.untref.aydoo;

import java.util.List;

public class ValidadorDeArgumentos {

	private List<String> listaDeArgumentos;
	private String nombreDelArchivoDeEntrada;
	private String nombreDeCarpetaDeSalida;
	private boolean argumentosSonValidos;

	public ValidadorDeArgumentos(List<String> listaDeArgumentos){
		this.argumentosSonValidos = false;	
		this.listaDeArgumentos = listaDeArgumentos;
		this.validarListaDeArgumentos();
		
		if(this.argumentosSonValidos){
			this.setNombreDelArchivoDeEntrada();
			this.setNombreDeCarpetaDeSalida();				
		}
		
	}	

	public void setNombreDelArchivoDeEntrada(){

		if(this.listaDeArgumentos.size() == 1){			
			this.nombreDelArchivoDeEntrada = this.listaDeArgumentos.get(0);			
		} else {				
			Integer posicionDelNombrelDeArchivoDeEntrada = this.getPosicionDelNombreDelArchivoDeEntrada();
			this.nombreDelArchivoDeEntrada = this.listaDeArgumentos.get(posicionDelNombrelDeArchivoDeEntrada);
		}

		if(this.nombreContieneCaracteresInvalidos(this.nombreDelArchivoDeEntrada)){	
			//System.out.println("[ERROR] El nombre del archivo de entrada no es valido. Por favor, intentelo nuevamente.");
			throw new NombreInvalidoException("[ERROR] El nombre del archivo de entrada no es valido. Por favor, intentelo nuevamente.");
		}
	}

	private void setNombreDeCarpetaDeSalida(){

		String nombreDeLaCarpetaSinExtension = ""; 

		if (this.listaDeArgumentos.get(0).length() > 8 && this.listaDeArgumentos.get(0).substring(0, 9).equalsIgnoreCase("--output=")) {			
			nombreDeLaCarpetaSinExtension = this.listaDeArgumentos.get(0).substring(9);			
		} else if (this.listaDeArgumentos.size() > 1 && this.listaDeArgumentos.get(0).length() > 8 && this.listaDeArgumentos.get(1).substring(0, 9).equalsIgnoreCase("--output=")) {			
			nombreDeLaCarpetaSinExtension = this.listaDeArgumentos.get(1).substring(9);			
		} else {			
			nombreDeLaCarpetaSinExtension = this.nombreDelArchivoDeEntrada.replace(".md", "");
		}

		this.nombreDeCarpetaDeSalida = nombreDeLaCarpetaSinExtension;
	}

	private Integer getPosicionDelNombreDelArchivoDeEntrada(){

		Integer posicionDelNombreDeArchivoDeEntrada = 0;

		for(int i = 0; i < this.listaDeArgumentos.size(); i++){			
			if(!this.listaDeArgumentos.get(i).contains("--")){				
				posicionDelNombreDeArchivoDeEntrada = i;
			}			
		}

		return posicionDelNombreDeArchivoDeEntrada;			
	}

	private boolean nombreContieneCaracteresInvalidos(String nombreDeLaCarpetaSinExtension) {

		Boolean contieneCaracteresInvalidos = false;		
		String caracteresInvalidos = " ñÑáéíóúÁÉÍÓÚ/";

		//Este algoritmo recorre un string de caracteres invalidos para saber si alguno de ellos se encuentra en el nombre del archivo
		for (int i = 0; i < nombreDeLaCarpetaSinExtension.length(); i++) {				
			char c = nombreDeLaCarpetaSinExtension.charAt(i);			
			for (int j = 0; j < caracteresInvalidos.length(); j++) {				
				if (c == caracteresInvalidos.charAt(j)) {					
					contieneCaracteresInvalidos = true;
				}				
			}			
		}

		return contieneCaracteresInvalidos;
	}	

	private void validarListaDeArgumentos() {

		String stringDeArgumentos = this.listaDeArgumentos.toString().toLowerCase();
		Boolean sinNombreDelArchivoDeEntrada = this.listaDeArgumentos.size() == 0 || this.listaDeArgumentos.size() == 1 && this.listaDeArgumentos.get(0).contains("--");
		Boolean argumentoInvalido = this.listaDeArgumentos.size() == 2 && !stringDeArgumentos.contains("--mode=default") && !stringDeArgumentos.contains("--mode=no-output") && !stringDeArgumentos.contains("--output=");
		Boolean soloArgumentosDeConfiguracion = this.listaDeArgumentos.size() == 2 && this.listaDeArgumentos.get(0).contains("--") && this.listaDeArgumentos.get(1).contains("--");

		if (sinNombreDelArchivoDeEntrada) {
			System.out.println("[ERROR] Por favor, indique el nombre del archivo Markdown de entrada.");
			//throw new SinNombreDelArchivoDeEntradaException();
		} 
		else if (argumentoInvalido) {
			System.out.println("[ERROR] Usted ha ingresado al menos un argumento invalido. Por favor, intentelo nuevamente.");
			//throw new ArgumentoInvalidoException();
		} 
		else if (soloArgumentosDeConfiguracion) {
			System.out.println("[ERROR] Por favor, indique el nombre del archivo Markdown de entrada.");
			//throw new SinNombreDelArchivoDeEntradaException();
		} 
		else if (this.listaDeArgumentos.size() > 2) {
			System.out.println("[ERROR] No debe ingresar mas de 2 argumentos. Por favor, intentelo nuevamente.");
			//throw new NumeroDeArgumentosExcedidoException();
		} 
		else {
			this.argumentosSonValidos = true;
		}

	}

	public String getNombreDelArchivoDeEntrada(){
		return this.nombreDelArchivoDeEntrada;
	}

	public String getNombreDeCarpetaDeSalida() {		
		return this.nombreDeCarpetaDeSalida;
	}

	public boolean argumentosSonValidos() {
		return this.argumentosSonValidos;
	}	

}
