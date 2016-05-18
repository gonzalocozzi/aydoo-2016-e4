package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TituloTest {
	
	@Test
	public void tituloSeCreaConPrefijo(){
		
		Titulo titulo = new Titulo();
		
		String prefijo = titulo.getPrefijo();
		
		Assert.assertEquals("<h1>", prefijo);
	}	
	
	@Test
	public void tituloSeCreaConSufijo(){
		
		Titulo titulo = new Titulo();
		
		String sufijo = titulo.getSufijo();
		
		Assert.assertEquals("</h1>", sufijo);
	}

}
