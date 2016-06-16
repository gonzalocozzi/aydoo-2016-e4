package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.analisisDeArgumentos.ArgumentoInvalidoException;

public class ArgumentoInvalidoExceptionTest {
	
	@Test
	public void argumentoInvalidoExceptionDevuelveMensajeExplicativo(){
		
		List<String> listaDeArgumentos = new LinkedList<>();		
		ArgumentoInvalidoException excepcion = new ArgumentoInvalidoException(listaDeArgumentos);
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "ha ingresado al menos un argumento invalido. Por favor, intentelo nuevamente.");
	}

}
