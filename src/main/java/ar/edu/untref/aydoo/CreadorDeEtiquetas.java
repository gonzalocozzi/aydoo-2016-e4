package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CreadorDeEtiquetas {

	private final ArrayList<EtiquetaHTML> etiquetasHtml;
	
	public CreadorDeEtiquetas() {
		this.etiquetasHtml = new ArrayList<EtiquetaHTML>();
		this.etiquetasHtml.add(new Subtitulo());
		this.etiquetasHtml.add(new Titulo());
		this.etiquetasHtml.add(new ItemDeLista());
		this.etiquetasHtml.add(new Seccion());
		this.etiquetasHtml.add(new Imagen());
		this.etiquetasHtml.add(new TextoSinFormato());
	}

	public List<EtiquetaHTML> crearListaDeEtiquetas(List<String> lineasDelMarkDown) {
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		for(int i = 0; i < lineasDelMarkDown.size(); i++){
			String lineaActual = lineasDelMarkDown.get(i);
			for(int j = 0; j < this.etiquetasHtml.size(); j++){
				EtiquetaHTML etiquetaActual = this.etiquetasHtml.get(j);
				EtiquetaHTML etiquetaResultante = etiquetaActual.crearConMd(lineaActual);
				if(etiquetaResultante != null){
					listaDeEtiquetas.add(etiquetaResultante);
					j = this.etiquetasHtml.size();
				}
			}
		}
		return listaDeEtiquetas;
	}

}