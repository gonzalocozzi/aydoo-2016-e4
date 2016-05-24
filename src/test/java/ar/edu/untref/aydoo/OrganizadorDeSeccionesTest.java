package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

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
}
