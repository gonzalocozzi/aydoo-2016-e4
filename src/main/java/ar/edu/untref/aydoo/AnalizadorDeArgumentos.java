package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorDeArgumentos {
	
	private List<String> listaDeArgumentos;

	public AnalizadorDeArgumentos(String[] args) {
		this.listaDeArgumentos = new ArrayList<String>();
		this.listaDeArgumentos.add(args[0]);
	}

	public List<String> getListaDeArgumentos() {
		return this.listaDeArgumentos;
	}

}
