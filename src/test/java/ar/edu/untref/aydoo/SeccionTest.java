package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.creacionDeEtiquetas.VisitorDeEtiquetas;
import ar.edu.untref.aydoo.etiquetas.EtiquetaHTML;
import ar.edu.untref.aydoo.etiquetas.Imagen;
import ar.edu.untref.aydoo.etiquetas.ListaSinOrden;
import ar.edu.untref.aydoo.etiquetas.Seccion;
import ar.edu.untref.aydoo.etiquetas.Subtitulo;
import ar.edu.untref.aydoo.etiquetas.TextoSinFormato;
import ar.edu.untref.aydoo.etiquetas.Titulo;

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
	public void seccionConTituloAceptaElVisitor(){
		
		Seccion seccion = new Seccion();
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		seccion.agregarElemento(titulo);
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		seccion.aceptarVisitor(visitor);
		
		List<String> listaDeLineasEsperada = new LinkedList<String>();
		listaDeLineasEsperada.add("<section>");
		listaDeLineasEsperada.add("<h1>un titulo</h1>");
		listaDeLineasEsperada.add("</section>");
		
		Assert.assertEquals(listaDeLineasEsperada, visitor.getListaDeLineas());
	}
	
	@Test
	public void seccionConUnSubtituloAceptaElVisitor(){
		
		Seccion seccion = new Seccion();
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		seccion.agregarElemento(subtitulo);
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		seccion.aceptarVisitor(visitor);
		
		List<String> listaDeLineasEsperada = new LinkedList<String>();
		listaDeLineasEsperada.add("<section>");
		listaDeLineasEsperada.add("<h2>un subtitulo</h2>");
		listaDeLineasEsperada.add("</section>");
		
		Assert.assertEquals(listaDeLineasEsperada, visitor.getListaDeLineas());
	}
	
	@Test
	public void seccionConUnTituloYUnaImagenAceptaElVisitor(){
		
		Seccion seccion = new Seccion();
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		Imagen imagen = new Imagen();
		imagen.setTexto("imagen.jpg");
		seccion.agregarElemento(titulo);
		seccion.agregarElemento(imagen);
		
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		seccion.aceptarVisitor(visitor);
		
		List<String> listaDeLineasEsperada = new LinkedList<String>();
		listaDeLineasEsperada.add("<section>");
		listaDeLineasEsperada.add("<h1>un titulo</h1>");
		listaDeLineasEsperada.add("<img src=\"imagen.jpg\"/>");
		listaDeLineasEsperada.add("</section>");
		
		Assert.assertEquals(listaDeLineasEsperada, visitor.getListaDeLineas());
	}
	
	@Test
	public void laSeccionSeCreaConSuEncabezadoMD(){
		Seccion seccion = new Seccion();
		String encabezadoObtenido = seccion.getEncabezado();
		
		String encabezadoEsperado = "---";
				
		Assert.assertEquals(encabezadoEsperado, encabezadoObtenido);
	}
	
	@Test
	public void laSeccionSabeReconocerseYCrearseAPartirDeUnaEntradaMD(){
		String entrada = "---";
		Seccion seccion = new Seccion();
		
		Assert.assertEquals(Seccion.class, seccion.crearConMD(entrada).getClass());
	}
}
