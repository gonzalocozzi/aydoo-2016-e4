package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class VisitorDeEtiquetas implements Visitor{
	
	private List<String> listaDeLineas;
	
	public VisitorDeEtiquetas(){
		this.listaDeLineas = new LinkedList<String>();
	}
	
	public List<String> getListaDeLineas() {
		return this.listaDeLineas;
	}

	public void visitar(EtiquetaHTMLSimple etiquetaGenerica) {
		this.listaDeLineas.add(etiquetaGenerica.getHTML());	
	}
}
