package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class ListaSinOrden extends EtiquetaHTML {
	
	private ArrayList<ItemDeLista> listaDeItems;
	
	public ListaSinOrden(){
		this.prefijo = "<ul>";
		this.sufijo = "</ul>";
		this.listaDeItems = new ArrayList<>();
	}

	public void agregarItem(ItemDeLista item) {
		this.listaDeItems.add(item);		
	}	

	public ArrayList<ItemDeLista> getColeccionDeItems() {
		return this.listaDeItems;
	}
	
	public void aceptarVisitor(Visitor visitor){
		visitor.visitar(this);
	}
}
