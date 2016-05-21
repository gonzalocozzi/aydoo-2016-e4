package ar.edu.untref.aydoo;

import java.util.HashMap;

public class CreadorDeEtiquetas {

	private HashMap<String, EtiquetaHTML> diccionarioDeRepresentaciones;
	
	public CreadorDeEtiquetas(){
		this.diccionarioDeRepresentaciones = new HashMap<String, EtiquetaHTML>();
		this.diccionarioDeRepresentaciones.put("#", new Titulo());
		this.diccionarioDeRepresentaciones.put("##", new Subtitulo());
		this.diccionarioDeRepresentaciones.put("i:", new Imagen());
		this.diccionarioDeRepresentaciones.put("*", new ItemDeLista());
		this.diccionarioDeRepresentaciones.put("---", new Seccion());
		this.diccionarioDeRepresentaciones.put("", new TextoSinFormato());
	}
	
	public HashMap<String, EtiquetaHTML> getDiccionario(){
		return this.diccionarioDeRepresentaciones;
	}
}
