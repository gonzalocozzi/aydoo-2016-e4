package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.excepciones.SinNombreDelArchivoDeEntradaException;

public class SinNombreDelArchivoDeEntradaExceptionTest {
	
	@Test
	public void sinNombreDelArchivoDeEntradaExceptionDevuelveMensajeExplicativo(){
		
		SinNombreDelArchivoDeEntradaException excepcion = new SinNombreDelArchivoDeEntradaException("mensaje explicativo");
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "mensaje explicativo");
	}

}
