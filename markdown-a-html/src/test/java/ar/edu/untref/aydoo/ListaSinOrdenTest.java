package ar.edu.untref.aydoo;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ListaSinOrdenTest {
	
	@Test
	public void listaSinOrdenSeCreaConPrefijo(){
		
		ListaSinOrden lista = new ListaSinOrden();
		
		String prefijo = lista.getPrefijo();
		
		Assert.assertEquals("<ul>", prefijo);
	}
	
	@Test
	public void listaSinOrdenSeCreaConSufijo(){
		
		ListaSinOrden lista = new ListaSinOrden();
		
		String sufijo = lista.getSufijo();
		
		Assert.assertEquals("</ul>", sufijo);
	}
	
	@Test
	public void listaSinOrdenAgregaUnItem(){
		
		ListaSinOrden lista = new ListaSinOrden();
		ItemDeLista item = new ItemDeLista();
		item.setTexto("un item de la lista");
		lista.agregarItem(item);
		
		ArrayList<ItemDeLista> coleccionDeItems = lista.getColeccionDeItems();
		
		Assert.assertTrue(coleccionDeItems.contains(item));
	}
	
	@Test
	public void listaSinOrdenDevuelveHTMLDeLosItems(){
		
		ListaSinOrden lista = new ListaSinOrden();
		
		ItemDeLista item1 = new ItemDeLista();
		item1.setTexto("un item de la lista");
		lista.agregarItem(item1);
		
		ItemDeLista item2 = new ItemDeLista();
		item2.setTexto("otro item de la lista");
		lista.agregarItem(item2);
		
		String htmlDeLosItems = lista.getHTMLDeLosItems();
		
		String finDeLinea = System.getProperty("line.separator");
		String htmlEsperado = "<li>un item de la lista</li>" + finDeLinea + "<li>otro item de la lista</li>" + finDeLinea;
		
		Assert.assertEquals(htmlEsperado, htmlDeLosItems);
	}
	
	@Test
	public void listaSinOrdenDuvuelveHTML(){
		
		ListaSinOrden lista = new ListaSinOrden();
		
		ItemDeLista item1 = new ItemDeLista();
		item1.setTexto("un item de la lista");
		lista.agregarItem(item1);
		
		ItemDeLista item2 = new ItemDeLista();
		item2.setTexto("otro item de la lista");
		lista.agregarItem(item2);
		
		String listaSinOrdenHTML = lista.getHTML();
		
		String finDeLinea = System.getProperty("line.separator");
		
		String htmlEsperado = "<ul>" + finDeLinea + "<li>un item de la lista</li>" + finDeLinea + "<li>otro item de la lista</li>" + finDeLinea + "</ul>";
		
		Assert.assertEquals(htmlEsperado, listaSinOrdenHTML);
	}

}
