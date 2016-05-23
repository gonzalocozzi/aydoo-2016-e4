package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class OrganizadorDeEtiquetas {

	public List<EtiquetaHTML> organizarEtiquetasHTML(List<EtiquetaHTML> listaDeEtiquetas) {
		List<EtiquetaHTML> listaOrganizada = new LinkedList<EtiquetaHTML>();
		boolean esSeccion = false;
		for(int i = 0; i < listaDeEtiquetas.size(); i++){
			if(esSeccion){
				if(!verSiEsCambioDeSeccion(listaDeEtiquetas, listaOrganizada, i)){
					if(!esUnItem(listaDeEtiquetas.get(i))){
						agregarEtiquetaALaSeccion(listaDeEtiquetas, listaOrganizada, i);
					}
					else{
						i = rellenarListaDeItems(listaDeEtiquetas, listaOrganizada, i, esSeccion);
					}
				}
			}
			if(!esSeccion){
				if(!esUnItem(listaDeEtiquetas.get(i))){
					esSeccion = revisarSiEsSeccion(listaDeEtiquetas, i);
					listaOrganizada.add(listaDeEtiquetas.get(i));
				}
				else{
					i = rellenarListaDeItems(listaDeEtiquetas, listaOrganizada, i, esSeccion);
				}
			}
		}
		return listaOrganizada;
	}

	private int rellenarListaDeItems(List<EtiquetaHTML> listaDeEtiquetas, List<EtiquetaHTML> listaOrganizada, int i, boolean esSeccion) {
		ListaSinOrden miListaDeItems = new ListaSinOrden();
		int j = 0;
		while(((i + j) < listaDeEtiquetas.size()) && listaDeEtiquetas.get(i + j).getClass().equals(ItemDeLista.class)){ //es decir mientras siga habiendo items
			miListaDeItems = agregarItemALaListaDeItems(listaDeEtiquetas.get(i),listaDeEtiquetas, miListaDeItems, i, j);
			j++;
		}
		if(esSeccion){
			agregarEtiquetaALaSeccion(listaOrganizada, miListaDeItems);
		}
		else{
			listaOrganizada.add(miListaDeItems);
		}
		return j;
	}

	private ListaSinOrden agregarItemALaListaDeItems(EtiquetaHTML etiquetaHTML, List<EtiquetaHTML> listaDeEtiquetas, ListaSinOrden listaDeItems  ,int i, int j) {
		listaDeItems.agregarItem((ItemDeLista) listaDeEtiquetas.get(i+j));
		return listaDeItems;
	}

	private boolean esUnItem(EtiquetaHTML etiquetaHTML) {
		boolean respuesta = false;
		if(etiquetaHTML.getClass().equals(ItemDeLista.class)){
			respuesta = true;
		}
		return respuesta;
	}

	private boolean verSiEsCambioDeSeccion(List<EtiquetaHTML> listaDeEtiquetas, List<EtiquetaHTML> listaOrganizada,
			int i) {
		boolean respuesta = false;
		if(listaDeEtiquetas.get(i).getClass().equals(Seccion.class)){
			listaOrganizada.add(listaDeEtiquetas.get(i));
			respuesta = true;
		}
		return respuesta;
	}

	private void agregarEtiquetaALaSeccion(List<EtiquetaHTML> listaDeEtiquetas, List<EtiquetaHTML> listaOrganizada,
			int i) {	
		((Seccion) listaOrganizada.get(listaOrganizada.size()-1)).agregarElemento(listaDeEtiquetas.get(i));
	}

	private boolean revisarSiEsSeccion(List<EtiquetaHTML>listaDeEtiquetas, int i) { //si la Seccion no esta aun en la listaOrganizada, entonces se agrega
		boolean respuesta = false;
		if(listaDeEtiquetas.get(i).getClass().equals(Seccion.class)){
			respuesta = true;
		}
		return respuesta;
	}

	private void agregarEtiquetaALaSeccion(List<EtiquetaHTML> listaOrganizada, EtiquetaHTML etiquetaHTML) {	
		((Seccion) listaOrganizada.get(listaOrganizada.size()-1)).agregarElemento(etiquetaHTML);
	}
}
