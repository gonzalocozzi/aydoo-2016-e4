package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorDeArgumentos {
	
	private List<String> listaDeArgumentos;

	public AnalizadorDeArgumentos(String[] args) {		
		this.listaDeArgumentos = new ArrayList<String>();
		
		for(int i = 0; i < args.length; i++){
			this.listaDeArgumentos.add(i, args[i].toLowerCase());
		}
	}

	public List<String> getListaDeArgumentos() {
		return this.listaDeArgumentos;
	}

}
