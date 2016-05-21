package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Seccion extends EtiquetaHTML{
	
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
	
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}
}