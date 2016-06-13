package ar.edu.untref.aydoo.creacionDeEtiquetas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.etiquetas.Etiqueta;
import ar.edu.untref.aydoo.etiquetas.Imagen;
import ar.edu.untref.aydoo.etiquetas.ItemDeLista;
import ar.edu.untref.aydoo.etiquetas.Seccion;
import ar.edu.untref.aydoo.etiquetas.Subtitulo;
import ar.edu.untref.aydoo.etiquetas.TextoSinFormato;
import ar.edu.untref.aydoo.etiquetas.Titulo;

public class CreadorDeEtiquetas {

	private ArrayList<Etiqueta> etiquetasHtml;

	public CreadorDeEtiquetas() {
		this.etiquetasHtml = new ArrayList<Etiqueta>();
		this.etiquetasHtml.add(new Subtitulo());
		this.etiquetasHtml.add(new Titulo());
		this.etiquetasHtml.add(new ItemDeLista());
		this.etiquetasHtml.add(new Seccion());
		this.etiquetasHtml.add(new Imagen());
		this.etiquetasHtml.add(new TextoSinFormato());
	}

	public List<Etiqueta> crearListaDeEtiquetas(List<String> lineasDelMarkDown) {
		List<Etiqueta> listaDeEtiquetas = new LinkedList<Etiqueta>();
		for(int i = 0; i < lineasDelMarkDown.size(); i++){
			String lineaActual = lineasDelMarkDown.get(i);
			agregarEtiquetaAListaDeEtiquetas(listaDeEtiquetas, lineaActual);
		}
		return listaDeEtiquetas;
	}

	private void agregarEtiquetaAListaDeEtiquetas(List<Etiqueta> listaDeEtiquetas, String lineaActual) {
		for(int j = 0; j < this.etiquetasHtml.size(); j++){
			Etiqueta etiquetaActual = this.etiquetasHtml.get(j);
			Etiqueta etiquetaResultante = etiquetaActual.crearConMD(lineaActual);
			if(etiquetaResultante != null){
				listaDeEtiquetas.add(etiquetaResultante);
				j = this.etiquetasHtml.size();
			}
		}
	}

	public void agregarNuevaEtiqueta(Etiqueta nuevaEtiqueta){
		int tamanioDeLista = this.etiquetasHtml.size();
		Etiqueta textoSinFormato = this.etiquetasHtml.get(tamanioDeLista-1);
		this.etiquetasHtml.add(tamanioDeLista-1, nuevaEtiqueta);
		this.etiquetasHtml.add(textoSinFormato);
	}

	public ArrayList<Etiqueta> getEtiquetasHtml(){
		return this.etiquetasHtml;
	}

}