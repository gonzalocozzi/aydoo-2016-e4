package ar.edu.untref.aydoo.etiquetas;

import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitable;
import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitor;

public class Titulo extends Etiqueta implements Visitable{

	public Titulo(){		
		this.prefijoHTML = "<h1>";
		this.sufijoHTML = "</h1>";
		this.encabezadoMD = "#";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);		
	}

	@Override
	protected Titulo getNuevaInstancia() {
		return new Titulo();
	}
}
