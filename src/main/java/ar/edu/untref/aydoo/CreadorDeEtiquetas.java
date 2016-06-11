package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class CreadorDeEtiquetas {

	private LinkedHashMap<EtiquetaHTML, EtiquetaHTML> diccionarioDeEtiquetas;

	/*
	 * no me salio la forma del .class que se comento en clase, con el newInstance no funciono, y ademas esa forma hacia
	 * que haya que tratar Exception en varios lados
	 */
	public CreadorDeEtiquetas() {
		Subtitulo subtitulo = new Subtitulo();
		Titulo titulo = new Titulo();
		Imagen imagen = new Imagen();
		ItemDeLista item = new ItemDeLista();
		Seccion seccion = new Seccion();
		this.diccionarioDeEtiquetas = new LinkedHashMap<EtiquetaHTML, EtiquetaHTML>();
		this.diccionarioDeEtiquetas.put(titulo, new Titulo());
		this.diccionarioDeEtiquetas.put(subtitulo, new Subtitulo());
		this.diccionarioDeEtiquetas.put(imagen, new Imagen());
		this.diccionarioDeEtiquetas.put(item, new ItemDeLista());
		this.diccionarioDeEtiquetas.put(seccion, new Seccion());
	}

	public List<EtiquetaHTML> crearListaDeEtiquetas(List<String> lineasDelMarkDown) {
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		for(int i = 0; i < lineasDelMarkDown.size(); i++){
			String lineaActual = lineasDelMarkDown.get(i);
			EtiquetaHTML etiquetaAAgregar = buscarEtiqueta(lineaActual);
			String textoDeLaEtiqueta = buscarTexto(etiquetaAAgregar, lineaActual);
			etiquetaAAgregar.setTexto(textoDeLaEtiqueta);
			listaDeEtiquetas.add(etiquetaAAgregar);
		}
		return listaDeEtiquetas;
	}

	private String buscarTexto(EtiquetaHTML etiqueta, String linea) {
		String textoADevolver = linea;
		String encabezado = "";
		if(etiqueta.getClass() != TextoSinFormato.class){
			encabezado = etiqueta.getEncabezado();
			textoADevolver = linea.substring(encabezado.length(), linea.length());
		}
		return textoADevolver;
	}

	private EtiquetaHTML buscarEtiqueta(String lineaActual) {
		Iterator<EtiquetaHTML> iteradorDeClaves = diccionarioDeEtiquetas.keySet().iterator();
		EtiquetaHTML etiquetaBuscada = new TextoSinFormato();
		while(iteradorDeClaves.hasNext() && lineaActual != "") {
			EtiquetaHTML etiquetaActual = iteradorDeClaves.next();
		    String encabezadoActual = etiquetaActual.getEncabezado();
		    if(lineaActual.startsWith(encabezadoActual)) {
		        etiquetaBuscada = this.diccionarioDeEtiquetas.get(etiquetaActual);
		    }	
		}
		this.reiniciarDiccionario();
		return etiquetaBuscada;
	}

	/*
	 * este metodo esta para arreglar el tema de que devuelva el mismo objeto cuando se quiere crear mas de una instancia 
	 * del mismo tipo de EtiquetaHTML. Por ej. dos subtitulos.
	 */
	private void reiniciarDiccionario() {
		Subtitulo subtitulo = new Subtitulo();
		Titulo titulo = new Titulo();
		Imagen imagen = new Imagen();
		ItemDeLista item = new ItemDeLista();
		Seccion seccion = new Seccion();
		this.diccionarioDeEtiquetas = new LinkedHashMap<EtiquetaHTML, EtiquetaHTML>();
		this.diccionarioDeEtiquetas.put(titulo, new Titulo());
		this.diccionarioDeEtiquetas.put(subtitulo, new Subtitulo());
		this.diccionarioDeEtiquetas.put(imagen, new Imagen());
		this.diccionarioDeEtiquetas.put(item, new ItemDeLista());
		this.diccionarioDeEtiquetas.put(seccion, new Seccion());
	}

}