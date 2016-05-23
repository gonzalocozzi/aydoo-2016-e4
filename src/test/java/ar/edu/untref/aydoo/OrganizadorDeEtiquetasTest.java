package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class OrganizadorDeEtiquetasTest {

	@Test
	public void siHayUnaSeccionAbiertaLasEtiquetasQueLeSiguenSeAgreganALaSeccion(){
		OrganizadorDeEtiquetas miOrganizador = new OrganizadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizada = new LinkedList<EtiquetaHTML>();
		listaDeEtiquetas.add(new Seccion());
		listaDeEtiquetas.add(new Titulo());
		listaDeEtiquetas.add(new Subtitulo());
		listaOrganizada = miOrganizador.organizarEtiquetasHTML(listaDeEtiquetas);
		Seccion seccion = (Seccion) listaOrganizada.get(0);
		Assert.assertEquals(Seccion.class, listaOrganizada.get(0).getClass());
		Assert.assertEquals(Titulo.class, seccion.getListaDeElementos().get(0).getClass());
		Assert.assertEquals(Subtitulo.class, seccion.getListaDeElementos().get(1).getClass());
	}
	
	@Test
	public void siNoSeAbreSeccionSeGuardanLasEtiquetasFueraDeLaSeccion(){
		OrganizadorDeEtiquetas miOrganizador = new OrganizadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizada = new LinkedList<EtiquetaHTML>();
		listaDeEtiquetas.add(new Imagen());
		listaDeEtiquetas.add(new Subtitulo());
		listaOrganizada = miOrganizador.organizarEtiquetasHTML(listaDeEtiquetas);
		Assert.assertEquals(Imagen.class, listaOrganizada.get(0).getClass());
		Assert.assertEquals(Subtitulo.class, listaOrganizada.get(1).getClass());
	}
	
	@Test
	public void seDetectaQueHayUnCambioDeSeccion(){
		OrganizadorDeEtiquetas miOrganizador = new OrganizadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizada = new LinkedList<EtiquetaHTML>();
		listaDeEtiquetas.add(new Seccion());
		listaDeEtiquetas.add(new Titulo());
		listaDeEtiquetas.add(new Seccion());
		listaDeEtiquetas.add(new Subtitulo());
		listaOrganizada = miOrganizador.organizarEtiquetasHTML(listaDeEtiquetas);
		Seccion seccion1 = (Seccion) listaOrganizada.get(0);
		Seccion seccion2 = (Seccion) listaOrganizada.get(1);
		Assert.assertEquals(Seccion.class, listaOrganizada.get(0).getClass());
		Assert.assertEquals(Titulo.class, seccion1.getListaDeElementos().get(0).getClass());
		Assert.assertEquals(Subtitulo.class, seccion2.getListaDeElementos().get(0).getClass());
	}
}
