package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class OrganizadorDeSecciones {

	private List<EtiquetaHTML> listaOrganizada = new LinkedList<EtiquetaHTML>();
	private List<EtiquetaHTML> listaRecibida = new LinkedList<EtiquetaHTML>();

	public List<EtiquetaHTML> organizar(List<EtiquetaHTML> listaDeEtiquetas) {
		listaRecibida = listaDeEtiquetas;
		boolean esSeccion = false;
		for(int i = 0; i < listaRecibida.size(); i++){
			if(esSeccion){
				if(!esCambioDeSeccion(i)){
					agregarEtiquetaALaSeccion(i);
				}
			}
			else{
				esSeccion = revisarSiEsSeccion(i);
				listaOrganizada.add(listaDeEtiquetas.get(i));
			}
		}
		return listaOrganizada;
	}


	private void agregarEtiquetaALaSeccion(int i) {
		((Seccion) listaOrganizada.get(listaOrganizada.size()-1)).agregarElemento(listaRecibida.get(i));

	}

	private boolean esCambioDeSeccion(int i) {
		boolean respuesta = false;
		if(listaRecibida.get(i).getClass().equals(Seccion.class)){
			listaOrganizada.add(listaRecibida.get(i));
			respuesta = true;
		}
		return respuesta;
	}

	private boolean revisarSiEsSeccion(int i) {
		boolean respuesta = false;
		if(listaRecibida.get(i).getClass().equals(Seccion.class)){
			respuesta = true;
		}
		return respuesta;
	}

}
