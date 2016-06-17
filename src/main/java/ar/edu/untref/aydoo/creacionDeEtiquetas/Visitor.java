package ar.edu.untref.aydoo.creacionDeEtiquetas;

import ar.edu.untref.aydoo.etiquetas.Etiqueta;
import ar.edu.untref.aydoo.etiquetas.ListaSinOrden;
import ar.edu.untref.aydoo.etiquetas.Seccion;

public interface Visitor {

	void visitar(Etiqueta etiqueta);
	void visitar(Seccion seccion);
	void visitar(ListaSinOrden listaSinOrden);
}
