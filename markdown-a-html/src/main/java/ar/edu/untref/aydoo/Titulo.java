package ar.edu.untref.aydoo;

public class Titulo extends EtiquetaHTMLSimple {
	
	public Titulo(){		
		this.prefijo = "<h1>";
		this.sufijo = "</h1>";
	}

	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);		
	}
}
