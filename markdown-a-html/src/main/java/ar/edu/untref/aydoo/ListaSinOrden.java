package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class ListaSinOrden {
	
	private String prefijo;
	private String sufijo;
	private ArrayList<ItemDeLista> coleccionDeItems;
	
	public ListaSinOrden(){
		this.prefijo = "<ul>";
		this.sufijo = "</ul>";
		this.coleccionDeItems = new ArrayList<>();
	}
	
	public String getPrefijo() {
		return this.prefijo;
	}

	public String getSufijo() {
		return this.sufijo;
	}

	public void agregarItem(ItemDeLista item) {
		this.coleccionDeItems.add(item);		
	}	

	public ArrayList<ItemDeLista> getColeccionDeItems() {
		return this.coleccionDeItems;
	}

}
