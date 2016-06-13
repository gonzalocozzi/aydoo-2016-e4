package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.analisisDeArgumentos.SinNombreDelArchivoDeEntradaException;

public class SinNombreDelArchivoDeEntradaExceptionTest {
	
	@Test
	public void sinNombreDelArchivoDeEntradaExceptionDevuelveMensajeExplicativo(){
		
		List<String> listaDePrueba = new LinkedList<>();		
		SinNombreDelArchivoDeEntradaException excepcion = new SinNombreDelArchivoDeEntradaException(listaDePrueba, "mensaje explicativo");
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "mensaje explicativo");
	}

}
