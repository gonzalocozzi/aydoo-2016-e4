package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import org.junit.Assert;

public class CreadorDeSalidaHTMLTest {

	@Test
	public void recibeUnListaVacia(){
		
		List<EtiquetaHTML> lista = new LinkedList<EtiquetaHTML>();
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<EtiquetaHTML> listaEsperada = new LinkedList<EtiquetaHTML>();
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
	}
}
