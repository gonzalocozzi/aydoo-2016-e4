package ar.edu.untref.aydoo.etiquetas;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.creacionDeEtiquetas.VisitorDeEtiquetas;
import ar.edu.untref.aydoo.etiquetas.Subtitulo;

public class SubtituloTest {
	
	@Test
	public void subtituloSeCreaConPrefijo(){
		
		Subtitulo subtitulo = new Subtitulo();
		
		String prefijo = subtitulo.getPrefijoHTML();
		
		Assert.assertEquals("<h2>", prefijo);
	}
	
	@Test
	public void subtituloSeCreaConSufijo(){
		
		Subtitulo subtitulo = new Subtitulo();
		
		String sufijo = subtitulo.getSufijoHTML();
		
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
	public void subtituloAceptaElVisitor(){
		
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		subtitulo.aceptarVisitor(visitor);
		
		String resultadoEsperado = "<h2>un subtitulo</h2>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void elSubtituloSeCreaConSuEncabezadoMD(){
		Subtitulo subtitulo = new Subtitulo();
		String encabezadoObtenido = subtitulo.getEncabezadoMarkdown();
		
		String encabezadoEsperado = "##";
				
		Assert.assertEquals(encabezadoEsperado, encabezadoObtenido);
	}
	
	@Test
	public void elSubtituloSabeReconocerseYCrearseAPartirDeUnaEntradaMD(){
		String entrada = "## subtitulo de prueba";
		Subtitulo subtitulo = new Subtitulo();
		
		Assert.assertEquals(Subtitulo.class, subtitulo.crearDesdeArchivoMarkdown(entrada).getClass());
	}
	
}
