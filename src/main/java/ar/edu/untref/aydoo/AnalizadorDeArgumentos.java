package ar.edu.untref.aydoo;

import java.util.List;

public class AnalizadorDeArgumentos {

	private List<String> listaDeArgumentos;
	private String nombreDeCarpetaDeSalida;

	public AnalizadorDeArgumentos(List<String> listaDeArgumentos) throws SinNombreDelArchivoDeEntradaException {
		this.listaDeArgumentos = listaDeArgumentos;
		this.setNombreDeCarpetaDeSalida();			
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

	private void setNombreDeCarpetaDeSalida(){

		String nombreDeLaCarpetaSinExtension = ""; 

		if(this.listaDeArgumentos.size() == 1){
			nombreDeLaCarpetaSinExtension = this.listaDeArgumentos.get(0).replace(".md", "");
		} else if (this.listaDeArgumentos.get(0).substring(0, 9).equals("--output=")) {			
			nombreDeLaCarpetaSinExtension = this.listaDeArgumentos.get(0).substring(9);			
		} else if (this.listaDeArgumentos.get(0).substring(0, 9).equals("--output=")) {			
			nombreDeLaCarpetaSinExtension = this.listaDeArgumentos.get(0).substring(9);			
		} else {			
			Integer posicionDelNombrelDeArchivoDeEntrada = this.getPosicionDelNombreDelArchivoDeEntrada();
			nombreDeLaCarpetaSinExtension = this.listaDeArgumentos.get(posicionDelNombrelDeArchivoDeEntrada).replace(".md", "");
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

	public String getNombreDeCarpetaDeSalida() {		
		return this.nombreDeCarpetaDeSalida;
	}

	public Boolean isModeDefault() {
		return this.listaDeArgumentos.contains("--mode=default") || this.listaDeArgumentos.size() == 1;
	}

	public Boolean isModeNoOutput() {
		return this.listaDeArgumentos.contains("--mode=no-output");
	}

	public Boolean isOutput() {
		String stringDeArgumentos = this.listaDeArgumentos.toString();
		return stringDeArgumentos.contains("--output=");
	}

}
