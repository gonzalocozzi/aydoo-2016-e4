package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CreadorDeEtiquetas {

	private HashMap<String, EtiquetaHTML> diccionarioDeRepresentaciones;

	public CreadorDeEtiquetas(){
		this.diccionarioDeRepresentaciones = new HashMap<String, EtiquetaHTML>();
		this.diccionarioDeRepresentaciones.put("#", new Titulo());
		this.diccionarioDeRepresentaciones.put("##", new Subtitulo());
		this.diccionarioDeRepresentaciones.put("i:", new Imagen());
		this.diccionarioDeRepresentaciones.put("*", new ItemDeLista());
		this.diccionarioDeRepresentaciones.put("---", new Seccion());
	}

	public HashMap<String, EtiquetaHTML> getDiccionario(){
		return this.diccionarioDeRepresentaciones;
	}

	public List<EtiquetaHTML> crearListaDeEtiquetas(List<String> lineasDelMarkDown) {
		List<EtiquetaHTML> listaDeEtiquetas = new LinkedList<EtiquetaHTML>();
		for(int i = 0; i < lineasDelMarkDown.size(); i++){
			String principioDeLinea = lineasDelMarkDown.get(i).substring(0, 3);//me toma los primeros 3 caracteres
			Iterator<String> it = this.diccionarioDeRepresentaciones.keySet().iterator();
			boolean noHuboCoincidencia = true;
			String representacionActual = "";
			while(it.hasNext() && noHuboCoincidencia){
				representacionActual = it.next();
				if(principioDeLinea.contains(representacionActual)){
					noHuboCoincidencia = false;
				}
				else{
					representacionActual = "";
				}
			}
			String posibleEncabezado = principioDeLinea.substring(0, representacionActual.length());
			if(posibleEncabezado.equals(representacionActual)){
				int tamanioDelEncabezado = principioDeLinea.length();
				String texto = lineasDelMarkDown.get(i).substring(tamanioDelEncabezado-1, lineasDelMarkDown.get(i).length()-1);
				
				listaDeEtiquetas = crearEtiqueta(posibleEncabezado, texto, listaDeEtiquetas);
			}
		}
		return listaDeEtiquetas;
	}

	private List<EtiquetaHTML> crearEtiqueta(String encabezado, String texto, List<EtiquetaHTML> listaDeEtiquetas) {
		List<EtiquetaHTML> listaADevolver = listaDeEtiquetas;
		EtiquetaHTML etiquetaACrear = this.diccionarioDeRepresentaciones.get(encabezado);
		etiquetaACrear.setTexto(texto);
		listaADevolver.add(etiquetaACrear);
		return listaADevolver;
	}
	
}
