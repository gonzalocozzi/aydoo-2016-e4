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

}
