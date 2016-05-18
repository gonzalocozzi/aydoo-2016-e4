package ar.edu.untref.aydoo;

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

}
