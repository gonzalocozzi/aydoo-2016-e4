package ar.edu.untref.aydoo.dominio;

import ar.edu.untref.aydoo.procesamientoDeParametros.Visitable;
import ar.edu.untref.aydoo.procesamientoDeParametros.Visitor;

public class TextoSinFormato extends EtiquetaHTML implements Visitable {

	public TextoSinFormato(){
		this.prefijo = "";
		this.sufijo = "";
		this.encabezadoMD = "";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}

	@Override
	protected TextoSinFormato crearNuevaInstancia() {
		return new TextoSinFormato();
	}
}
