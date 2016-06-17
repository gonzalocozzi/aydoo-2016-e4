package ar.edu.untref.aydoo.creacionDeEtiquetas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.etiquetas.Etiqueta;
import ar.edu.untref.aydoo.etiquetas.ItemDeLista;
import ar.edu.untref.aydoo.etiquetas.ListaSinOrden;

public class OrganizadorDeItems implements Organizable{

	private List<Etiqueta> listaOrganizada;
	private List<Etiqueta> listaDeEtiquetas;

	public OrganizadorDeItems(){
		this.listaDeEtiquetas = new LinkedList<Etiqueta>();
		this.listaOrganizada =  new LinkedList<Etiqueta>();
	}

	@Override
	public List<Etiqueta> organizar(List<Etiqueta> listaDeEtiquetas) {
		this.listaDeEtiquetas = listaDeEtiquetas;

		for(int i = 0; i < this.listaDeEtiquetas.size(); i++){

			if(this.listaDeEtiquetas.get(i).getClass().equals(ItemDeLista.class)){
				/*este metodo (rellenarListaDeItems(i)) va a devolver un entero, ya que al poder agregar mas de un item, es necesario 
				 * saber en que posicion de la lista se esta cuando se termino de agregar Items a la Lista de items. 
				 */
				i = this.rellenarListaDeItems(i);
			} else {
				this.listaOrganizada.add(this.listaDeEtiquetas.get(i));
			}

		}

		return this.listaOrganizada;
	}

	private Integer rellenarListaDeItems(Integer i) {
		ListaSinOrden listaDeItemsActual = new ListaSinOrden();
		int j = 0;

		//El (i+j)<listaRecibida.size() esta para que no se vaya de rango. Es decir mientras siga habiendo items.		 
		while(((i + j) < this.listaDeEtiquetas.size()) && this.listaDeEtiquetas.get(i + j).getClass().equals(ItemDeLista.class)){ 
			listaDeItemsActual = agregarItemALaListaDeItems(this.listaDeEtiquetas.get(i), listaDeItemsActual, i+j);
			j++;
		}

		this.listaOrganizada.add(listaDeItemsActual);
		//es necesario restar 1, ya que al pasar por el for se le suma uno, y si no hago esto se saltea una EtiquetaHTML
		return (j+i)-1;
	}

	private ListaSinOrden agregarItemALaListaDeItems(Etiqueta etiquetaHTML, ListaSinOrden listaDeItems, int posicionDeItemActual) {
		listaDeItems.agregarItem((ItemDeLista) this.listaDeEtiquetas.get(posicionDeItemActual));

		return listaDeItems;
	}
}
