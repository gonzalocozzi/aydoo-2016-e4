package ar.edu.untref.aydoo;

public class TextoSinFormato extends EtiquetaHTMLSimple {
	
	public TextoSinFormato(){
		this.prefijo = "";
		this.sufijo = "";
	}

	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}

}
