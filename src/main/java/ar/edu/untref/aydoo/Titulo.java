package ar.edu.untref.aydoo;

public class Titulo extends EtiquetaHTML implements Visitable{
	
	public Titulo(){		
		this.prefijo = "<h1>";
		this.sufijo = "</h1>";
	}

	public void aceptarVisitor(Visitor visitor) {
		System.out.println("entra al titulo");
		visitor.visitar(this);		
	}
}
