package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class ListaSinOrden {
	
	private String prefijo;
	private String sufijo;
	private ArrayList<ItemDeLista> listaDeItems;
	
	public ListaSinOrden(){
		this.prefijo = "<ul>";
		this.sufijo = "</ul>";
		this.listaDeItems = new ArrayList<>();
	}
	
	public String getPrefijo() {
		return this.prefijo;
	}

	public String getSufijo() {
		return this.sufijo;
	}

	public void agregarItem(ItemDeLista item) {
		this.listaDeItems.add(item);		
	}	

	public ArrayList<ItemDeLista> getColeccionDeItems() {
		return this.listaDeItems;
	}

	public String getHTMLDeLosItems() {
		
		String htmlDeLosItems = "";
		String finDeLinea = System.getProperty("line.separator");
		
		for(ItemDeLista item : listaDeItems){			
			htmlDeLosItems += item.getHTML();
			htmlDeLosItems +=  finDeLinea;
		}
		
		return htmlDeLosItems;
	}

}
