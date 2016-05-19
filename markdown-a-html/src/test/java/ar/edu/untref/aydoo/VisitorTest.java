package ar.edu.untref.aydoo;

import org.junit.Test;

import org.junit.Assert;

public class VisitorTest {
	
	@Test
	public void visitaUnTituloYPideContenido(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		EtiquetaHTMLSimple titulo = new Titulo();
		titulo.setTexto("un titulo");
		
		visitor.visitar(titulo);
		
		String resultadoEsperado = "<h1>un titulo</h1>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnSubtituloYPideContenido(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		EtiquetaHTMLSimple subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		
		visitor.visitar(subtitulo);
		
		String resultadoEsperado = "<h2>un subtitulo</h2>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnaImagen(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		EtiquetaHTMLSimple imagen = new Imagen();
		imagen.setTexto("imagen.jpg");
		
		visitor.visitar(imagen);
		
		String resultadoEsperado = "<img src=\"imagen.jpg\"/>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnTextoSinFormato(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		EtiquetaHTMLSimple textoSinFormato = new TextoSinFormato();
		textoSinFormato.setTexto("un texto");
		
		visitor.visitar(textoSinFormato);
		
		String resultadoEsperado = "un texto";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnItemDeLista(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		EtiquetaHTMLSimple itemDeLista = new ItemDeLista();
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
	
	@Test
	public void tituloAceptaElVisitor(){
		
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		titulo.aceptarVisitor(visitor);
		
		String resultadoEsperado = "<h1>un titulo</h1>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
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
	public void imagenAceptaElVisitor(){
		
		Imagen imagen = new Imagen();
		imagen.setTexto("imagen.jpg");
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		imagen.aceptarVisitor(visitor);
		
		String resultadoEsperado = "<img src=\"imagen.jpg\"/>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void itemDeListaAceptaElVisitor(){
		
		ItemDeLista itemDeLista = new ItemDeLista();
		itemDeLista.setTexto("item de lista");
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		itemDeLista.aceptarVisitor(visitor);
		
		String resultadoEsperado = "<li>item de lista</li>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void textSinFormatoAceptaElVisitor(){
		
		TextoSinFormato textoSinFormato = new TextoSinFormato();
		textoSinFormato.setTexto("texto");
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		textoSinFormato.aceptarVisitor(visitor);
		
		String resultadoEsperado = "texto";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
}
