package ar.edu.untref.aydoo.etiquetas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitor;

public class Seccion extends EtiquetaHTML{

	private List<EtiquetaHTML> listaDeElementos;

	public Seccion(){
		this.prefijo = "<section>";
		this.sufijo = "</section>";
		this.listaDeElementos = new LinkedList<>();
		this.encabezadoMD = "---";
	}

	public void agregarElemento(EtiquetaHTML elemento) {
		this.listaDeElementos.add(elemento);		
	}

	public List<EtiquetaHTML> getListaDeElementos() {
		return this.listaDeElementos;
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}
	
	@Override
	protected Seccion crearNuevaInstancia() {
		return new Seccion();
	}
}
