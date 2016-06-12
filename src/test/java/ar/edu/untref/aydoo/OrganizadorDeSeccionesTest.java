package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.EtiquetaHTML;
import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.Subtitulo;
import ar.edu.untref.aydoo.dominio.Titulo;

public class OrganizadorDeSeccionesTest {

	@Test
	public void unaSeccionContieneEtiquetasDentro(){
		OrganizadorDeSecciones organizadorDeSecciones = new OrganizadorDeSecciones();
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizadaObtenida = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaEsperada = new LinkedList<EtiquetaHTML>();
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
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizadaObtenida = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaEsperada = new LinkedList<EtiquetaHTML>();
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
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizadaObtenida = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaEsperada = new LinkedList<EtiquetaHTML>();
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
