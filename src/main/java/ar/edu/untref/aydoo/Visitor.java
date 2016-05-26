package ar.edu.untref.aydoo;

public interface Visitor {

	void visitar(EtiquetaHTML etiquetaHTML);
	void visitar(Seccion seccion);
	void visitar(ListaSinOrden listaSinOrden);
}
