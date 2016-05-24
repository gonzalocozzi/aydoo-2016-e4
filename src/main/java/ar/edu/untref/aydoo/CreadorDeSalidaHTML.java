package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class CreadorDeSalidaHTML {

	private List<String> listaDeSalida;
	
	public CreadorDeSalidaHTML(List<EtiquetaHTML> lista) {
		this.listaDeSalida = new LinkedList<String>();
		this.crearSalidaHTML(lista);
	}

	public List<String> getListaDeSalidaHTML() {
		return this.listaDeSalida;
	}
	
	public void crearSalidaHTML(List<EtiquetaHTML> lista){
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();		
		for(EtiquetaHTML etiqueta : lista){
			etiqueta.aceptarVisitor(visitor);
		}		
		this.listaDeSalida = visitor.getListaDeLineas();
	}
}
