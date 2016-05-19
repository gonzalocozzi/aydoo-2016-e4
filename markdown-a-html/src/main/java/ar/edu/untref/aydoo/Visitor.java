package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Visitor {
	
	List<String> listaDeLineas;
	
	public Visitor(){
		this.listaDeLineas = new LinkedList<String>();
	}
	
	public List<String> getListaDeLineas() {
		return this.listaDeLineas;
	}
	
	public void visitar(Titulo titulo) {
		this.listaDeLineas.add(titulo.getHTML());
	}

	public void visitar(Subtitulo subtitulo) {
		this.listaDeLineas.add(subtitulo.getHTML());
	}

	public void visitar(Imagen imagen) {
		this.listaDeLineas.add(imagen.getHTML());
	}

	public void visitarTextSinFormato(TextoSinFormato textoSinFormato) {
		this.listaDeLineas.add(textoSinFormato.getHTML());
	}

	public void visitarItemDeLista(ItemDeLista itemDeLista) {
		this.listaDeLineas.add(itemDeLista.getHTML());
	}
}
