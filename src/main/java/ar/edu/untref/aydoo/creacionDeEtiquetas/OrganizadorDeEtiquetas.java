package ar.edu.untref.aydoo.creacionDeEtiquetas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.etiquetas.EtiquetaHTML;

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
