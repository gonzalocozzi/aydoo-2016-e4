package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class CreadorDeSalidaHTML {

	private List<String> listaDeSalida;

	public CreadorDeSalidaHTML(List<EtiquetaHTML> listaDeEtiquetas) {
		this.listaDeSalida = new LinkedList<String>();
		this.crearSalidaHTML(listaDeEtiquetas);
	}

	public List<String> getListaDeSalidaHTML() {
		return this.listaDeSalida;
	}

	public void crearSalidaHTML(List<EtiquetaHTML> listaDeEtiquetas){
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();	

		for(EtiquetaHTML etiqueta : listaDeEtiquetas){
			etiqueta.aceptarVisitor(visitor);
		}	

		this.listaDeSalida = visitor.getListaDeLineas();
	}
}
