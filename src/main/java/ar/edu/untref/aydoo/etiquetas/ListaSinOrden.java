package ar.edu.untref.aydoo.etiquetas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitor;

public class ListaSinOrden extends Etiqueta {

	private List<ItemDeLista> listaDeItems;

	public ListaSinOrden(){
		this.prefijoHTML = "<ul>";
		this.sufijoHTML = "</ul>";
		this.listaDeItems = new LinkedList<ItemDeLista>();
	}

	public void agregarItem(ItemDeLista item) {
		this.listaDeItems.add(item);		
	}	

	public List<ItemDeLista> getColeccionDeItems() {
		return this.listaDeItems;
	}

	@Override
	public void aceptarVisitor(Visitor visitor){
		visitor.visitar(this);
	}

}
