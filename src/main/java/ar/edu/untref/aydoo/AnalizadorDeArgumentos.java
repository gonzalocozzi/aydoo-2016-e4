package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorDeArgumentos {

	private List<String> listaDeArgumentos;
	private String nombreDeCarpetaDeSalida;

	public AnalizadorDeArgumentos(String[] args) throws SinNombreDelArchivoDeEntradaException {		

		this.listaDeArgumentos = new ArrayList<String>();
		this.setNombreDeCarpetaDeSalida(args);		

		for(int i = 0; i < args.length; i++){
			this.listaDeArgumentos.add(i, args[i].toLowerCase());
		}

	}

	private Integer getPosicionDelNombreDelArchivoDeEntrada(String[] args){

		Integer posicionDelNombreDeArchivoDeEntrada = 0;

		for(int i = 0; i < args.length; i++){			
			if(!args[i].contains("--")){				
				posicionDelNombreDeArchivoDeEntrada = i;
			}			
		}

		return posicionDelNombreDeArchivoDeEntrada;			
	}

	private void setNombreDeCarpetaDeSalida(String[] args){

		String nombreDeLaCarpetaSinExtension = ""; 

		if(args.length == 1){			
			//se quita la extension Markdown al nombre de la carpeta de salida
			nombreDeLaCarpetaSinExtension = args[0].replace(".md", "");
		} else {
			Integer posicionDelNombrelDeArchivoDeEntrada = this.getPosicionDelNombreDelArchivoDeEntrada(args);
			//se quita la extension Markdown al nombre de la carpeta de salida
			nombreDeLaCarpetaSinExtension = args[posicionDelNombrelDeArchivoDeEntrada].replace(".md", "");
		}
		
		if(this.nombreContieneCaracteresInvalidos(nombreDeLaCarpetaSinExtension)){
			
			throw new NombreInvalidoException();
		}

		this.nombreDeCarpetaDeSalida = nombreDeLaCarpetaSinExtension;
	}

	private boolean nombreContieneCaracteresInvalidos(String nombreDeLaCarpetaSinExtension) {

		Boolean contieneCaracteresInvalidos = false;
		
		if(nombreDeLaCarpetaSinExtension.contains(" ")){
			
			contieneCaracteresInvalidos = true;
		}

		return contieneCaracteresInvalidos;
	}

	public List<String> getListaDeArgumentos() {
		return this.listaDeArgumentos;
	}

	public String getNombreDeCarpetaDeSalida() {		
		return this.nombreDeCarpetaDeSalida;
	}

}
