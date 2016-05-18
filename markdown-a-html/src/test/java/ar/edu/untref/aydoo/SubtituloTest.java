package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SubtituloTest {
	
	@Test
	public void subtituloSeCreaConPrefijo(){
		
		Subtitulo subtitulo = new Subtitulo();
		
		String prefijo = subtitulo.getPrefijo();
		
		Assert.assertEquals("<h2>", prefijo);
	}
	
	@Test
	public void subtituloSeCreaConSufijo(){
		
		Subtitulo subtitulo = new Subtitulo();
		
		String sufijo = subtitulo.getSufijo();
		
		Assert.assertEquals("</h2>", sufijo);
	}	
	
	@Test
	public void seIncorporaTextoAlSubtitulo(){
		
		Subtitulo subtitulo = new Subtitulo();		
		String contenido = "el subtitulo";
		subtitulo.setTexto(contenido);
		
		String textoDelSubtitulo = subtitulo.getTexto();
		
		Assert.assertEquals(contenido, textoDelSubtitulo);		
	}
	
	@Test
	public void subtituloDevuelveHTML(){
		
		Subtitulo subtitulo = new Subtitulo();		
		String contenido = "el subtitulo";
		subtitulo.setTexto(contenido);
		
		String subtituloHTML = subtitulo.getHTML();
		
		Assert.assertEquals("<h2>el subtitulo</h2>", subtituloHTML);	
	}

}
