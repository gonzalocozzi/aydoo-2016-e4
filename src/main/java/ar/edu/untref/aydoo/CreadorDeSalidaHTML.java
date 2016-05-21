package ar.edu.untref.aydoo;

import java.util.List;

public class CreadorDeSalidaHTML {

	private List<EtiquetaHTML> listaDeSalida;
	
	public CreadorDeSalidaHTML(List<EtiquetaHTML> listaDeSalida) {
		this.listaDeSalida = listaDeSalida;
	}

	public List<EtiquetaHTML> getListaDeSalidaHTML() {
		return this.listaDeSalida;
	}

}
