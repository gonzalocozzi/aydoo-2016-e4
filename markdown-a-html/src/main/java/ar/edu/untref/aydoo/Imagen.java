package ar.edu.untref.aydoo;

public class Imagen extends EtiquetaHTMLSimple {
	
	public Imagen(){		
		this.prefijo = "<img src=\"";
		this.sufijo = "\"/>";
	}

	public void aceptarVisitor(VisitorDeEtiquetas visitor) {
		visitor.visitar(this);
	}
}
