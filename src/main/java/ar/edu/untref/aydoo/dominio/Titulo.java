package ar.edu.untref.aydoo.dominio;

import ar.edu.untref.aydoo.Visitable;
import ar.edu.untref.aydoo.Visitor;

public class Titulo extends EtiquetaHTML implements Visitable{

	public Titulo(){		
		this.prefijo = "<h1>";
		this.sufijo = "</h1>";
		this.encabezadoMD = "#";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);		
	}
	
	@Override
	protected Titulo crearNuevaInstancia() {
		return new Titulo();
	}
}