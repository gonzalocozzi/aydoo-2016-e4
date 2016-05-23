package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorDeArgumentos {
	
	private List<String> listaDeArgumentos;
	private String nombreDeCarpetaDeSalida;

	public AnalizadorDeArgumentos(String[] args) throws SinNombreDelArchivoDeEntradaException {		
		
		this.listaDeArgumentos = new ArrayList<String>();		
		
		for(int i = 0; i < args.length; i++){
			this.listaDeArgumentos.add(i, args[i].toLowerCase());
		}
		
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
			//se quita la extension Markdown al nombre de la carpeta de salida
			nombreDeLaCarpetaSinExtension = this.listaDeArgumentos.get(0).replace(".md", "");
		} else {
			Integer posicionDelNombrelDeArchivoDeEntrada = this.getPosicionDelNombreDelArchivoDeEntrada();
			//se quita la extension Markdown al nombre de la carpeta de salida
			nombreDeLaCarpetaSinExtension = this.listaDeArgumentos.get(posicionDelNombrelDeArchivoDeEntrada).replace(".md", "");
		}
		
		this.nombreDeCarpetaDeSalida = nombreDeLaCarpetaSinExtension;
	}

	public List<String> getListaDeArgumentos() {
		return this.listaDeArgumentos;
	}

	public String getNombreDeCarpetaDeSalida() {		
		return this.nombreDeCarpetaDeSalida;
	}

}
