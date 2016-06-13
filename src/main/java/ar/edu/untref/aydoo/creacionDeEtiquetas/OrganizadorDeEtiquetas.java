package ar.edu.untref.aydoo.creacionDeEtiquetas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.etiquetas.Etiqueta;

public class OrganizadorDeEtiquetas implements Organizable{

	private OrganizadorDeItems organizadorDeItems;
	private OrganizadorDeSecciones organizadorDeSecciones;

	public OrganizadorDeEtiquetas(){
		this.organizadorDeItems = new OrganizadorDeItems();
		this.organizadorDeSecciones = new OrganizadorDeSecciones();
	}

	@Override
	public List<Etiqueta> organizar(List<Etiqueta> listaDeEtiquetas){
		List<Etiqueta> listaOrdenada = new LinkedList<Etiqueta>();
		listaOrdenada = this.organizadorDeItems.organizar(listaDeEtiquetas);
		listaOrdenada = this.organizadorDeSecciones.organizar(listaOrdenada);
		return listaOrdenada; 
	}
}
