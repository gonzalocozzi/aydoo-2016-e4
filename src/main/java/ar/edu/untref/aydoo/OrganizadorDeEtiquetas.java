package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class OrganizadorDeEtiquetas implements Organizable{

	private OrganizadorDeItems organizadorDeItems;
	private OrganizadorDeSecciones organizadorDeSecciones;

	public OrganizadorDeEtiquetas(){
		this.organizadorDeItems = new OrganizadorDeItems();
		this.organizadorDeSecciones = new OrganizadorDeSecciones();
	}

	public List<EtiquetaHTML> organizar(List<EtiquetaHTML> listaDeEtiquetas){
		List<EtiquetaHTML> listaOrdenada = new LinkedList<EtiquetaHTML>();
		listaOrdenada = this.organizadorDeItems.organizar(listaDeEtiquetas);
		listaOrdenada = this.organizadorDeSecciones.organizar(listaOrdenada);
		return listaOrdenada; 
	}
}
