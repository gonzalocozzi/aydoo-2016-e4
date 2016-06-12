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
		String encabezadoObtenido = subtitulo.getEncabezado();
		
		String encabezadoEsperado = "##";
				
		Assert.assertEquals(encabezadoEsperado, encabezadoObtenido);
	}
	
	@Test
	public void elSubtituloSabeReconocerseYCrearseAPartirDeUnaEntrada(){
		String entrada = "## subtitulo de prueba";
		Subtitulo titulo = new Subtitulo();
		
		Assert.assertEquals(Subtitulo.class, titulo.crearConMd(entrada).getClass());
	}
}
