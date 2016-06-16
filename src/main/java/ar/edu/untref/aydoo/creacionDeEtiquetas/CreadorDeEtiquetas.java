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

	private ArrayList<Class<? extends Etiqueta>> etiquetasHtml;

	public CreadorDeEtiquetas() {
		//Etiquetas que el programa puede traducir por default
		this.etiquetasHtml = new ArrayList<>();
		this.etiquetasHtml.add(Subtitulo.class);
		this.etiquetasHtml.add(Titulo.class);
		this.etiquetasHtml.add(ItemDeLista.class);
		this.etiquetasHtml.add(Seccion.class);
		this.etiquetasHtml.add(Imagen.class);
		this.etiquetasHtml.add(TextoSinFormato.class);
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
			Etiqueta etiquetaActual = null;			
			try {
				etiquetaActual = this.etiquetasHtml.get(j).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}			
			Etiqueta etiquetaResultante = etiquetaActual.crearConMD(lineaActual);
			if(etiquetaResultante != null){
				listaDeEtiquetas.add(etiquetaResultante);
				j = this.etiquetasHtml.size();
			}
		}		
	}

	public void agregarNuevaEtiqueta(Class<? extends Etiqueta> nuevaEtiqueta){
		int tamanioDeLista = this.etiquetasHtml.size();
		Class<? extends Etiqueta> textoSinFormato = this.etiquetasHtml.get(tamanioDeLista-1);
		this.etiquetasHtml.add(tamanioDeLista-1, nuevaEtiqueta);
		this.etiquetasHtml.add(textoSinFormato);
	}

	public ArrayList<Class<? extends Etiqueta>> getEtiquetasHtml(){
		return this.etiquetasHtml;
	}

}