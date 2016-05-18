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

}
