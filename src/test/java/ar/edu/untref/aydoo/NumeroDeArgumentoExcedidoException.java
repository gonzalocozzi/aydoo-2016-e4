package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class NumeroDeArgumentoExcedidoException {
	
	@Test
	public void numeroDeArgumentosExcedidoExceptionDevuelveMensajeExplicativo(){
		
		NumeroDeArgumentosExcedidoException excepcion = new NumeroDeArgumentosExcedidoException("mensaje explicativo");
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "mensaje explicativo");
	}

}
