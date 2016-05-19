package ar.edu.untref.aydoo;

import org.junit.Test;

import org.junit.Assert;

public class VisitorTest {
	
	@Test
	public void visitaUnTituloYPideContenido(){
		
		Visitor visitor = new Visitor();
		
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		
		visitor.visitar(titulo);
		
		String resultadoEsperado = "<h1>un titulo</h1>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnSubtituloYPideContenido(){
		
		Visitor visitor = new Visitor();
		
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		
		visitor.visitar(subtitulo);
		
		String resultadoEsperado = "<h2>un subtitulo</h2>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnaImagen(){
		
		Visitor visitor = new Visitor();
		
		Imagen imagen = new Imagen();
		imagen.setTexto("imagen.jpg");
		
		visitor.visitar(imagen);
		
		String resultadoEsperado = "<img src=\"imagen.jpg\"/>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnTextoSinFormato(){
		
		Visitor visitor = new Visitor();
		
		TextoSinFormato textoSinFormato = new TextoSinFormato();
		textoSinFormato.setTexto("un texto");
		
		visitor.visitarTextSinFormato(textoSinFormato);
		
		String resultadoEsperado = "un texto";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}

}
