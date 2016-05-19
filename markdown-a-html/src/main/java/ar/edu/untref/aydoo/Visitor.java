package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Visitor {
	
	List<String> listaDeLineas;
	
	public Visitor(){
		this.listaDeLineas = new LinkedList<String>();
	}
	
	public void visitar(Titulo titulo) {
		this.listaDeLineas.add(titulo.getPrefijo()+titulo.getTexto()+titulo.getSufijo());
	}

	public List<String> getListaDeLineas() {
		return this.listaDeLineas;
	}
}
