package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class OrganizadorDeItemsTest {

	@Test
	public void siHayItemsSeCreaUnaListaDeItemsQueContengaAEseItemYALosQueEstanContiguos(){
		OrganizadorDeItems organizadorDeItems = new OrganizadorDeItems();
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaOrganizadaObtenida = new LinkedList<EtiquetaHTML>();
		List<EtiquetaHTML> listaEsperada = new LinkedList<EtiquetaHTML>();
		ItemDeLista item1 = new ItemDeLista();
		ItemDeLista item2 = new ItemDeLista();
		listaDeEtiquetas.add(item1);
		listaDeEtiquetas.add(item2);
		listaOrganizadaObtenida = organizadorDeItems.organizar(listaDeEtiquetas);
		ListaSinOrden listaDeItems = new ListaSinOrden();
		listaDeItems.agregarItem(item1);
		listaDeItems.agregarItem(item2);
		listaEsperada.add(listaDeItems);
		Assert.assertEquals(listaEsperada.get(0).getClass(), listaOrganizadaObtenida.get(0).getClass());
	}
}
