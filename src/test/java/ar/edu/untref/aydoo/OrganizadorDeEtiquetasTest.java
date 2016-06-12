package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.EtiquetaHTML;
import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.ItemDeLista;
import ar.edu.untref.aydoo.dominio.ListaSinOrden;
import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.Subtitulo;
import ar.edu.untref.aydoo.dominio.TextoSinFormato;
import ar.edu.untref.aydoo.dominio.Titulo;

public class OrganizadorDeEtiquetasTest {

	@Test
	public void siHayUnaSeccionAbiertaLasEtiquetasQueLeSiguenSeAgreganALaSeccion(){
		OrganizadorDeEtiquetas miOrganizador = new OrganizadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizada = new LinkedList<EtiquetaHTML>();
		listaDeEtiquetas.add(new Seccion());
		listaDeEtiquetas.add(new Titulo());
		listaDeEtiquetas.add(new Subtitulo());
		listaOrganizada = miOrganizador.organizar(listaDeEtiquetas);
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
		listaOrganizada = miOrganizador.organizar(listaDeEtiquetas);
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
		listaOrganizada = miOrganizador.organizar(listaDeEtiquetas);
		Seccion seccion1 = (Seccion) listaOrganizada.get(0);
		Seccion seccion2 = (Seccion) listaOrganizada.get(1);
		Assert.assertEquals(Seccion.class, listaOrganizada.get(0).getClass());
		Assert.assertEquals(Titulo.class, seccion1.getListaDeElementos().get(0).getClass());
		Assert.assertEquals(Subtitulo.class, seccion2.getListaDeElementos().get(0).getClass());
	}
	
	@Test
	public void losItemsVanDentroDeUnaListaDeItems(){
		OrganizadorDeEtiquetas miOrganizador = new OrganizadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizada = new LinkedList<EtiquetaHTML>();
		ItemDeLista item1 = new ItemDeLista();
		ItemDeLista item2 = new ItemDeLista();		
		item1.setTexto("primer item");
		item2.setTexto("segundo item");
		listaDeEtiquetas.add(item1);
		listaDeEtiquetas.add(item2);
		listaOrganizada = miOrganizador.organizar(listaDeEtiquetas);
		Assert.assertEquals(ListaSinOrden.class, listaOrganizada.get(0).getClass());
		Assert.assertEquals(ItemDeLista.class, ((ListaSinOrden) listaOrganizada.get(0)).getColeccionDeItems().get(0).getClass());
		Assert.assertEquals("primer item", ((ListaSinOrden) listaOrganizada.get(0)).getColeccionDeItems().get(0).getTexto());
		Assert.assertEquals(ItemDeLista.class, ((ListaSinOrden) listaOrganizada.get(0)).getColeccionDeItems().get(1).getClass());
		Assert.assertEquals("segundo item", ((ListaSinOrden) listaOrganizada.get(0)).getColeccionDeItems().get(1).getTexto());
	}
	
	@Test
	public void losItemsVanDentroDeUnaListaDeItemsYLaListaDentroDeUnaSeccionSiHaySecciones(){
		OrganizadorDeEtiquetas miOrganizador = new OrganizadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizada = new LinkedList<EtiquetaHTML>();
		ItemDeLista item1 = new ItemDeLista();
		ItemDeLista item2 = new ItemDeLista();		
		ItemDeLista item3 = new ItemDeLista();
		Seccion seccion = new Seccion();
		item1.setTexto("primer item");
		item2.setTexto("segundo item");
		item3.setTexto("tercer item");
		listaDeEtiquetas.add(item1);//este se tiene que guardar fuera de la seccion, porque esta antes
		listaDeEtiquetas.add(seccion);
		listaDeEtiquetas.add(item2);
		listaDeEtiquetas.add(item3);
		listaOrganizada = miOrganizador.organizar(listaDeEtiquetas);	
		
		Assert.assertEquals(ListaSinOrden.class, listaOrganizada.get(0).getClass());
		Assert.assertEquals(ItemDeLista.class, ((ListaSinOrden) listaOrganizada.get(0)).getColeccionDeItems().get(0).getClass());
		Assert.assertEquals("primer item", ((ListaSinOrden) listaOrganizada.get(0)).getColeccionDeItems().get(0).getTexto());
		Assert.assertEquals(ItemDeLista.class, (((ListaSinOrden) ((Seccion) listaOrganizada.get(1)).getListaDeElementos().get(0)).getColeccionDeItems().get(0).getClass()));
		Assert.assertEquals("segundo item", ((((ListaSinOrden) ((Seccion) listaOrganizada.get(1)).getListaDeElementos().get(0)).getColeccionDeItems().get(0).getTexto())));
		Assert.assertEquals(ItemDeLista.class, ((((ListaSinOrden) ((Seccion) listaOrganizada.get(1)).getListaDeElementos().get(0)).getColeccionDeItems().get(1).getClass())));
		Assert.assertEquals("tercer item", ((((ListaSinOrden) ((Seccion) listaOrganizada.get(1)).getListaDeElementos().get(0)).getColeccionDeItems().get(1).getTexto())));
		 
	}
	
	@Test
	public void losItemsVanDentroDeUnaListaDeItemsYLaListaDentroDeSuSeccionCorrespondienteSiHayMasDeUnaSeccion(){
		OrganizadorDeEtiquetas miOrganizador = new OrganizadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizada = new LinkedList<EtiquetaHTML>();
		ItemDeLista item1 = new ItemDeLista();
		ItemDeLista item2 = new ItemDeLista();		
		ItemDeLista item3 = new ItemDeLista();
		TextoSinFormato texto = new TextoSinFormato();
		Seccion seccion1 = new Seccion();
		Seccion seccion2 = new Seccion();
		item1.setTexto("primer item");
		item2.setTexto("segundo item");
		texto.setTexto("texto normal");
		item3.setTexto("tercer item");
		listaDeEtiquetas.add(seccion1);
		listaDeEtiquetas.add(item1);
		listaDeEtiquetas.add(item2);
		listaDeEtiquetas.add(seccion2);
		listaDeEtiquetas.add(texto);
		listaDeEtiquetas.add(item3);
		listaOrganizada = miOrganizador.organizar(listaDeEtiquetas);
		
		List<EtiquetaHTML> listaResultante = new LinkedList<EtiquetaHTML>();
		
		ListaSinOrden lista1 = new ListaSinOrden();
		lista1.agregarItem(item1);
		lista1.agregarItem(item2);
		seccion1.agregarElemento(lista1);
		seccion2.agregarElemento(texto);
		ListaSinOrden lista2 = new ListaSinOrden();
		lista2.agregarItem(item3);
		seccion2.agregarElemento(lista2);
		
		listaResultante.add(seccion1);
		listaResultante.add(seccion2);
		
		Assert.assertEquals(listaResultante, listaOrganizada);		
	}
	
}