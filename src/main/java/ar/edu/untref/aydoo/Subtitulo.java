package ar.edu.untref.aydoo;

public class Subtitulo extends EtiquetaHTML implements Visitable{

	public Subtitulo(){
		this.prefijo = "<h2>";	
		this.sufijo = "</h2>";
		this.encabezado = "##";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);		
	}
}
