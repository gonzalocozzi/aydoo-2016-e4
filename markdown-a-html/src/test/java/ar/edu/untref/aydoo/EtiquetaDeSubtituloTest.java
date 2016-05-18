package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class EtiquetaDeSubtituloTest {
	
	@Test
	public void subtituloSeCreaConPrefijo(){
		
		EtiquetaDeSubtitulo subtitulo = new EtiquetaDeSubtitulo();
		
		String prefijo = subtitulo.getPrefijo();
		
		Assert.assertEquals("<h2>", prefijo);
	}
	
	@Test
	public void subtituloSeCreaConSufijo(){
		
		EtiquetaDeSubtitulo subtitulo = new EtiquetaDeSubtitulo();
		
		String sufijo = subtitulo.getSufijo();
		
		Assert.assertEquals("</h2>", sufijo);
	}	
	
	@Test
	public void seIncorporaTextoAlSubtitulo(){
		
		EtiquetaDeSubtitulo subtitulo = new EtiquetaDeSubtitulo();		
		String contenido = "el subtitulo";
		subtitulo.setTexto(contenido);
		
		String textoDelSubtitulo = subtitulo.getTexto();
		
		Assert.assertEquals(contenido, textoDelSubtitulo);		
	}
	
	@Test
	public void subtituloDevuelveHTML(){
		
		EtiquetaDeSubtitulo subtitulo = new EtiquetaDeSubtitulo();		
		String contenido = "el subtitulo";
		subtitulo.setTexto(contenido);
		
		String subtituloHTML = subtitulo.getHTML();
		
		Assert.assertEquals("<h2>el subtitulo</h2>", subtituloHTML);	
	}

}
