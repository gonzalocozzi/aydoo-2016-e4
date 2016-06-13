package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.analisisDeArgumentos.NumeroDeArgumentosExcedidoException;

public class NumeroDeArgumentoExcedidoExceptionTest {
	
	@Test
	public void numeroDeArgumentosExcedidoExceptionDevuelveMensajeExplicativo(){
		
		List<String> listaDePrueba = new LinkedList<>();		
		NumeroDeArgumentosExcedidoException excepcion = new NumeroDeArgumentosExcedidoException(listaDePrueba, "mensaje explicativo");
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "mensaje explicativo");
	}

}
