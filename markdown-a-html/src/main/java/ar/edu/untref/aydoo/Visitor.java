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
		this.listaDeLineas.add(titulo.getPrefijo()+titulo.getTexto()+titulo.getSufijo());
	}

	public void visitar(Subtitulo subtitulo) {
		this.listaDeLineas.add(subtitulo.getPrefijo()+subtitulo.getTexto()+subtitulo.getSufijo());
	}

	public void visitar(Imagen imagen) {
		this.listaDeLineas.add(imagen.getPrefijo()+imagen.getTexto()+imagen.getSufijo());
	}

	public void visitarTextSinFormato(TextoSinFormato textoSinFormato) {
		this.listaDeLineas.add(textoSinFormato.getPrefijo()+textoSinFormato.getTexto()+textoSinFormato.getSufijo());
	}

	public void visitarItemDeLista(ItemDeLista itemDeLista) {
		this.listaDeLineas.add(itemDeLista.getPrefijo()+itemDeLista.getTexto()+itemDeLista.getSufijo());
	}	
}
