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
					agregarEtiquetaALaSeccion(listaDeEtiquetas, listaOrganizada, i);
				}
			}
			if(!esSeccion){
				esSeccion = revisarSiEsSeccion(listaDeEtiquetas, i);
				listaOrganizada.add(listaDeEtiquetas.get(i));
			}
		}
		return listaOrganizada;
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

}
