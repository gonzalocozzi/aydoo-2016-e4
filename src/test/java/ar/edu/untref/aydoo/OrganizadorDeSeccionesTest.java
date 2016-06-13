package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.creacionDeEtiquetas.OrganizadorDeSecciones;
import ar.edu.untref.aydoo.etiquetas.Etiqueta;
import ar.edu.untref.aydoo.etiquetas.Imagen;
import ar.edu.untref.aydoo.etiquetas.Seccion;
import ar.edu.untref.aydoo.etiquetas.Subtitulo;
import ar.edu.untref.aydoo.etiquetas.Titulo;

public class OrganizadorDeSeccionesTest {

	@Test
	public void unaSeccionContieneEtiquetasDentro(){
		OrganizadorDeSecciones organizadorDeSecciones = new OrganizadorDeSecciones();
		List<Etiqueta> listaDeEtiquetas = new LinkedList<Etiqueta>();
		List<Etiqueta> listaOrganizadaObtenida = new LinkedList<Etiqueta>();
		List<Etiqueta> listaEsperada = new LinkedList<Etiqueta>();
		Seccion seccion = new Seccion();
		Titulo titulo = new Titulo();
		Subtitulo subtitulo = new Subtitulo();
		listaDeEtiquetas.add(seccion);
		listaDeEtiquetas.add(titulo);
		listaDeEtiquetas.add(subtitulo);
		listaOrganizadaObtenida = organizadorDeSecciones.organizar(listaDeEtiquetas);
		seccion.agregarElemento(titulo);
		seccion.agregarElemento(subtitulo);
		listaEsperada.add(seccion);
		
		Assert.assertEquals(listaEsperada, listaOrganizadaObtenida);
	}

	@Test
	public void unaSeccionDetectaCuandoTerminaYEmpiezaLaSiguiente(){
		OrganizadorDeSecciones organizadorDeSecciones = new OrganizadorDeSecciones();
		List<Etiqueta> listaDeEtiquetas = new LinkedList<Etiqueta>();
		List<Etiqueta> listaOrganizadaObtenida = new LinkedList<Etiqueta>();
		List<Etiqueta> listaEsperada = new LinkedList<Etiqueta>();
		Seccion seccion1 = new Seccion();
		Titulo titulo = new Titulo();
		Seccion seccion2 = new Seccion();
		Subtitulo subtitulo = new Subtitulo();
		listaDeEtiquetas.add(seccion1);
		listaDeEtiquetas.add(titulo);
		listaDeEtiquetas.add(seccion2);
		listaDeEtiquetas.add(subtitulo);
		listaOrganizadaObtenida = organizadorDeSecciones.organizar(listaDeEtiquetas);
		seccion1.agregarElemento(titulo);
		seccion2.agregarElemento(subtitulo);
		listaEsperada.add(seccion1);
		listaEsperada.add(seccion2);
		
		Assert.assertEquals(listaEsperada, listaOrganizadaObtenida);
	}

	@Test
	public void siUnaEtiquetaHTMLEstaAntesDeQueComiencenLasSeccionesEntoncesNoEstaEnNingunaSeccion(){
		OrganizadorDeSecciones organizadorDeSecciones = new OrganizadorDeSecciones();
		List<Etiqueta> listaDeEtiquetas = new LinkedList<Etiqueta>();
		List<Etiqueta> listaOrganizadaObtenida = new LinkedList<Etiqueta>();
		List<Etiqueta> listaEsperada = new LinkedList<Etiqueta>();
		Imagen imagen = new Imagen();
		Seccion seccion1 = new Seccion();
		Titulo titulo = new Titulo();
		Seccion seccion2 = new Seccion();
		Subtitulo subtitulo = new Subtitulo();
		listaDeEtiquetas.add(imagen);
		listaDeEtiquetas.add(seccion1);
		listaDeEtiquetas.add(titulo);
		listaDeEtiquetas.add(seccion2);
		listaDeEtiquetas.add(subtitulo);
		listaOrganizadaObtenida = organizadorDeSecciones.organizar(listaDeEtiquetas);
		seccion1.agregarElemento(titulo);
		seccion2.agregarElemento(subtitulo);
		listaEsperada.add(imagen);
		listaEsperada.add(seccion1);
		listaEsperada.add(seccion2);
		
		Assert.assertEquals(listaEsperada, listaOrganizadaObtenida);
	}
}
