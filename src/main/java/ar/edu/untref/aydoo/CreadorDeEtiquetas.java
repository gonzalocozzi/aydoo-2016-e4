package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class CreadorDeEtiquetas {

	private List<String> listaDeRepresentaciones;
	
	public CreadorDeEtiquetas(){
		this.listaDeRepresentaciones = new LinkedList<String>();
		this.listaDeRepresentaciones.add("#");
	}

	public List<String> getLista() {
		return this.listaDeRepresentaciones;
	}

}
