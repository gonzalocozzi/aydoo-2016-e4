package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorDeArgumentos {
	
	private List<String> listaDeArgumentos;
	private String nombreDeCarpetaDeSalida;

	public AnalizadorDeArgumentos(String[] args) throws NoInputFileNameException {		
		this.listaDeArgumentos = new ArrayList<String>();
		
		if(args.length == 1 && args[0].contains("--")){			
			throw new NoInputFileNameException();
		}
		
		for(int i = 0; i < args.length; i++){
			this.listaDeArgumentos.add(i, args[i].toLowerCase());
		}
		
		this.setNombreDeCarpetaDeSalida();
	}
	
	private void setNombreDeCarpetaDeSalida(){
		
		String nombreDeLaCarpetaSinExtension = ""; 
		
		if(this.listaDeArgumentos.size() == 1){			
			//se quita la extension Markdown al nombre de la carpeta de salida
			nombreDeLaCarpetaSinExtension = this.listaDeArgumentos.get(0).replace(".md", "");
		} else {
			//se quita la extension Markdown al nombre de la carpeta de salida
			nombreDeLaCarpetaSinExtension = this.listaDeArgumentos.get(this.listaDeArgumentos.size() - 1).replace(".md", "");
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
