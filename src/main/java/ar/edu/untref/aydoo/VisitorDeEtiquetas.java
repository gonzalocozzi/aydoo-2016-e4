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

	@Override
	public void visitar(EtiquetaHTML etiqueta ) {
		this.listaDeLineas.add(etiqueta.getPrefijo()+etiqueta.getTexto()+etiqueta.getSufijo());	
	}

	@Override
	public void visitar(ListaSinOrden lista){

		this.listaDeLineas.add(lista.getPrefijo());

		for(ItemDeLista item : lista.getColeccionDeItems()){
			item.aceptarVisitor(this);
		}

		this.listaDeLineas.add(lista.getSufijo());
	}

	@Override
	public void visitar(Seccion seccion) {

		this.listaDeLineas.add(seccion.getPrefijo());

		for(EtiquetaHTML etiqueta : seccion.getListaDeElementos()){
			etiqueta.aceptarVisitor(this);
		}

		this.listaDeLineas.add(seccion.getSufijo());		
	}
}
