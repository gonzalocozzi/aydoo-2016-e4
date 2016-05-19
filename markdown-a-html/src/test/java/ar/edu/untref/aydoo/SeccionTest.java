package ar.edu.untref.aydoo;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class SeccionTest {

	@Test
	public void seccionSeCreaConPrefijo(){

		Seccion seccion = new Seccion();

		String prefijo = seccion.getPrefijo();

		Assert.assertEquals("<section>", prefijo);
	}

	@Test
	public void seccionSeCreaConSufijo(){

		Seccion seccion = new Seccion();

		String sufijo = seccion.getSufijo();

		Assert.assertEquals("</section>", sufijo);
	}

	@Test
	public void seccionAgregaUnTitulo(){

		Seccion seccion = new Seccion();
		Titulo titulo = new Titulo();
		seccion.agregarElemento(titulo);

		ArrayList<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(titulo));
	}

	@Test
	public void seccionAgregaUnSubtitulo(){

		Seccion seccion = new Seccion();
		Subtitulo subtitulo = new Subtitulo();
		seccion.agregarElemento(subtitulo);

		ArrayList<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(subtitulo));
	}

	@Test
	public void seccionAgregaTextoSinFormato(){

		Seccion seccion = new Seccion();
		TextoSinFormato textoSinFormato = new TextoSinFormato("solo texto sin nada mas");
		seccion.agregarElemento(textoSinFormato);

		ArrayList<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(textoSinFormato));
	}

	@Test
	public void seccionAgregaUnaImagen(){

		Seccion seccion = new Seccion();
		Imagen imagen = new Imagen();
		seccion.agregarElemento(imagen);

		ArrayList<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(imagen));
	}

	@Test
	public void seccionDevuelveHTMLDeLosElementos(){

		Seccion seccion = new Seccion();

		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		seccion.agregarElemento(titulo);

		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		seccion.agregarElemento(subtitulo);

		TextoSinFormato textoSinFormato = new TextoSinFormato("solo texto sin nada mas");
		seccion.agregarElemento(textoSinFormato);

		String htmlDeLosElementos = seccion.getHTMLDeLosElementos();

		String finDeLinea = System.getProperty("line.separator");
		String htmlEsperado = "<h1>un titulo</h1>" + finDeLinea + "<h2>un subtitulo</h2>" + finDeLinea + "solo texto sin nada mas" + finDeLinea;

		Assert.assertEquals(htmlEsperado, htmlDeLosElementos);
	}

	@Test
	public void seccionDevuelveHTML(){

		Seccion seccion = new Seccion();

		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		seccion.agregarElemento(titulo);

		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		seccion.agregarElemento(subtitulo);

		TextoSinFormato textoSinFormato = new TextoSinFormato("solo texto sin nada mas");
		seccion.agregarElemento(textoSinFormato);
		
		String seccionHTML = seccion.getHTML();

		String finDeLinea = System.getProperty("line.separator");
		String htmlEsperado = "<section>" + finDeLinea + "<h1>un titulo</h1>" + finDeLinea + "<h2>un subtitulo</h2>" + finDeLinea + "solo texto sin nada mas" + finDeLinea + "</section>";

		Assert.assertEquals(htmlEsperado, seccionHTML);
	}

}
