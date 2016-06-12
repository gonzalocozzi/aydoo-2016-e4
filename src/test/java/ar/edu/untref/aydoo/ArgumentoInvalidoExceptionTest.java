package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.excepciones.ArgumentoInvalidoException;

public class ArgumentoInvalidoExceptionTest {
	
	@Test
	public void argumentoInvalidoExceptionDevuelveMensajeExplicativo(){
		
		ArgumentoInvalidoException excepcion = new ArgumentoInvalidoException("mensaje explicativo");
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "mensaje explicativo");
	}

}
