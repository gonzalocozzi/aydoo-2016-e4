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

	private ArrayList<Class<? extends Etiqueta>> etiquetas;

	public CreadorDeEtiquetas() {
		//Etiquetas que el programa puede traducir por default
		this.etiquetas = new ArrayList<>();
		this.etiquetas.add(Subtitulo.class);
		this.etiquetas.add(Titulo.class);
		this.etiquetas.add(ItemDeLista.class);
		this.etiquetas.add(Seccion.class);
		this.etiquetas.add(Imagen.class);
		this.etiquetas.add(TextoSinFormato.class);
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

		for(int j = 0; j < this.etiquetas.size(); j++){			
			Etiqueta etiquetaActual = null;	

			try {
				etiquetaActual = this.etiquetas.get(j).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}	

			Etiqueta etiquetaResultante = etiquetaActual.crearDesdeArchivoMarkdown(lineaActual);
			if(etiquetaResultante != null){
				listaDeEtiquetas.add(etiquetaResultante);
				j = this.etiquetas.size();
			}

		}	

	}

	public void agregarNuevaEtiqueta(Class<? extends Etiqueta> nuevaEtiqueta){
		int tamanioDeLista = this.etiquetas.size();
		Class<? extends Etiqueta> textoSinFormato = this.etiquetas.get(tamanioDeLista-1);
		this.etiquetas.add(tamanioDeLista-1, nuevaEtiqueta);
		this.etiquetas.add(textoSinFormato);
	}

	public ArrayList<Class<? extends Etiqueta>> getEtiquetasHtml(){
		return this.etiquetas;
	}

}