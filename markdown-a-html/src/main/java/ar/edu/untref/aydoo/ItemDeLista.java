package ar.edu.untref.aydoo;

public class ItemDeLista extends EtiquetaHTML implements Visitable {
	
	public ItemDeLista(){
		this.prefijo = "<li>";
		this.sufijo = "</li>";
	}

	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}
}
