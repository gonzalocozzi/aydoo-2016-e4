package ar.edu.untref.aydoo.analisisDeArgumentos;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.analisisDeArgumentos.NumeroDeArgumentosExcedidoException;

public class NumeroDeArgumentoExcedidoExceptionTest {
	
	@Test
	public void numeroDeArgumentosExcedidoExceptionDevuelveMensajeExplicativo(){
		
		List<String> listaDeArgumentos = new LinkedList<>();		
		NumeroDeArgumentosExcedidoException excepcion = new NumeroDeArgumentosExcedidoException(listaDeArgumentos);
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "no debe ingresar mas de 2 argumentos. Por favor, intentelo nuevamente.");
	}
	
	@Test(expected=NumeroDeArgumentosExcedidoException.class)
	public void numeroDeArgumentosInvalidoExceptionSabeSiDebeSerLanzada(){
		
		List<String> listaDeArgumentos = new LinkedList<>();
		listaDeArgumentos.add("un argumento");
		listaDeArgumentos.add("otro argumento");
		listaDeArgumentos.add("argumento de mas");
		
		NumeroDeArgumentosExcedidoException excepcion = new NumeroDeArgumentosExcedidoException(listaDeArgumentos);
		
		excepcion.getNuevaInstancia();
	}

}
