package ar.edu.untref.aydoo.dominio;

import ar.edu.untref.aydoo.Visitable;
import ar.edu.untref.aydoo.Visitor;

public class Imagen extends EtiquetaHTML implements Visitable {

	public Imagen(){		
		this.prefijo = "<img src=\"";
		this.sufijo = "\"/>";
		this.encabezadoMD = "i:";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}
	
	@Override
	protected Imagen crearNuevaInstancia() {
		return new Imagen();
	}
}