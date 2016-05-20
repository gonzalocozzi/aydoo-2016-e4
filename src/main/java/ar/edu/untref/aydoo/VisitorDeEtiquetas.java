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

	public void visitar(EtiquetaHTML etiqueta ) {
		this.listaDeLineas.add(etiqueta.getPrefijo()+etiqueta.getTexto()+etiqueta.getSufijo());	
	}

	public void visitar(ListaSinOrden lista){
		
		this.listaDeLineas.add(lista.getPrefijo());
		
		for(ItemDeLista item : lista.getColeccionDeItems()){
			this.visitar(item);
		}
		
		this.listaDeLineas.add(lista.getSufijo());
	}
	
	public void visitar(Seccion seccion) {

		this.listaDeLineas.add(seccion.getPrefijo());
		
		for(EtiquetaHTML etiqueta : seccion.getListaDeElementos()){
			this.visitar(etiqueta);
		}
		
		this.listaDeLineas.add(seccion.getSufijo());		
	}
}
