package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.excepciones.NumeroDeArgumentosExcedidoException;

public class NumeroDeArgumentoExcedidoExceptionTest {
	
	@Test
	public void numeroDeArgumentosExcedidoExceptionDevuelveMensajeExplicativo(){
		
		NumeroDeArgumentosExcedidoException excepcion = new NumeroDeArgumentosExcedidoException("mensaje explicativo");
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "mensaje explicativo");
	}

}
