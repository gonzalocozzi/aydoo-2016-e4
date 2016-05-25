package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CreadorDeEtiquetas {

	private EtiquetaHTMLFactory etiquetaHTMLFactory;
	private List<String> listaDeRepresentaciones;

	public CreadorDeEtiquetas(){
		this.listaDeRepresentaciones = new LinkedList<String>();
		this.listaDeRepresentaciones.add("##");
		this.listaDeRepresentaciones.add("#");
		this.listaDeRepresentaciones.add("i:");
		this.listaDeRepresentaciones.add("*");
		this.listaDeRepresentaciones.add("---");
		this.etiquetaHTMLFactory = new EtiquetaHTMLFactory();
	}

	public List<EtiquetaHTML> crearListaDeEtiquetas(List<String> lineasDelMarkDown) {
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		for(int i = 0; i < lineasDelMarkDown.size(); i++){
			String lineaActual = lineasDelMarkDown.get(i);
			String principioDeLinea = obtenerPrincipioDeLinea(lineaActual);
			String representacionActual = buscarEncabezadoCorrespondiente(principioDeLinea);
			String posibleEncabezado = "";
			if(!lineaActual.equals("")){
				posibleEncabezado = principioDeLinea.substring(0, representacionActual.length());
			}
			if(posibleEncabezado.equals(representacionActual)){ //compara para ver si realmente es un encabezado, es decir que esta al inicio de la linea
				String texto = asignarTextoALaEtiquetaAGenerar(lineasDelMarkDown, i, representacionActual);
				listaDeEtiquetas = crearEtiqueta(posibleEncabezado, texto, listaDeEtiquetas, i);
			}
			else{ //si no hay encabezado entonces va a ser un texto sin formato
				String texto = asignarTextoALaEtiquetaAGenerar(lineasDelMarkDown, i, "");
				listaDeEtiquetas = crearEtiqueta("", texto, listaDeEtiquetas, i);
			}
		}
		return listaDeEtiquetas;
	}

	private String obtenerPrincipioDeLinea(String linea) {
		int j = 0;
		String principioDeLinea = "";
		while(j < 3 && j < linea.length()){
			principioDeLinea += linea.charAt(j);
			j++;
		}
		return principioDeLinea;
	}

	private String asignarTextoALaEtiquetaAGenerar(List<String> lineasDelMarkDown, int i, String representacionActual) {
		int tamanioDelEncabezado = representacionActual.length();
		String texto = lineasDelMarkDown.get(i).substring(tamanioDelEncabezado, lineasDelMarkDown.get(i).length());
		return texto;
	}

	private String buscarEncabezadoCorrespondiente(String principioDeLinea) {
		Iterator<String> it = this.listaDeRepresentaciones.iterator();
		boolean noHuboCoincidencia = true;
		String representacionActual = "";
		while(it.hasNext() && noHuboCoincidencia){
			representacionActual = it.next();
			if(principioDeLinea.contains(representacionActual)){
				noHuboCoincidencia = false;
			}
		}
		return representacionActual;
	}

	private List<EtiquetaHTML> crearEtiqueta(String encabezado, String texto, List<EtiquetaHTML> listaDeEtiquetas, int posicion) {
		List<EtiquetaHTML> listaADevolver = listaDeEtiquetas;
		EtiquetaHTML etiquetaACrear = new TextoSinFormato(); //por defecto se crea un texto sin formato
		if(!encabezado.equals("")){
			etiquetaACrear = this.etiquetaHTMLFactory.crearEtiqueta(encabezado);
		}
		etiquetaACrear.setTexto(texto);
		listaADevolver.add(etiquetaACrear);
		return listaADevolver;
	}

	public List<String> getListaDeRepresentaciones(){
		return this.listaDeRepresentaciones;
	}
}