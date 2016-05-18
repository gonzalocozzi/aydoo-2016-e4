package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class EtiquetaDeTituloTest {
	
	@Test
	public void tituloSeCreaConPrefijo(){
		
		EtiquetaHTML titulo = new EtiquetaDeTitulo();
		
		String prefijo = titulo.getPrefijo();
		
		Assert.assertEquals("<h1>", prefijo);
	}	
	
	@Test
	public void tituloSeCreaConSufijo(){
		
		EtiquetaHTML titulo = new EtiquetaDeTitulo();
		
		String sufijo = titulo.getSufijo();
		
		Assert.assertEquals("</h1>", sufijo);
	}
	
	@Test
	public void seIncorporaTextoAlTitulo(){
		
		EtiquetaHTML titulo = new EtiquetaDeTitulo();		
		String contenido = "el titulo";
		titulo.setTexto(contenido);
		
		String textoDelTitulo = titulo.getTexto();
		
		Assert.assertEquals(contenido, textoDelTitulo);		
	}
	
	@Test
	public void tituloDevuelveHTML(){
		
		EtiquetaHTML titulo = new EtiquetaDeTitulo();		
		String contenido = "el titulo";
		titulo.setTexto(contenido);
		
		String tituloHTML = titulo.getHTML();
		
		Assert.assertEquals("<h1>el titulo</h1>", tituloHTML);	
	}

}
