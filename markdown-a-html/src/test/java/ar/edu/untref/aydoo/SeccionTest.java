package ar.edu.untref.aydoo;

import java.util.List;

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

		List<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(titulo));
	}

	@Test
	public void seccionAgregaUnSubtitulo(){

		Seccion seccion = new Seccion();
		Subtitulo subtitulo = new Subtitulo();
		seccion.agregarElemento(subtitulo);

		List<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(subtitulo));
	}

	@Test
	public void seccionAgregaTextoSinFormato(){

		Seccion seccion = new Seccion();
		TextoSinFormato textoSinFormato = new TextoSinFormato();
		textoSinFormato.setTexto("solo texto sin nada mas");
		seccion.agregarElemento(textoSinFormato);

		List<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(textoSinFormato));
	}

	@Test
	public void seccionAgregaUnaImagen(){

		Seccion seccion = new Seccion();
		Imagen imagen = new Imagen();
		seccion.agregarElemento(imagen);

		List<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(imagen));
	}

	@Test
	public void seccionAgregaUnaListaSinOrden(){

		Seccion seccion = new Seccion();
		ListaSinOrden listaSinOrden = new ListaSinOrden();

		seccion.agregarElemento(listaSinOrden);

		List<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(listaSinOrden));
	}

	@Test
	public void seccionAgregaUnaSeccion(){

		Seccion seccionContenedora = new Seccion();
		Seccion seccionContenida = new Seccion();

		seccionContenedora.agregarElemento(seccionContenida);

		List<EtiquetaHTML> listaDeElementos = seccionContenedora.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(seccionContenida));
	}
/**
	@Test
	public void seccionDevuelveHTMLDeLosElementos(){

		Seccion seccion = new Seccion();

		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		seccion.agregarElemento(titulo);

		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		seccion.agregarElemento(subtitulo);

		TextoSinFormato textoSinFormato = new TextoSinFormato();
		textoSinFormato.setTexto("solo texto sin nada mas");
		seccion.agregarElemento(textoSinFormato);

		ListaSinOrden listaSinOrden = new ListaSinOrden();
		ItemDeLista item1 = new ItemDeLista();
		item1.setTexto("un item de la lista");
		listaSinOrden.agregarItem(item1);		
		seccion.agregarElemento(listaSinOrden);

		String htmlDeLosElementos = seccion.getHTMLDeLosElementos();

		String finDeLinea = System.getProperty("line.separator");
		String htmlEsperado = "<h1>un titulo</h1>" + finDeLinea + "<h2>un subtitulo</h2>" + finDeLinea + "solo texto sin nada mas" + finDeLinea + "<ul>" + finDeLinea + "<li>un item de la lista</li>" + finDeLinea + "</ul>" + finDeLinea;

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

		TextoSinFormato textoSinFormato = new TextoSinFormato();
		textoSinFormato.setTexto("solo texto sin nada mas");
		seccion.agregarElemento(textoSinFormato);
		
		ListaSinOrden listaSinOrden = new ListaSinOrden();
		ItemDeLista item1 = new ItemDeLista();
		item1.setTexto("un item de la lista");
		listaSinOrden.agregarItem(item1);		
		seccion.agregarElemento(listaSinOrden);

		String seccionHTML = seccion.getHTML();

		String finDeLinea = System.getProperty("line.separator");
		String htmlEsperado = "<section>" + finDeLinea + "<h1>un titulo</h1>" + finDeLinea + "<h2>un subtitulo</h2>" + finDeLinea + "solo texto sin nada mas" + finDeLinea + "<ul>" + finDeLinea + "<li>un item de la lista</li>" + finDeLinea + "</ul>" + finDeLinea + "</section>";

		Assert.assertEquals(htmlEsperado, seccionHTML);
	}
*/
}
