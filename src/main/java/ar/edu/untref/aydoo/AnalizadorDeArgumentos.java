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
			nombreDeLaCarpetaSinExtension = args[0].replace(".md", "");
		} else if (args[0].substring(0, 9).equals("--output=")) {			
			nombreDeLaCarpetaSinExtension = args[0].substring(9);			
		} else if (args[1].substring(0, 9).equals("--output=")) {			
			nombreDeLaCarpetaSinExtension = args[1].substring(9);			
		} else {			
			Integer posicionDelNombrelDeArchivoDeEntrada = this.getPosicionDelNombreDelArchivoDeEntrada(args);
			nombreDeLaCarpetaSinExtension = args[posicionDelNombrelDeArchivoDeEntrada].replace(".md", "");
		}

		if(this.nombreContieneCaracteresInvalidos(nombreDeLaCarpetaSinExtension)){			
			throw new NombreInvalidoException();
		}

		this.nombreDeCarpetaDeSalida = nombreDeLaCarpetaSinExtension;
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

	public List<String> getListaDeArgumentos() {
		return this.listaDeArgumentos;
	}

	public String getNombreDeCarpetaDeSalida() {		
		return this.nombreDeCarpetaDeSalida;
	}

	public Boolean isModeDefault() {
		return this.listaDeArgumentos.contains("--mode=default");
	}

}
