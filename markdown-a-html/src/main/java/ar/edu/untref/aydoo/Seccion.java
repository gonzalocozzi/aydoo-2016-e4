package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Seccion {
	
	private String prefijo;
	private String sufijo;
	private ArrayList<EtiquetaHTML> listaDeElementos;
	
	public Seccion(){
		this.prefijo = "<section>";
		this.sufijo = "</section>";
		this.listaDeElementos = new ArrayList<>();
	}

	public String getPrefijo() {
		return this.prefijo;
	}

	public String getSufijo() {
		return this.sufijo;
	}

	public void agregarElemento(EtiquetaHTML elemento) {
		this.listaDeElementos.add(elemento);		
	}

	public ArrayList<EtiquetaHTML> getListaDeElementos() {
		return this.listaDeElementos;
	}

	public String getHTMLDeLosElementos() {
		String htmlDeLosElementos = "";
		String finDeLinea = System.getProperty("line.separator");
		
		for(EtiquetaHTML elemento : this.listaDeElementos){			
			htmlDeLosElementos += elemento.getHTML();
			htmlDeLosElementos += finDeLinea;
		}
		
		return htmlDeLosElementos;
	}	

}
