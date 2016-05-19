package ar.edu.untref.aydoo;

public class ItemDeLista extends EtiquetaHTMLSimple {
	
	public ItemDeLista(){
		this.prefijo = "<li>";
		this.sufijo = "</li>";
	}

	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}
}
