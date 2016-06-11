package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class OrganizadorDeSecciones implements Organizable {

	private List<EtiquetaHTML> listaOrganizada;
	private List<EtiquetaHTML> listaRecibida;

	public OrganizadorDeSecciones(){
		this.listaOrganizada = new LinkedList<EtiquetaHTML>();
		this.listaRecibida = new LinkedList<EtiquetaHTML>();
	}

	public List<EtiquetaHTML> organizar(List<EtiquetaHTML> listaDeEtiquetas) {
		listaRecibida = listaDeEtiquetas;
		Boolean esSeccion = false;

		for(int i = 0; i < listaRecibida.size(); i++){
			//no se me ocurre alguna forma de sacar estos if
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


	private void agregarEtiquetaALaSeccion(Integer i) {
		((Seccion) listaOrganizada.get(listaOrganizada.size()-1)).agregarElemento(listaRecibida.get(i));
	}

	private Boolean esCambioDeSeccion(Integer i) {
		Boolean respuesta = false;
		if(listaRecibida.get(i).getClass().equals(Seccion.class)){
			listaOrganizada.add(listaRecibida.get(i));
			respuesta = true;
		}
		return respuesta;
	}

	private Boolean revisarSiEsSeccion(Integer i) {
		boolean respuesta = false;
		if(listaRecibida.get(i).getClass().equals(Seccion.class)){
			respuesta = true;
		}
		return respuesta;
	}

}
