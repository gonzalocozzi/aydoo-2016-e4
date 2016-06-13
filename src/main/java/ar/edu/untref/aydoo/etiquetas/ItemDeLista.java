package ar.edu.untref.aydoo.etiquetas;

import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitable;
import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitor;

public class ItemDeLista extends Etiqueta implements Visitable {

	public ItemDeLista(){
		this.prefijoHTML = "<li>";
		this.sufijoHTML = "</li>";
		this.encabezadoMD = "*";
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}

	@Override
	protected ItemDeLista getNuevaInstancia() {
		return new ItemDeLista();
	}
}
