package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class OrganizadorDeItems {

	private List<EtiquetaHTML> listaOrganizada = new LinkedList<EtiquetaHTML>();
	private List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();

	public List<EtiquetaHTML> organizar(List<EtiquetaHTML> listaDeEtiquetas) {
		this.listaDeEtiquetas = listaDeEtiquetas;
		for(int i = 0; i < this.listaDeEtiquetas.size(); i++){
			if(this.listaDeEtiquetas.get(i).getClass().equals(ItemDeLista.class)){
				i = this.rellenarListaDeItems(i);
			}
			else{
				listaOrganizada.add(this.listaDeEtiquetas.get(i));
			}
		}
		return listaOrganizada;
	}

	private int rellenarListaDeItems(int i) {
		ListaSinOrden listaDeItemsActual = new ListaSinOrden();
		int j = 0;
		/*
		 * El (i+j)<listaRecibida.size() esta para que no se vaya de rango.
		 * Es decir mientras siga habiendo items.
		 */
		while(((i + j) < listaDeEtiquetas.size()) && listaDeEtiquetas.get(i + j).getClass().equals(ItemDeLista.class)){ 
			listaDeItemsActual = agregarItemALaListaDeItems(listaDeEtiquetas.get(i), listaDeItemsActual, i+j);
			j++;
		}
		listaOrganizada.add(listaDeItemsActual);
		return (j+i)-1;
	}

	private ListaSinOrden agregarItemALaListaDeItems(EtiquetaHTML etiquetaHTML, ListaSinOrden listaDeItems, int posicionDeItemActual) {
		listaDeItems.agregarItem((ItemDeLista) listaDeEtiquetas.get(posicionDeItemActual));
		return listaDeItems;
	}
}