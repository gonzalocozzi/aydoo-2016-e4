package ar.edu.untref.aydoo.creacionDeEtiquetas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.etiquetas.Etiqueta;

public class CreadorDeSalidaHTML {

	private List<String> listaDeSalida;

	public CreadorDeSalidaHTML(List<Etiqueta> listaDeEtiquetas) {
		this.listaDeSalida = new LinkedList<String>();
		this.crearSalidaHTML(listaDeEtiquetas);
	}

	public List<String> getListaDeSalidaHTML() {
		return this.listaDeSalida;
	}

	public void crearSalidaHTML(List<Etiqueta> listaDeEtiquetas){
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();	

		for(Etiqueta etiqueta : listaDeEtiquetas){
			etiqueta.aceptarVisitor(visitor);
		}	

		this.listaDeSalida = visitor.getListaDeLineas();
	}
}
