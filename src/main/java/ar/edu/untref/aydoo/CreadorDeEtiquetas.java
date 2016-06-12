package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.dominio.EtiquetaHTML;
import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.ItemDeLista;
import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.Subtitulo;
import ar.edu.untref.aydoo.dominio.TextoSinFormato;
import ar.edu.untref.aydoo.dominio.Titulo;

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
			agregarEtiquetaAListaDeEtiquetas(listaDeEtiquetas, lineaActual);
		}
		return listaDeEtiquetas;
	}

	private void agregarEtiquetaAListaDeEtiquetas(List<EtiquetaHTML> listaDeEtiquetas, String lineaActual) {
		for(int j = 0; j < this.etiquetasHtml.size(); j++){
			EtiquetaHTML etiquetaActual = this.etiquetasHtml.get(j);
			EtiquetaHTML etiquetaResultante = etiquetaActual.crearConMD(lineaActual);
			if(etiquetaResultante != null){
				listaDeEtiquetas.add(etiquetaResultante);
				j = this.etiquetasHtml.size();
			}
		}
	}
	
	public void agregarNuevaEtiqueta(EtiquetaHTML nuevaEtiqueta){
		int tamanioDeLista = this.etiquetasHtml.size();
		EtiquetaHTML textoSinFormato = this.etiquetasHtml.get(tamanioDeLista-1);
		this.etiquetasHtml.add(tamanioDeLista-1, nuevaEtiqueta);
		this.etiquetasHtml.add(textoSinFormato);
	}
	
	public ArrayList<EtiquetaHTML> getEtiquetasHtml(){
		return this.etiquetasHtml;
	}

}