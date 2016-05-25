package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SinNombreDelArchivoDeEntradaExceptionTest {
	
	@Test
	public void sinNombreDelArchivoDeEntradaExceptionDevuelveMensajeExplicativo(){
		
		SinNombreDelArchivoDeEntradaException excepcion = new SinNombreDelArchivoDeEntradaException("mensaje explicativo");
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "mensaje explicativo");
	}

}
