package ar.edu.untref.aydoo;

public class TextoSinFormato extends EtiquetaHTML implements Visitable {

	public TextoSinFormato(){
		this.prefijo = "";
		this.sufijo = "";
		this.encabezadoMD = "";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}

	@Override
	protected TextoSinFormato crearNuevaInstancia() {
		return new TextoSinFormato();
	}
}
