package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.analisisDeArgumentos.NombreInvalidoException;

public class NombreInvalidoExceptionTest {
	
	@Test
	public void nombreInvalidoExceptionDevuelveMensajeExplicativo(){
		
		NombreInvalidoException excepcion = new NombreInvalidoException("mensaje explicativo");
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "mensaje explicativo");
	}

}
