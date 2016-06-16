package ar.edu.untref.aydoo.analisisDeArgumentos;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.analisisDeArgumentos.NombreInvalidoException;

public class NombreInvalidoExceptionTest {
	
	@Test
	public void nombreInvalidoExceptionDevuelveMensajeExplicativo(){
		
		NombreInvalidoException excepcion = new NombreInvalidoException();
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "el nombre del archivo de entrada no es valido. Por favor, intentelo nuevamente.");
	}

}
