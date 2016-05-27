package ar.edu.untref.aydoo;

public class Imagen extends EtiquetaHTML implements Visitable {

	public Imagen(){		
		this.prefijo = "<img src=\"";
		this.sufijo = "\"/>";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}
}
