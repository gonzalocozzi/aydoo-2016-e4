package ar.edu.untref.aydoo.etiquetas;

import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitable;
import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitor;

public class Subtitulo extends Etiqueta implements Visitable{

	public Subtitulo(){
		this.prefijoHTML = "<h2>";	
		this.sufijoHTML = "</h2>";
		this.encabezadoMD = "##";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);		
	}

	@Override
	protected Subtitulo getNuevaInstancia() {
		return new Subtitulo();
	}
}
