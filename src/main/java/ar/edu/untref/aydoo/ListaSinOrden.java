package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class ListaSinOrden extends EtiquetaHTML {

	private List<ItemDeLista> listaDeItems;

	public ListaSinOrden(){
		this.prefijo = "<ul>";
		this.sufijo = "</ul>";
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
