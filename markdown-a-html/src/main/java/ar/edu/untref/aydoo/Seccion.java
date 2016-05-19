package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Seccion extends EtiquetaHTML {
	
	private ArrayList<EtiquetaHTMLSimple> listaDeElementos;
	
	public Seccion(){
		this.prefijo = "<section>";
		this.sufijo = "</section>";
		this.listaDeElementos = new ArrayList<>();
	}

	public void agregarElemento(EtiquetaHTMLSimple elemento) {
		this.listaDeElementos.add(elemento);		
	}

	public ArrayList<EtiquetaHTMLSimple> getListaDeElementos() {
		return this.listaDeElementos;
	}

	public String getHTMLDeLosElementos() {
		String htmlDeLosElementos = "";
		String finDeLinea = System.getProperty("line.separator");
		
		for(EtiquetaHTMLSimple elemento : this.listaDeElementos){			
			htmlDeLosElementos += elemento.getHTML();
			htmlDeLosElementos += finDeLinea;
		}
		
		return htmlDeLosElementos;
	}

	public String getHTML() {
		String htmlDeLosElementos = this.getHTMLDeLosElementos();
		String finDeLinea = System.getProperty("line.separator");
		
		String html = this.prefijo + finDeLinea + htmlDeLosElementos + this.sufijo;
		
		return html;
	}	

}
