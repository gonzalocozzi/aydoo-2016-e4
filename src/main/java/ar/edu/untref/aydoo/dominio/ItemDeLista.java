package ar.edu.untref.aydoo.dominio;

import ar.edu.untref.aydoo.Visitable;
import ar.edu.untref.aydoo.Visitor;

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
