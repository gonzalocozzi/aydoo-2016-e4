package ar.edu.untref.aydoo.etiquetas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitor;

public class Seccion extends Etiqueta{

	private List<Etiqueta> listaDeElementos;

	public Seccion(){
		this.prefijoHTML = "<section>";
		this.sufijoHTML = "</section>";
		this.listaDeElementos = new LinkedList<>();
		this.encabezadoMD = "---";
	}

	public void agregarElemento(Etiqueta elemento) {
		this.listaDeElementos.add(elemento);		
	}

	public List<Etiqueta> getListaDeElementos() {
		return this.listaDeElementos;
	}

	@Override
	public void aceptarVisitor(Visitor visitor) {
		visitor.visitar(this);
	}

	@Override
	protected Seccion getNuevaInstancia() {
		return new Seccion();
	}
}
