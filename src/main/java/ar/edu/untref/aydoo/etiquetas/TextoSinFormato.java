package ar.edu.untref.aydoo.etiquetas;

import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitable;
import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitor;

public class TextoSinFormato extends Etiqueta implements Visitable {

	public TextoSinFormato(){
		this.prefijoHTML = "";
		this.sufijoHTML = "";
		this.encabezadoMD = "";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}

	@Override
	protected TextoSinFormato getNuevaInstancia() {
		return new TextoSinFormato();
	}
}
