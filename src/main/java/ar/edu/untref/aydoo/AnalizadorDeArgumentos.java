package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorDeArgumentos {
	
	private List<String> listaDeArgumentos;
	private String nombreDeCarpetaDeSalida;

	public AnalizadorDeArgumentos(String[] args) {		
		this.listaDeArgumentos = new ArrayList<String>();
		
		for(int i = 0; i < args.length; i++){
			this.listaDeArgumentos.add(i, args[i].toLowerCase());
		}
		
		this.setNombreDeCarpetaDeSalida();
	}
	
	private void setNombreDeCarpetaDeSalida(){
		String nombreDeCarpetaSinExtension = this.listaDeArgumentos.get(0).replace(".md", "");
		this.nombreDeCarpetaDeSalida = nombreDeCarpetaSinExtension;
	}

	public List<String> getListaDeArgumentos() {
		return this.listaDeArgumentos;
	}

	public String getNombreDeCarpetaDeSalida() {		
		return this.nombreDeCarpetaDeSalida;
	}

}
