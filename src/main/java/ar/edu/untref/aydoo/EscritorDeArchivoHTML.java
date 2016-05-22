package ar.edu.untref.aydoo;

import java.util.List;

public class EscritorDeArchivoHTML {
	
	private List<String> listaDeLineas;

	 EscritorDeArchivoHTML(List<String> listaDeLineas) {
		this.listaDeLineas = listaDeLineas;
	}

	public List<String> getListaDeLineas() {
		return this.listaDeLineas;
	}
}
