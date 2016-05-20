package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

public class VisitorTest {
	
	@Test
	public void visitaUnTituloYPideContenido(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		EtiquetaHTML titulo = new Titulo();
		titulo.setTexto("un titulo");
		
		visitor.visitar(titulo);
		
		String resultadoEsperado = "<h1>un titulo</h1>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnSubtituloYPideContenido(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		EtiquetaHTML subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		
		visitor.visitar(subtitulo);
		
		String resultadoEsperado = "<h2>un subtitulo</h2>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnaImagen(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		EtiquetaHTML imagen = new Imagen();
		imagen.setTexto("imagen.jpg");
		
		visitor.visitar(imagen);
		
		String resultadoEsperado = "<img src=\"imagen.jpg\"/>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnTextoSinFormato(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		EtiquetaHTML textoSinFormato = new TextoSinFormato();
		textoSinFormato.setTexto("un texto");
		
		visitor.visitar(textoSinFormato);
		
		String resultadoEsperado = "un texto";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnItemDeLista(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		EtiquetaHTML itemDeLista = new ItemDeLista();
		itemDeLista.setTexto("un item de lista");
		
		visitor.visitar(itemDeLista);
		
		String resultadoEsperado = "<li>un item de lista</li>";
				
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));		
	}
	
	@Test
	public void visitaUnaEtiquetaHtmlSimpleQueEsUnTitulo(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		EtiquetaHTML etiquetaGenerica = new Titulo();
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
	
	@Test
	public void visitaUnaSeccionConTitulo(){
		
		Seccion seccion = new Seccion();
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		
		seccion.agregarElemento(titulo);
		
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("<section>");
		listaDeLineas.add("<h1>un titulo</h1>");
		listaDeLineas.add("</section>");
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		visitor.visitar(seccion);
		
		Assert.assertEquals(listaDeLineas.get(0)+listaDeLineas.get(1)+listaDeLineas.get(2), visitor.getListaDeLineas().get(0)+visitor.getListaDeLineas().get(1)+visitor.getListaDeLineas().get(2));
	}
	
	@Test
	public void visitaUnaSeccionConSubtitulo(){
		
		Seccion seccion = new Seccion();
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		
		seccion.agregarElemento(subtitulo);
		
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("<section>");
		listaDeLineas.add("<h2>un subtitulo</h2>");
		listaDeLineas.add("</section>");
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		visitor.visitar(seccion);
		
		Assert.assertEquals(listaDeLineas.get(0)+listaDeLineas.get(1)+listaDeLineas.get(2), visitor.getListaDeLineas().get(0)+visitor.getListaDeLineas().get(1)+visitor.getListaDeLineas().get(2));
	}
	
	@Test
	public void visitaUnaSeccionConImagen(){
		
		Seccion seccion = new Seccion();
		Imagen imagen = new Imagen();
		imagen.setTexto("imagen.jpg");
		
		seccion.agregarElemento(imagen);
		
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("<section>");
		listaDeLineas.add("<img src=\"imagen.jpg\"/>");
		listaDeLineas.add("</section>");
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		visitor.visitar(seccion);
		
		Assert.assertEquals(listaDeLineas.get(0)+listaDeLineas.get(1)+listaDeLineas.get(2), visitor.getListaDeLineas().get(0)+visitor.getListaDeLineas().get(1)+visitor.getListaDeLineas().get(2));
	}
	
	@Test
	public void visitaUnaSeccionConTextoSinFormato(){
		
		Seccion seccion = new Seccion();
		TextoSinFormato textoSinFormato = new TextoSinFormato();
		textoSinFormato.setTexto("text sin formato");
		
		seccion.agregarElemento(textoSinFormato);
		
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("<section>");
		listaDeLineas.add("text sin formato");
		listaDeLineas.add("</section>");
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		visitor.visitar(seccion);
		
		Assert.assertEquals(listaDeLineas.get(0)+listaDeLineas.get(1)+listaDeLineas.get(2), visitor.getListaDeLineas().get(0)+visitor.getListaDeLineas().get(1)+visitor.getListaDeLineas().get(2));
	
	}
	
}
