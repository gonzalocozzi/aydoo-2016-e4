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

	public void visitar(EtiquetaHTML etiquetaGenerica) {
		this.listaDeLineas.add(etiquetaGenerica.getPrefijo()+etiquetaGenerica.getTexto()+etiquetaGenerica.getSufijo());	
	}

	public void visitar(Seccion seccion) {
		
		this.listaDeLineas.add(seccion.getPrefijo());
		this.listaDeLineas.add(seccion.getListaDeElementos().get(0).getPrefijo()+seccion.getListaDeElementos().get(0).getTexto()+seccion.getListaDeElementos().get(0).getSufijo());
		this.listaDeLineas.add(seccion.getSufijo());		
	}
}
