package ar.edu.untref.aydoo.dominio;

import ar.edu.untref.aydoo.procesamientoDeParametros.Visitable;
import ar.edu.untref.aydoo.procesamientoDeParametros.Visitor;

public class Subtitulo extends EtiquetaHTML implements Visitable{

	public Subtitulo(){
		this.prefijo = "<h2>";	
		this.sufijo = "</h2>";
		this.encabezadoMD = "##";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);		
	}
	
	@Override
	protected Subtitulo crearNuevaInstancia() {
		return new Subtitulo();
	}
}
