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

		//Se agregan excepciones por default al programa
		SinNombreDelArchivoDeEntradaException sinNombreDelArchivoDeEntradaException = new SinNombreDelArchivoDeEntradaException(this.listaDeArgumentos);
		ArgumentoInvalidoException argumentoInvalidoException = new ArgumentoInvalidoException(this.listaDeArgumentos);
		NumeroDeArgumentosExcedidoException numeroDeArgumentosExcedidoException = new NumeroDeArgumentosExcedidoException(this.listaDeArgumentos);
		this.agregarExcepcion(sinNombreDelArchivoDeEntradaException);
		this.agregarExcepcion(argumentoInvalidoException);
		this.agregarExcepcion(numeroDeArgumentosExcedidoException);					

		this.validarListaDeArgumentos();			
		this.setNombreDelArchivoDeEntrada();
		this.setNombreDeCarpetaDeSalida();		
	}		

	public void agregarExcepcion(ArgumentosException excepcion){
		this.listaDeExcepciones.add(excepcion);
	}

	public String getNombreDeCarpetaDeSalida() {		
		return this.nombreDeCarpetaDeSalida;
	}	

	public String getNombreDelArchivoDeEntrada(){
		return this.nombreDelArchivoDeEntrada;
	}

	public void setNombreDelArchivoDeEntrada(){

		if(this.listaDeArgumentos.size() == 1){			
			this.nombreDelArchivoDeEntrada = this.listaDeArgumentos.get(0);			
		} else {				
			Integer posicionDelNombrelDeArchivoDeEntrada = this.getPosicionDelNombreDelArchivoDeEntrada();
			this.nombreDelArchivoDeEntrada = this.listaDeArgumentos.get(posicionDelNombrelDeArchivoDeEntrada);
		}

		if(this.nombreContieneCaracteresInvalidos(this.nombreDelArchivoDeEntrada)){	
			throw new NombreInvalidoException();
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

	private void setNombreDeCarpetaDeSalida(){
		String nombreDeLaCarpetaSinExtension = ""; 
		Boolean existeUnicamenteArgumentoOutput = this.listaDeArgumentos.get(0).length() > 8 && this.listaDeArgumentos.get(0).substring(0, 9).equalsIgnoreCase("--output=");
		Boolean existeArgumentoOutput = this.listaDeArgumentos.size() > 1 && this.listaDeArgumentos.get(0).length() > 8 && this.listaDeArgumentos.get(1).substring(0, 9).equalsIgnoreCase("--output=");

		//La presente estructura if-else busca el nombre de la carpeta de salida en la entrada de argumentos
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

	private void validarListaDeArgumentos() {	

		for(ArgumentosException excepcion : this.listaDeExcepciones){
			excepcion.getNuevaInstancia();
		}

	}

}
