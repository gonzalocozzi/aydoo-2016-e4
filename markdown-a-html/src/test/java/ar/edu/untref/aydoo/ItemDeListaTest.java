package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ItemDeListaTest {
	
	@Test
	public void itemDeListaSeCreaConPrefijo(){
		
		EtiquetaHTML itemDeLista = new ItemDeLista();
		
		String prefijo = itemDeLista.getPrefijo();
		
		Assert.assertEquals("<li>", prefijo);
	}	
	
	@Test
	public void itemDeListaSeCreaConSufijo(){
		
		EtiquetaHTML itemDeLista = new ItemDeLista();
		
		String sufijo = itemDeLista.getSufijo();
		
		Assert.assertEquals("</li>", sufijo);
	}
	
}
