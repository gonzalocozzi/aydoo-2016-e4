package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.analisisDeArgumentos.ArgumentoInvalidoException;

public class ArgumentoInvalidoExceptionTest {
	
	@Test
	public void argumentoInvalidoExceptionDevuelveMensajeExplicativo(){
		
		List<String> listaDePrueba = new LinkedList<>();		
		ArgumentoInvalidoException excepcion = new ArgumentoInvalidoException(listaDePrueba, "mensaje explicativo");
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "mensaje explicativo");
	}

}
