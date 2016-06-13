package ar.edu.untref.aydoo.etiquetas;

import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitable;
import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitor;

public class Imagen extends Etiqueta implements Visitable {

	public Imagen(){		
		this.prefijoHTML = "<img src=\"";
		this.sufijoHTML = "\"/>";
		this.encabezadoMD = "i:";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}

	@Override
	protected Imagen getNuevaInstancia() {
		return new Imagen();
	}
}
