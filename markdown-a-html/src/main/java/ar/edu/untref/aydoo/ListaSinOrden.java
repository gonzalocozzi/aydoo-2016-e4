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
/**
	public String getHTMLDeLosItems() {		
		String htmlDeLosItems = "";
		String finDeLinea = System.getProperty("line.separator");
		
		for(ItemDeLista item : this.listaDeItems){			
			htmlDeLosItems += item.getHTML();
			htmlDeLosItems +=  finDeLinea;
		}
		
		return htmlDeLosItems;
	}

	public String getHTML() {		
		String htmlDeLosItems = this.getHTMLDeLosItems();
		String finDeLinea = System.getProperty("line.separator");		
		
		String html = this.prefijo + finDeLinea + htmlDeLosItems + this.sufijo;
		
		return html;
	}
*/
}
