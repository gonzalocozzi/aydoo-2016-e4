package ar.edu.untref.aydoo;

public class Titulo extends EtiquetaHTML implements Visitable{

	public Titulo(){		
		this.prefijo = "<h1>";
		this.sufijo = "</h1>";
		this.encabezadoMD = "#";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);		
	}
}
