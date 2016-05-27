package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CreadorDeEtiquetasTest {

	@Test
	public void seTieneLaRepresentacionDelTitulo(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertTrue(miCreador.getListaDeRepresentaciones().contains("#"));
	}

	@Test
	public void seTieneLaRepresentacionDelSubtitulo(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertTrue(miCreador.getListaDeRepresentaciones().contains("##"));
	}

	@Test
	public void seTieneLaRepresentacionDeLaImagen(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertTrue(miCreador.getListaDeRepresentaciones().contains("i:"));
	}

	@Test
	public void seTieneLaRepresentacionDeUnItem(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertTrue(miCreador.getListaDeRepresentaciones().contains("*"));
	}

	@Test
	public void seTieneLaRepresentacionDeUnaSeccion(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertTrue(miCreador.getListaDeRepresentaciones().contains("---"));
	}

	@Test
	public void seGeneraUnaListaDeUnaEtiquetaDeTipoTituloYSubtituloAPartirDeUnaLista(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		List<String> miLista = new LinkedList<String>();
		miLista.add("#tituloDePrueba");
		miLista.add("##subtituloDePrueba");
		Assert.assertEquals(Titulo.class, miCreador.crearListaDeEtiquetas(miLista).get(0).getClass());
		Assert.assertEquals(Subtitulo.class, miCreador.crearListaDeEtiquetas(miLista).get(1).getClass());
	}

	@Test
	public void seGeneraUnaListaDeEtiquetasDeUnaListaQueTieneLosEncabezadosDeTodosLosElementosDelDiccionario(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		List<String> miLista = new LinkedList<String>();
		miLista.add("#tituloDePrueba");
		miLista.add("i:estoEsUnaImagen.png");
		miLista.add("*esto es un item");
		miLista.add("---");
		miLista.add("##subtituloDePrueba");
		Assert.assertEquals(Titulo.class, miCreador.crearListaDeEtiquetas(miLista).get(0).getClass());
		Assert.assertEquals(Imagen.class, miCreador.crearListaDeEtiquetas(miLista).get(1).getClass());
		Assert.assertEquals(ItemDeLista.class, miCreador.crearListaDeEtiquetas(miLista).get(2).getClass());
		Assert.assertEquals(Seccion.class, miCreador.crearListaDeEtiquetas(miLista).get(3).getClass());
		Assert.assertEquals(Subtitulo.class, miCreador.crearListaDeEtiquetas(miLista).get(4).getClass());
	}

	@Test
	public void lasEtiquetasQueEstanEnLaListaGeneradaTienenSuCorrespondienteTexto(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		List<String> miLista = new LinkedList<String>();
		miLista.add("#tituloDePrueba");
		miLista.add("i:estoEsUnaImagen.png");
		miLista.add("*esto es un item");
		miLista.add("##subtituloDePrueba");
		Assert.assertEquals("tituloDePrueba", miCreador.crearListaDeEtiquetas(miLista).get(0).getTexto());
		Assert.assertEquals("estoEsUnaImagen.png", miCreador.crearListaDeEtiquetas(miLista).get(1).getTexto());
		Assert.assertEquals("esto es un item", miCreador.crearListaDeEtiquetas(miLista).get(2).getTexto());
		Assert.assertEquals("subtituloDePrueba", miCreador.crearListaDeEtiquetas(miLista).get(3).getTexto());
	}

	@Test
	public void sePuedeGenerarUnaEtiquetaDeTextoSinFormato(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		List<String> miLista = new LinkedList<String>();
		miLista.add("esto es un texto sin formato");
		Assert.assertEquals(TextoSinFormato.class, miCreador.crearListaDeEtiquetas(miLista).get(0).getClass());
		Assert.assertEquals("esto es un texto sin formato", miCreador.crearListaDeEtiquetas(miLista).get(0).getTexto());
	}

	@Test
	public void siElEncabezadoNoEstaAlPrincipioEntoncesEsUnTextoSinFormato(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		List<String> miLista = new LinkedList<String>();
		miLista.add("l## esto no es ni # un subtitulo ni titulo");
		miLista.add("ari:imagen.png");
		miLista.add("o*esto no va a ser un item");
		Assert.assertEquals(TextoSinFormato.class, miCreador.crearListaDeEtiquetas(miLista).get(0).getClass());
		Assert.assertEquals("l## esto no es ni # un subtitulo ni titulo", miCreador.crearListaDeEtiquetas(miLista).get(0).getTexto());
		Assert.assertEquals(TextoSinFormato.class, miCreador.crearListaDeEtiquetas(miLista).get(1).getClass());
		Assert.assertEquals("ari:imagen.png", miCreador.crearListaDeEtiquetas(miLista).get(1).getTexto());
		Assert.assertEquals(TextoSinFormato.class, miCreador.crearListaDeEtiquetas(miLista).get(2).getClass());
		Assert.assertEquals("o*esto no va a ser un item", miCreador.crearListaDeEtiquetas(miLista).get(2).getTexto());
	}

	@Test
	public void sePuedenCrearMasDeUnElementoDelMismoTipo(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		List<String> miLista = new LinkedList<String>();
		miLista.add("## subtitulo 1");
		miLista.add("#titulo");
		miLista.add("##subtitulo 2");
		miLista.add("#ab");
		Assert.assertEquals(Subtitulo.class, miCreador.crearListaDeEtiquetas(miLista).get(0).getClass());
		Assert.assertEquals(" subtitulo 1", miCreador.crearListaDeEtiquetas(miLista).get(0).getTexto());
		Assert.assertEquals(Titulo.class, miCreador.crearListaDeEtiquetas(miLista).get(1).getClass());
		Assert.assertEquals("titulo", miCreador.crearListaDeEtiquetas(miLista).get(1).getTexto());
		Assert.assertEquals(Subtitulo.class, miCreador.crearListaDeEtiquetas(miLista).get(2).getClass());
		Assert.assertEquals("subtitulo 2", miCreador.crearListaDeEtiquetas(miLista).get(2).getTexto());
		Assert.assertEquals(Titulo.class, miCreador.crearListaDeEtiquetas(miLista).get(3).getClass());
		Assert.assertEquals("ab", miCreador.crearListaDeEtiquetas(miLista).get(3).getTexto());
	}

	@Test
	public void seCreaEtiquetaDeSeccion(){

		CreadorDeEtiquetas creador = new CreadorDeEtiquetas();
		List<String> lista = new LinkedList<String>();
		lista.add("---");

		List<EtiquetaHTML> listaEtiquetaHTML = creador.crearListaDeEtiquetas(lista);

		Seccion seccion = new Seccion();
		List<EtiquetaHTML> listaEsperada = new LinkedList<EtiquetaHTML>();
		listaEsperada.add(seccion);

		Assert.assertEquals(listaEsperada.get(0).getClass(), listaEtiquetaHTML.get(0).getClass());
	}

	@Test
	public void seReproduceMiPresentacion1ParaFixearBug(){

		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		List<String> miLista = new LinkedList<String>();

		miLista.add("---");
		miLista.add("# slide1 :titulo 1");
		miLista.add("---");
		miLista.add("## slide2: titulo 2");
		miLista.add("---");
		miLista.add("slide 3");
		miLista.add("# titulo 1");
		miLista.add("## titulo 2");

		List<EtiquetaHTML> lista = miCreador.crearListaDeEtiquetas(miLista);

		Assert.assertEquals(Seccion.class,lista.get(0).getClass());
		Assert.assertEquals(Titulo.class, lista.get(1).getClass());
		Assert.assertEquals(Seccion.class, lista.get(2).getClass());
		Assert.assertEquals(Subtitulo.class, lista.get(3).getClass());
		Assert.assertEquals(Seccion.class, lista.get(4).getClass());
		Assert.assertEquals(TextoSinFormato.class, lista.get(5).getClass());
		Assert.assertEquals(Titulo.class, lista.get(6).getClass());
		Assert.assertEquals(Subtitulo.class, lista.get(7).getClass());
	}

	public void sePuedenGenerarEtiquetasSinTexto(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		List<String> miLista = new LinkedList<String>();
		List<EtiquetaHTML> listaGenerada = new LinkedList<EtiquetaHTML>();
		miLista.add("##");
		miLista.add("#");
		miLista.add("*");
		listaGenerada = miCreador.crearListaDeEtiquetas(miLista);
		Assert.assertEquals(Subtitulo.class, listaGenerada.get(0).getClass());
		Assert.assertEquals("", listaGenerada.get(0).getTexto());
		Assert.assertEquals(Titulo.class, listaGenerada.get(1).getClass());
		Assert.assertEquals("", listaGenerada.get(1).getTexto());
		Assert.assertEquals(ItemDeLista.class, listaGenerada.get(2).getClass());
		Assert.assertEquals("", listaGenerada.get(2).getTexto());
	}

	@Test
	public void puedoInsertarLineaVacia(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		List<String> miLista = new LinkedList<String>();
		List<EtiquetaHTML> listaGenerada = new LinkedList<EtiquetaHTML>();
		miLista.add("---");
		miLista.add("");//este es el espacio vacio que inserto
		miLista.add("# slide1 :titulo 1");
		miLista.add("---");
		miLista.add("slide 3");
		miLista.add("# titulo 1");
		miLista.add("## titulo 2");
		listaGenerada = miCreador.crearListaDeEtiquetas(miLista);
		Assert.assertEquals("", listaGenerada.get(1).getTexto());
	}
	
	@Test
	public void siSeRecibeAlgoQueContieneParcialmenteAUnEncabezadoEntoncesSigueSiendoUnTextoSinFormato(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		List<String> miLista = new LinkedList<String>();
		List<EtiquetaHTML> listaGenerada = new LinkedList<EtiquetaHTML>();
		miLista.add("--");
		listaGenerada = miCreador.crearListaDeEtiquetas(miLista);
		Assert.assertEquals("--", listaGenerada.get(0).getTexto());
	}
}