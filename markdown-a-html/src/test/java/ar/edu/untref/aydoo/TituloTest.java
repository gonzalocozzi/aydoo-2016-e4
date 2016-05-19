package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TituloTest {
	
	@Test
	public void tituloSeCreaConPrefijo(){
		
		EtiquetaHTMLSimple titulo = new Titulo();
		
		String prefijo = titulo.getPrefijo();
		
		Assert.assertEquals("<h1>", prefijo);
	}	
	
	@Test
	public void tituloSeCreaConSufijo(){
		
		EtiquetaHTMLSimple titulo = new Titulo();
		
		String sufijo = titulo.getSufijo();
		
		Assert.assertEquals("</h1>", sufijo);
	}
	
	@Test
	public void seIncorporaTextoAlTitulo(){
		
		EtiquetaHTMLSimple titulo = new Titulo();		
		String contenido = "el titulo";
		titulo.setTexto(contenido);
		
		String textoDelTitulo = titulo.getTexto();
		
		Assert.assertEquals(contenido, textoDelTitulo);		
	}
	
	@Test
	public void tituloDevuelveHTML(){
		
		EtiquetaHTMLSimple titulo = new Titulo();		
		String contenido = "el titulo";
		titulo.setTexto(contenido);
		
		String tituloHTML = titulo.getHTML();
		
		Assert.assertEquals("<h1>el titulo</h1>", tituloHTML);	
	}
}
