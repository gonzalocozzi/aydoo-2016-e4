package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import ar.edu.untref.aydoo.creacionDeEtiquetas.CreadorDeSalidaHTML;
import ar.edu.untref.aydoo.etiquetas.Etiqueta;
import ar.edu.untref.aydoo.etiquetas.Imagen;
import ar.edu.untref.aydoo.etiquetas.ItemDeLista;
import ar.edu.untref.aydoo.etiquetas.ListaSinOrden;
import ar.edu.untref.aydoo.etiquetas.Seccion;
import ar.edu.untref.aydoo.etiquetas.Subtitulo;
import ar.edu.untref.aydoo.etiquetas.TextoSinFormato;
import ar.edu.untref.aydoo.etiquetas.Titulo;

import org.junit.Assert;

public class CreadorDeSalidaHTMLTest {

	@Test
	public void recibeUnListaVacia(){
		
		List<Etiqueta> lista = new LinkedList<Etiqueta>();
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
	}
	
	@Test
	public void recibeUnaListaConUnTitulo(){
		
		List<Etiqueta> lista = new LinkedList<Etiqueta>();
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		lista.add(titulo);
		
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("<h1>un titulo</h1>");
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());	
	}
	
	@Test
	public void recibeUnaListaConUnSubtitulo(){
		
		List<Etiqueta> lista = new LinkedList<Etiqueta>();
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		lista.add(subtitulo);
		
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("<h2>un subtitulo</h2>");
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
	}
	
	@Test
	public void recibeUnaListaConUnaImagen(){
		
		List<Etiqueta> lista = new LinkedList<Etiqueta>();
		Imagen imagen = new Imagen();
		imagen.setTexto("imagen.jpg");
		lista.add(imagen);
		
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("<img src=\"imagen.jpg\"/>");
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
	}
	
	@Test
	public void recibeUnaListaConUnTituloYUnaImagen(){
		
		List<Etiqueta> lista = new LinkedList<Etiqueta>();
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		Imagen imagen = new Imagen();
		imagen.setTexto("imagen.jpg");

		lista.add(titulo);
		lista.add(imagen);
		
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("<h1>un titulo</h1>");
		listaEsperada.add("<img src=\"imagen.jpg\"/>");
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
	}
	
	@Test
	public void recibeUnaListaConUnSubtituloYUnTextoSinFormato(){
		
		List<Etiqueta> lista = new LinkedList<Etiqueta>();
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		TextoSinFormato textoSinFormato = new TextoSinFormato();
		textoSinFormato.setTexto("texto");

		lista.add(subtitulo);
		lista.add(textoSinFormato);
		
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("<h2>un subtitulo</h2>");
		listaEsperada.add("texto");
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
	}
	
	@Test
	public void recibeUnaListaConUnaSeccionConUnTitulo(){
		
		List<Etiqueta> lista = new LinkedList<Etiqueta>();
		Seccion seccion = new Seccion();
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		seccion.agregarElemento(titulo);
		
		lista.add(seccion);		
		
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("<section>");
		listaEsperada.add("<h1>un titulo</h1>");
		listaEsperada.add("</section>");
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
	}
	
	@Test
	public void recibeUnaListaConUnaSeccionConUnTituloYSubtitulo(){
		
		List<Etiqueta> lista = new LinkedList<Etiqueta>();
		Seccion seccion = new Seccion();
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		seccion.agregarElemento(titulo);
		seccion.agregarElemento(subtitulo);
				
		lista.add(seccion);		
		
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("<section>");
		listaEsperada.add("<h1>un titulo</h1>");
		listaEsperada.add("<h2>un subtitulo</h2>");
		listaEsperada.add("</section>");
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
	}
	
	@Test
	public void recibeUnaListaConUnaSeccionConUnTituloYUnaListaSinOrdenYUnItem(){
		
		List<Etiqueta> lista = new LinkedList<Etiqueta>();
		Seccion seccion = new Seccion();
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		ItemDeLista item1 = new ItemDeLista();
		item1.setTexto("item de lista");
		ListaSinOrden listaSinOrden = new ListaSinOrden();
		listaSinOrden.agregarItem(item1);
		
		seccion.agregarElemento(titulo);
		seccion.agregarElemento(listaSinOrden);
				
		lista.add(seccion);		
		
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("<section>");
		listaEsperada.add("<h1>un titulo</h1>");
		listaEsperada.add("<ul>");
		listaEsperada.add("<li>item de lista</li>");
		listaEsperada.add("</ul>");
		listaEsperada.add("</section>");
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
	}
	
	@Test
	public void recibeUnaListaConUnaSeccionConUnTituloYUnaListaSinOrdenYUnItemYUnaImagen(){
		
		List<Etiqueta> lista = new LinkedList<Etiqueta>();
		Seccion seccion = new Seccion();
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		ItemDeLista item1 = new ItemDeLista();
		item1.setTexto("item de lista");
		ListaSinOrden listaSinOrden = new ListaSinOrden();
		listaSinOrden.agregarItem(item1);
		Imagen imagen = new Imagen();
		imagen.setTexto("imagen.jpg");;
		
		seccion.agregarElemento(titulo);
		seccion.agregarElemento(listaSinOrden);
		seccion.agregarElemento(imagen);
		
		lista.add(seccion);		
		
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("<section>");
		listaEsperada.add("<h1>un titulo</h1>");
		listaEsperada.add("<ul>");
		listaEsperada.add("<li>item de lista</li>");
		listaEsperada.add("</ul>");
		listaEsperada.add("<img src=\"imagen.jpg\"/>");
		listaEsperada.add("</section>");
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
	}
	
	@Test
	public void recibeUnaListaConDosSeccionesConUnTitulo(){
		
		List<Etiqueta> lista = new LinkedList<Etiqueta>();
		Seccion seccion = new Seccion();
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		
		Seccion seccion1 = new Seccion();
		Titulo titulo1 = new Titulo();
		titulo1.setTexto("un titulo1");
		
		seccion.agregarElemento(titulo);
		seccion1.agregarElemento(titulo1);
				
		lista.add(seccion);	
		lista.add(seccion1);
		
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("<section>");
		listaEsperada.add("<h1>un titulo</h1>");
		listaEsperada.add("</section>");
		listaEsperada.add("<section>");
		listaEsperada.add("<h1>un titulo1</h1>");
		listaEsperada.add("</section>");
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
	}
	
	@Test
	public void recibeUnaListaConEjemploDeConsigna(){
		
		List<Etiqueta> lista = new LinkedList<Etiqueta>();
		Titulo titulo = new Titulo();
		titulo.setTexto("El titulo");
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("El subtitulo");
		
		Seccion seccion = new Seccion();
		seccion.agregarElemento(titulo);
		seccion.agregarElemento(subtitulo);
		
		Titulo titulo1 = new Titulo();
		titulo1.setTexto("Solo un titulo");
		
		Seccion seccion1 = new Seccion();
		seccion1.agregarElemento(titulo1);
		
		TextoSinFormato texto = new TextoSinFormato();
		texto.setTexto("solo texto sinnada mas");
		Seccion seccion2 = new Seccion();
		seccion2.agregarElemento(texto);
				
		lista.add(seccion);	
		lista.add(seccion1);
		lista.add(seccion2);
		
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("<section>");
		listaEsperada.add("<h1>El titulo</h1>");
		listaEsperada.add("<h2>El subtitulo</h2>");
		listaEsperada.add("</section>");
		listaEsperada.add("<section>");
		listaEsperada.add("<h1>Solo un titulo</h1>");
		listaEsperada.add("</section>");
		listaEsperada.add("<section>");
		listaEsperada.add("solo texto sinnada mas");
		listaEsperada.add("</section>");
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
	}
	
}
