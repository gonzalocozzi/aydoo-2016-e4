package ar.edu.untref.aydoo.analisisDeArgumentos;

import java.util.LinkedList;
import java.util.List;

public class ValidadorDeArgumentos {

	private List<String> listaDeArgumentos;
	private List<ArgumentosException> listaDeExcepciones;
	private String nombreDelArchivoDeEntrada;
	private String nombreDeCarpetaDeSalida;

	public ValidadorDeArgumentos(List<String> listaDeArgumentos){
		this.listaDeArgumentos = listaDeArgumentos;
		this.listaDeExcepciones = new LinkedList<>();
		this.validarListaDeArgumentos();			
		this.setNombreDelArchivoDeEntrada();
		this.setNombreDeCarpetaDeSalida();		
	}		

	private void setNombreDeCarpetaDeSalida(){
		String nombreDeLaCarpetaSinExtension = ""; 
		Boolean existeUnicamenteArgumentoOutput = this.listaDeArgumentos.get(0).length() > 8 && this.listaDeArgumentos.get(0).substring(0, 9).equalsIgnoreCase("--output=");
		Boolean existeArgumentoOutput = this.listaDeArgumentos.size() > 1 && this.listaDeArgumentos.get(0).length() > 8 && this.listaDeArgumentos.get(1).substring(0, 9).equalsIgnoreCase("--output=");
		//La presente estructura if-else busca el nombre de la carpeta de salida en la entrada 
		//Es un procedimiento que esperamos que jamas cambie, sin importar el numero o tipo de argumentos
		if (existeUnicamenteArgumentoOutput) {			
			nombreDeLaCarpetaSinExtension = this.listaDeArgumentos.get(0).substring(9);			
		} else if (existeArgumentoOutput) {			
			nombreDeLaCarpetaSinExtension = this.listaDeArgumentos.get(1).substring(9);			
		} else {			
			nombreDeLaCarpetaSinExtension = this.nombreDelArchivoDeEntrada.replace(".md", "");
		}

		this.nombreDeCarpetaDeSalida = nombreDeLaCarpetaSinExtension;
	}

	public void setNombreDelArchivoDeEntrada(){

		if(this.listaDeArgumentos.size() == 1){			
			this.nombreDelArchivoDeEntrada = this.listaDeArgumentos.get(0);			
		} else {				
			Integer posicionDelNombrelDeArchivoDeEntrada = this.getPosicionDelNombreDelArchivoDeEntrada();
			this.nombreDelArchivoDeEntrada = this.listaDeArgumentos.get(posicionDelNombrelDeArchivoDeEntrada);
		}

		if(this.nombreContieneCaracteresInvalidos(this.nombreDelArchivoDeEntrada)){	
			throw new NombreInvalidoException("el nombre del archivo de entrada no es valido. Por favor, intentelo nuevamente.");
		}

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
		SinNombreDelArchivoDeEntradaException sinNombreDelArchivoDeEntradaException = new SinNombreDelArchivoDeEntradaException(this.listaDeArgumentos, "por favor, indique el nombre del archivo Markdown de entrada.");
		ArgumentoInvalidoException argumentoInvalidoException = new ArgumentoInvalidoException(this.listaDeArgumentos, "ha ingresado al menos un argumento invalido. Por favor, intentelo nuevamente.");
		NumeroDeArgumentosExcedidoException numeroDeArgumentosExcedidoException = new NumeroDeArgumentosExcedidoException(this.listaDeArgumentos,  "no debe ingresar mas de 2 argumentos. Por favor, intentelo nuevamente.");
		
		this.listaDeExcepciones.add(sinNombreDelArchivoDeEntradaException);
		this.listaDeExcepciones.add(argumentoInvalidoException);
		this.listaDeExcepciones.add(numeroDeArgumentosExcedidoException);	
		
		for(ArgumentosException excepcion : this.listaDeExcepciones){
			excepcion.getInstance();
		}

	}

	public String getNombreDelArchivoDeEntrada(){
		return this.nombreDelArchivoDeEntrada;
	}

	public String getNombreDeCarpetaDeSalida() {		
		return this.nombreDeCarpetaDeSalida;
	}

}
