package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.dominio.EtiquetaHTML;
import ar.edu.untref.aydoo.dominio.ListaSinOrden;
import ar.edu.untref.aydoo.dominio.Seccion;

public interface Visitor {

	void visitar(EtiquetaHTML etiquetaHTML);
	void visitar(Seccion seccion);
	void visitar(ListaSinOrden listaSinOrden);
}
