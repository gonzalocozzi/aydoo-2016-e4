package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.creacionDeEtiquetas.OrganizadorDeItems;
import ar.edu.untref.aydoo.etiquetas.EtiquetaHTML;
import ar.edu.untref.aydoo.etiquetas.ItemDeLista;
import ar.edu.untref.aydoo.etiquetas.ListaSinOrden;
import ar.edu.untref.aydoo.etiquetas.TextoSinFormato;

public class OrganizadorDeItemsTest {

	@Test
	public void siHayItemsSeCreaUnaListaDeItemsQueContengaAEseItemYALosQueEstanContiguos(){
		OrganizadorDeItems organizadorDeItems = new OrganizadorDeItems();
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizadaObtenida = new LinkedList<EtiquetaHTML>();
		ItemDeLista item1 = new ItemDeLista();
		item1.setTexto("item 1");
		ItemDeLista item2 = new ItemDeLista();
		item2.setTexto("item 2");
		listaDeEtiquetas.add(item1);
		listaDeEtiquetas.add(item2);
		listaOrganizadaObtenida = organizadorDeItems.organizar(listaDeEtiquetas);

		List<EtiquetaHTML> listaEsperada = new LinkedList<EtiquetaHTML>();
		ListaSinOrden listaDeItems = new ListaSinOrden();
		listaDeItems.agregarItem(item1);
		listaDeItems.agregarItem(item2);
		listaEsperada.add(listaDeItems);

		Assert.assertEquals(((ListaSinOrden)listaEsperada.get(0)).getColeccionDeItems().get(0), ((ListaSinOrden)listaOrganizadaObtenida.get(0)).getColeccionDeItems().get(0));
		Assert.assertEquals(((ListaSinOrden)listaEsperada.get(0)).getColeccionDeItems().get(1), ((ListaSinOrden)listaOrganizadaObtenida.get(0)).getColeccionDeItems().get(1));
	}

	@Test
	public void siHayAlgoQueNoEsItemEntreLosItemsEntoncesPertenecenAListasDistintasLosItemsYLoQueNoEsItemNoEntraEnLaLista(){
		OrganizadorDeItems organizadorDeItems = new OrganizadorDeItems();
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizadaObtenida = new LinkedList<EtiquetaHTML>();
		ItemDeLista item1 = new ItemDeLista();
		item1.setTexto("item 1");
		ItemDeLista item2 = new ItemDeLista();
		item2.setTexto("item 2");
		TextoSinFormato texto = new TextoSinFormato();
		listaDeEtiquetas.add(item1);
		listaDeEtiquetas.add(texto);
		listaDeEtiquetas.add(item2);
		listaOrganizadaObtenida = organizadorDeItems.organizar(listaDeEtiquetas);

		List<EtiquetaHTML> listaEsperada = new LinkedList<EtiquetaHTML>();
		ListaSinOrden listaDeItems1 = new ListaSinOrden();
		ListaSinOrden listaDeItems2 = new ListaSinOrden();
		listaDeItems1.agregarItem(item1);
		listaDeItems2.agregarItem(item2);
		listaEsperada.add(listaDeItems1);
		listaEsperada.add(texto);
		listaEsperada.add(listaDeItems2);

		Assert.assertEquals(listaEsperada.get(0).getClass(), listaOrganizadaObtenida.get(0).getClass());
		Assert.assertEquals(listaEsperada.get(1).getClass(), listaOrganizadaObtenida.get(1).getClass());
		Assert.assertEquals(listaEsperada.get(2).getClass(), listaOrganizadaObtenida.get(2).getClass());
	}

	@Test
	public void seAgreganVariosItemsYTodosConservanSuTexto(){
		OrganizadorDeItems organizadorDeItems = new OrganizadorDeItems();
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizadaObtenida = new LinkedList<EtiquetaHTML>();
		List<String> listaDeTextosGenerados = new LinkedList<String>();
		ItemDeLista item1 = new ItemDeLista();
		item1.setTexto("item 1");
		ItemDeLista item2 = new ItemDeLista();
		item2.setTexto("item 2");
		ItemDeLista item3 = new ItemDeLista();
		item3.setTexto("item 3");
		listaDeEtiquetas.add(item1);
		listaDeEtiquetas.add(item2);
		listaDeEtiquetas.add(item3);
		listaOrganizadaObtenida = organizadorDeItems.organizar(listaDeEtiquetas);
		String textoDelItem1 = ((ListaSinOrden) listaOrganizadaObtenida.get(0)).getColeccionDeItems().get(0).getTexto();
		String textoDelItem2 = ((ListaSinOrden) listaOrganizadaObtenida.get(0)).getColeccionDeItems().get(1).getTexto();
		String textoDelItem3 = ((ListaSinOrden) listaOrganizadaObtenida.get(0)).getColeccionDeItems().get(2).getTexto();
		listaDeTextosGenerados.add(textoDelItem1);
		listaDeTextosGenerados.add(textoDelItem2);
		listaDeTextosGenerados.add(textoDelItem3);

		List<String> listaDeTextosEsperada = new LinkedList<String>();
		listaDeTextosEsperada.add("item 1");
		listaDeTextosEsperada.add("item 2");
		listaDeTextosEsperada.add("item 3");

		Assert.assertEquals(listaDeTextosEsperada, listaDeTextosGenerados);

	}
}
