package ar.edu.untref.aydoo.etiquetas;

import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitable;
import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitor;

public class ItemDeLista extends EtiquetaHTML implements Visitable {

	public ItemDeLista(){
		this.prefijo = "<li>";
		this.sufijo = "</li>";
		this.encabezadoMD = "*";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}
	
	@Override
	protected ItemDeLista crearNuevaInstancia() {
		return new ItemDeLista();
	}
}
