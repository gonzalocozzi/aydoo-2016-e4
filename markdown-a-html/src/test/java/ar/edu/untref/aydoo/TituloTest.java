package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TituloTest {
	
	@Test
	public void tituloSeCreaConPrefijo(){
		
		EtiquetaHTML titulo = new Titulo();
		
		String prefijo = titulo.getPrefijo();
		
		Assert.assertEquals("<h1>", prefijo);
	}	
	
	@Test
	public void tituloSeCreaConSufijo(){
		
		EtiquetaHTML titulo = new Titulo();
		
		String sufijo = titulo.getSufijo();
		
		Assert.assertEquals("</h1>", sufijo);
	}
	
	@Test
	public void seIncorporaTextoAlTitulo(){
		
		EtiquetaHTML titulo = new Titulo();		
		String contenido = "el titulo";
		titulo.setTexto(contenido);
		
		String textoDelTitulo = titulo.getTexto();
		
		Assert.assertEquals(contenido, textoDelTitulo);		
	}
}
