package ar.edu.untref.aydoo.creacionDeEtiquetas;

import org.junit.Test;

import ar.edu.untref.aydoo.creacionDeEtiquetas.VisitorDeEtiquetas;
import ar.edu.untref.aydoo.etiquetas.Etiqueta;
import ar.edu.untref.aydoo.etiquetas.Imagen;
import ar.edu.untref.aydoo.etiquetas.ItemDeLista;
import ar.edu.untref.aydoo.etiquetas.ListaSinOrden;
import ar.edu.untref.aydoo.etiquetas.Seccion;
import ar.edu.untref.aydoo.etiquetas.Subtitulo;
import ar.edu.untref.aydoo.etiquetas.TextoSinFormato;
import ar.edu.untref.aydoo.etiquetas.Titulo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

public class VisitorDeEtiquetasTest {
	
	@Test
	public void visitaUnTituloYPideContenido(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		Etiqueta titulo = new Titulo();
		titulo.setTexto("un titulo");
		
		visitor.visitar(titulo);
		
		String resultadoEsperado = "<h1>un titulo</h1>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnSubtituloYPideContenido(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		Etiqueta subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		
		visitor.visitar(subtitulo);
		
		String resultadoEsperado = "<h2>un subtitulo</h2>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnaImagen(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		Etiqueta imagen = new Imagen();
		imagen.setTexto("imagen.jpg");
		
		visitor.visitar(imagen);
		
		String resultadoEsperado = "<img src=\"imagen.jpg\"/>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnTextoSinFormato(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		Etiqueta textoSinFormato = new TextoSinFormato();
		textoSinFormato.setTexto("un texto");
		
		visitor.visitar(textoSinFormato);
		
		String resultadoEsperado = "un texto";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void visitaUnItemDeLista(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		Etiqueta itemDeLista = new ItemDeLista();
		itemDeLista.setTexto("un item de lista");
		
		visitor.visitar(itemDeLista);
		
		String resultadoEsperado = "<li>un item de lista</li>";
				
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));		
	}
	
	@Test
	public void visitaUnaEtiquetaHtmlSimpleQueEsUnTitulo(){
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		
		Etiqueta etiquetaGenerica = new Titulo();
		etiquetaGenerica.setTexto("texto");
		
		visitor.visitar(etiquetaGenerica);
		
		String resultadoEsperado = "<h1>texto</h1>";
				
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
		
		Assert.assertEquals(listaDeLineas,visitor.getListaDeLineas());
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
		
		Assert.assertEquals(listaDeLineas,visitor.getListaDeLineas());
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
		
		Assert.assertEquals(listaDeLineas,visitor.getListaDeLineas());
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
		
		Assert.assertEquals(listaDeLineas,visitor.getListaDeLineas());
	}
	
	@Test
	public void visitaUnaSeccionConUnTituloYConUnSubtitulo(){
		
		Seccion seccion = new Seccion();
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		
		seccion.agregarElemento(titulo);
		seccion.agregarElemento(subtitulo);
		
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("<section>");
		listaDeLineas.add("<h1>un titulo</h1>");
		listaDeLineas.add("<h2>un subtitulo</h2>");
		listaDeLineas.add("</section>");
				
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		visitor.visitar(seccion);
		
		Assert.assertEquals(listaDeLineas,visitor.getListaDeLineas());
	}	
	
	@Test
	public void visitaUnaSeccionConUnTituloYConUnSubtituloYUnaImagen(){
		
		Seccion seccion = new Seccion();
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		Imagen imagen = new Imagen();
		imagen.setTexto("imagen.jpg");
		
		seccion.agregarElemento(titulo);
		seccion.agregarElemento(subtitulo);
		seccion.agregarElemento(imagen);
		
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("<section>");
		listaDeLineas.add("<h1>un titulo</h1>");
		listaDeLineas.add("<h2>un subtitulo</h2>");
		listaDeLineas.add("<img src=\"imagen.jpg\"/>");
		listaDeLineas.add("</section>");
				
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		visitor.visitar(seccion);
		
		Assert.assertEquals(listaDeLineas,visitor.getListaDeLineas());
	}
	
	@Test
	public void visitaUnaListaSinOrdenConUnItem(){
		
		ListaSinOrden lista = new ListaSinOrden();
		ItemDeLista item = new ItemDeLista();
		
		item.setTexto("item de lista");
		lista.agregarItem(item);
			
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("<ul>");
		listaDeLineas.add("<li>item de lista</li>");
		listaDeLineas.add("</ul>");
			
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		visitor.visitar(lista);
			
		Assert.assertEquals(listaDeLineas,visitor.getListaDeLineas());		
	}
	
	@Test
	public void visitaUnaListaSinOrdenConDosItems(){
		
		ListaSinOrden lista = new ListaSinOrden();
		
		ItemDeLista item = new ItemDeLista();
		item.setTexto("item de lista");
		
		ItemDeLista item2 = new ItemDeLista();
		item2.setTexto("item2 de lista");
		
		lista.agregarItem(item);
		lista.agregarItem(item2);
			
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("<ul>");
		listaDeLineas.add("<li>item de lista</li>");
		listaDeLineas.add("<li>item2 de lista</li>");
		listaDeLineas.add("</ul>");
			
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		visitor.visitar(lista);
			
		Assert.assertEquals(listaDeLineas,visitor.getListaDeLineas());		
	}
	
	@Test
	public void seccionConTituloYListaSinOrden(){
		
		Seccion seccion = new Seccion();
		
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		
		ListaSinOrden lista = new ListaSinOrden();
		ItemDeLista item1 = new ItemDeLista();
		item1.setTexto("item1");
		lista.agregarItem(item1);
		
		seccion.agregarElemento(titulo);
		seccion.agregarElemento(lista);
				
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("<section>");
		listaDeLineas.add("<h1>un titulo</h1>");
		listaDeLineas.add("<ul>");
		listaDeLineas.add("<li>item1</li>");
		listaDeLineas.add("</ul>");
		listaDeLineas.add("</section>");
				
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		visitor.visitar(seccion);
		
		Assert.assertEquals(listaDeLineas,visitor.getListaDeLineas());
	}
	
	@Test
	public void seccionConTituloConSubtituloYDosListaSSinOrdenConDosItem(){
		
		Seccion seccion = new Seccion();
		
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		
		ItemDeLista item1 = new ItemDeLista();
		ItemDeLista item2 = new ItemDeLista();
		item1.setTexto("item1");
		item2.setTexto("item2");
		
		ListaSinOrden lista = new ListaSinOrden();		
		lista.agregarItem(item1);
		lista.agregarItem(item2);
		
		ItemDeLista item3 = new ItemDeLista();
		ItemDeLista item4 = new ItemDeLista();
		item3.setTexto("item3");
		item4.setTexto("item4");
		
		ListaSinOrden lista2 = new ListaSinOrden();		
		lista2.agregarItem(item3);
		lista2.agregarItem(item4);
		
		seccion.agregarElemento(titulo);
		seccion.agregarElemento(subtitulo);
		seccion.agregarElemento(lista);
		seccion.agregarElemento(lista2);
				
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("<section>");
		listaDeLineas.add("<h1>un titulo</h1>");
		listaDeLineas.add("<h2>un subtitulo</h2>");
		listaDeLineas.add("<ul>");
		listaDeLineas.add("<li>item1</li>");
		listaDeLineas.add("<li>item2</li>");
		listaDeLineas.add("</ul>");
		listaDeLineas.add("<ul>");
		listaDeLineas.add("<li>item3</li>");
		listaDeLineas.add("<li>item4</li>");
		listaDeLineas.add("</ul>");
		listaDeLineas.add("</section>");
				
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		visitor.visitar(seccion);
		
		Assert.assertEquals(listaDeLineas,visitor.getListaDeLineas());
	}
	
}
