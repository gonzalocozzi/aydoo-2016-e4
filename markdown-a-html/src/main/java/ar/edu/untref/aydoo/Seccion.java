package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Seccion extends EtiquetaHTML {
	
	private List<EtiquetaHTML> listaDeElementos;
	
	public Seccion(){
		this.prefijo = "<section>";
		this.sufijo = "</section>";
		this.listaDeElementos = new LinkedList<>();
	}

	public void agregarElemento(EtiquetaHTML elemento) {
		this.listaDeElementos.add(elemento);		
	}

	public List<EtiquetaHTML> getListaDeElementos() {
		return this.listaDeElementos;
	}
/**
	public String getHTMLDeLosElementos() {
		String htmlDeLosElementos = "";
		String finDeLinea = System.getProperty("line.separator");
		
		for(EtiquetaHTML elemento : this.listaDeElementos){			
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
	*/
}
