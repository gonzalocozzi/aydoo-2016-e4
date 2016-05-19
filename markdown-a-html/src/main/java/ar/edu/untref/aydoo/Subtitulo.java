package ar.edu.untref.aydoo;

public class Subtitulo extends EtiquetaHTMLSimple{
	
	public Subtitulo(){
		this.prefijo = "<h2>";	
		this.sufijo = "</h2>";
	}

	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);		
	}
}
