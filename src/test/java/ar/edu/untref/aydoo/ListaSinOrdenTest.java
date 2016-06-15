package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.creacionDeEtiquetas.VisitorDeEtiquetas;
import ar.edu.untref.aydoo.etiquetas.ItemDeLista;
import ar.edu.untref.aydoo.etiquetas.ListaSinOrden;

public class ListaSinOrdenTest {
	
	@Test
	public void listaSinOrdenSeCreaConPrefijo(){
		
		ListaSinOrden lista = new ListaSinOrden();
		
		String prefijo = lista.getPrefijoHTML();
		
		Assert.assertEquals("<ul>", prefijo);
	}
	
	@Test
	public void listaSinOrdenSeCreaConSufijo(){
		
		ListaSinOrden lista = new ListaSinOrden();
		
		String sufijo = lista.getSufijoHTML();
		
		Assert.assertEquals("</ul>", sufijo);
	}
	
	@Test
	public void listaSinOrdenAgregaUnItem(){
		
		ListaSinOrden lista = new ListaSinOrden();
		ItemDeLista item = new ItemDeLista();
		lista.agregarItem(item);
		
		List<ItemDeLista> listaDeItems = lista.getColeccionDeItems();
		
		Assert.assertTrue(listaDeItems.contains(item));
	}
	
	@Test
	public void listaSinOrdenConUnItemAceptaUnVisitor(){
			
		ListaSinOrden lista = new ListaSinOrden();
		ItemDeLista item = new ItemDeLista();
		
		item.setTexto("item de lista");
		lista.agregarItem(item);
			
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("<ul>");
		listaDeLineas.add("<li>item de lista</li>");
		listaDeLineas.add("</ul>");
			
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		lista.aceptarVisitor(visitor);
			
		Assert.assertEquals(listaDeLineas,visitor.getListaDeLineas());
	}
	
}
