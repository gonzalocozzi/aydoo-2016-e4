package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class OrganizadorDeEtiquetas {

	public List<EtiquetaHTML> organizarEtiquetasHTML(List<EtiquetaHTML> listaDeEtiquetas) {
		//List<EtiquetaHTML> listaAOrganizar = listaDeEtiquetas;
		List<EtiquetaHTML> listaOrganizada = new LinkedList<EtiquetaHTML>();
		boolean esSeccion = false;
		for(int i = 0; i < listaDeEtiquetas.size(); i++){
			if(!esSeccion){
				esSeccion = revisarSiEsSeccion(listaDeEtiquetas, i);
			}
			if(esSeccion){
				agregarEtiquetaALaSeccion(listaDeEtiquetas, listaOrganizada, i);
			}
		}
		return listaOrganizada;
	}

	private void agregarEtiquetaALaSeccion(List<EtiquetaHTML> listaDeEtiquetas, List<EtiquetaHTML> listaOrganizada,
			int i) {
		if(revisarSiEsSeccion(listaDeEtiquetas, i)){
			listaOrganizada.add(listaDeEtiquetas.get(i));
		}
		else{
			((Seccion) listaOrganizada.get(listaOrganizada.size()-1)).agregarElemento(listaDeEtiquetas.get(i));
		}
	}

	private boolean revisarSiEsSeccion(List<EtiquetaHTML>listaDeEtiquetas, int i) { //si la Seccion no esta aun en la listaOrganizada, entonces se agrega
		boolean respuesta = false;
		if(listaDeEtiquetas.get(i).getClass().equals(Seccion.class)){
			respuesta = true;
		}
		return respuesta;
	}

}
