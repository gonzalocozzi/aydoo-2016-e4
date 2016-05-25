package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class NombreInvalidoExceptionTest {
	
	@Test
	public void nombreInvalidoExceptionDevuelveMensajeExplicativo(){
		
		ArgumentoInvalidoException excepcion = new ArgumentoInvalidoException("mensaje explicativo");
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "mensaje explicativo");
	}

}
