package ar.edu.untref.aydoo;

import org.junit.Test;

import org.junit.Assert;

public class VisitorTest {
	
	@Test
	public void visitaUnTituloYPideContenido(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		
		visitor.visitar(titulo);
		
		String resultadoEsperado = "<h1>un titulo</h1>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnSubtituloYPideContenido(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		
		visitor.visitar(subtitulo);
		
		String resultadoEsperado = "<h2>un subtitulo</h2>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnaImagen(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		Imagen imagen = new Imagen();
		imagen.setTexto("imagen.jpg");
		
		visitor.visitar(imagen);
		
		String resultadoEsperado = "<img src=\"imagen.jpg\"/>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnTextoSinFormato(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		TextoSinFormato textoSinFormato = new TextoSinFormato();
		textoSinFormato.setTexto("un texto");
		
		visitor.visitar(textoSinFormato);
		
		String resultadoEsperado = "un texto";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnItemDeLista(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		ItemDeLista itemDeLista = new ItemDeLista();
		itemDeLista.setTexto("un item de lista");
		
		visitor.visitar(itemDeLista);
		
		String resultadoEsperado = "<li>un item de lista</li>";
				
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));		
	}
	
	@Test
	public void visitaUnaEtiquetaHtmlSimpleQueEsUnTitulo(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		EtiquetaHTMLSimple etiquetaGenerica = new Titulo();
		etiquetaGenerica.setTexto("texto");
		
		visitor.visitar(etiquetaGenerica);
		
		String resultadoEsperado = "<h1>texto</h1>";
				
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
}
