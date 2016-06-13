package ar.edu.untref.aydoo.creacionDeEtiquetas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.etiquetas.Etiqueta;
import ar.edu.untref.aydoo.etiquetas.ItemDeLista;
import ar.edu.untref.aydoo.etiquetas.ListaSinOrden;
import ar.edu.untref.aydoo.etiquetas.Seccion;

public class VisitorDeEtiquetas implements Visitor{

	private List<String> listaDeLineas;

	public VisitorDeEtiquetas(){
		this.listaDeLineas = new LinkedList<String>();
	}

	public List<String> getListaDeLineas() {
		return this.listaDeLineas;
	}

	@Override
	public void visitar(Etiqueta etiqueta) {
		this.listaDeLineas.add(etiqueta.getPrefijoHTML()+etiqueta.getTexto()+etiqueta.getSufijoHTML());	
	}

	@Override
	public void visitar(ListaSinOrden lista){
		this.listaDeLineas.add(lista.getPrefijoHTML());

		for(ItemDeLista item : lista.getColeccionDeItems()){
			item.aceptarVisitor(this);
		}

		this.listaDeLineas.add(lista.getSufijoHTML());
	}

	@Override
	public void visitar(Seccion seccion) {
		this.listaDeLineas.add(seccion.getPrefijoHTML());

		for(Etiqueta etiqueta : seccion.getListaDeElementos()){
			etiqueta.aceptarVisitor(this);
		}

		this.listaDeLineas.add(seccion.getSufijoHTML());		
	}
}
