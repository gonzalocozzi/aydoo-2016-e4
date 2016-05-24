package ar.edu.untref.aydoo;

import java.util.List;

public class ValidadorDeArgumentos {

	private String nombreDeCarpetaDeSalida;
	private boolean argumentosSonValidos;
	
	public ValidadorDeArgumentos(List<String> listaDeArgumentos){	
		this.argumentosSonValidos = false;	
		this.validarListaDeArgumentos(listaDeArgumentos);
		this.setNombreDeCarpetaDeSalida(listaDeArgumentos);			
	}
	
	private Integer getPosicionDelNombreDelArchivoDeEntrada(List<String> listaDeArgumentos){

		Integer posicionDelNombreDeArchivoDeEntrada = 0;

		for(int i = 0; i < listaDeArgumentos.size(); i++){			
			if(!listaDeArgumentos.get(i).contains("--")){				
				posicionDelNombreDeArchivoDeEntrada = i;
			}			
		}

		return posicionDelNombreDeArchivoDeEntrada;			
	}
	
	private void setNombreDeCarpetaDeSalida(List<String> listaDeArgumentos){

		String nombreDeLaCarpetaSinExtension = ""; 

		if(listaDeArgumentos.size() == 1){
			nombreDeLaCarpetaSinExtension = listaDeArgumentos.get(0).replace(".md", "");
		} else if (listaDeArgumentos.get(0).substring(0, 9).equals("--output=")) {			
			nombreDeLaCarpetaSinExtension = listaDeArgumentos.get(0).substring(9);			
		} else if (listaDeArgumentos.get(0).substring(0, 9).equals("--output=")) {			
			nombreDeLaCarpetaSinExtension = listaDeArgumentos.get(0).substring(9);			
		} else {			
			Integer posicionDelNombrelDeArchivoDeEntrada = this.getPosicionDelNombreDelArchivoDeEntrada(listaDeArgumentos);
			nombreDeLaCarpetaSinExtension = listaDeArgumentos.get(posicionDelNombrelDeArchivoDeEntrada).replace(".md", "");
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

	private void validarListaDeArgumentos(List<String> listaDeArgumentos) {
		
		String stringDeArgumentos = listaDeArgumentos.toString();
		Boolean sinNombreDelArchivoDeEntrada = listaDeArgumentos.size() == 0 || listaDeArgumentos.size() == 1 && listaDeArgumentos.get(0).contains("--");
		Boolean argumentoInvalido = listaDeArgumentos.size() == 2 && !stringDeArgumentos.contains("--mode=default") && !stringDeArgumentos.contains("--mode=no-output") && !stringDeArgumentos.contains("--output=");
		Boolean soloArgumentosDeConfiguracion = listaDeArgumentos.size() == 2 && listaDeArgumentos.get(0).contains("--") && listaDeArgumentos.get(1).contains("--");
	
		if (sinNombreDelArchivoDeEntrada) {			

			throw new SinNombreDelArchivoDeEntradaException();

		} else if (argumentoInvalido) {

			throw new ArgumentoInvalidoException();

		} else if (soloArgumentosDeConfiguracion) {

			throw new SinNombreDelArchivoDeEntradaException();

		} else if (listaDeArgumentos.size() > 2) {

			throw new NumeroDeArgumentosExcedidoException();

		} else {

			this.argumentosSonValidos = true;
		}

	}
	
	public String getNombreDeCarpetaDeSalida() {		
		return this.nombreDeCarpetaDeSalida;
	}

	public boolean argumentosSonValidos() {
		return this.argumentosSonValidos;
	}	

}
