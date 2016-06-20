package ar.edu.untref.aydoo.creacionDeEtiquetas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.etiquetas.Etiqueta;
import ar.edu.untref.aydoo.etiquetas.Seccion;

public class OrganizadorDeSecciones implements Organizable {

	private List<Etiqueta> listaOrganizada;
	private List<Etiqueta> listaRecibida;

	public OrganizadorDeSecciones(){
		this.listaOrganizada = new LinkedList<Etiqueta>();
		this.listaRecibida = new LinkedList<Etiqueta>();
	}

	@Override
	public List<Etiqueta> organizar(List<Etiqueta> listaDeEtiquetas) {
		listaRecibida = listaDeEtiquetas;
		Boolean esSeccion = false;

		for(int i = 0; i < listaRecibida.size(); i++){
			//no se nos ocurre alguna forma de sacar estos if (no funciona unir ambas condiciones en una misma sentencia)
			if(esSeccion){				
				if(!esCambioDeSeccion(i)){
					agregarEtiquetaALaSeccion(i);
				}				
			} else {
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
