package ar.edu.untref.aydoo.creacionDeEtiquetas;

import ar.edu.untref.aydoo.etiquetas.EtiquetaHTML;
import ar.edu.untref.aydoo.etiquetas.ListaSinOrden;
import ar.edu.untref.aydoo.etiquetas.Seccion;

public interface Visitor {

	void visitar(EtiquetaHTML etiquetaHTML);
	void visitar(Seccion seccion);
	void visitar(ListaSinOrden listaSinOrden);
}
