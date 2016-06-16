package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.analisisDeArgumentos.SinNombreDelArchivoDeEntradaException;

public class SinNombreDelArchivoDeEntradaExceptionTest {
	
	@Test
	public void sinNombreDelArchivoDeEntradaExceptionDevuelveMensajeExplicativo(){
		
		List<String> listaDePrueba = new LinkedList<>();		
		SinNombreDelArchivoDeEntradaException excepcion = new SinNombreDelArchivoDeEntradaException(listaDePrueba);
		
		String mensajeExplicativo = excepcion.getMessage();
		
		Assert.assertEquals(mensajeExplicativo, "por favor, indique el nombre del archivo markdown de entrada.");
	}
	
	@Test(expected=SinNombreDelArchivoDeEntradaException.class)
	public void sinNombreDelArchivoDeEntradaExceptionSabeSiDebeSerLanzada(){
		
		List<String> listaDeArgumentos = new LinkedList<>();
		
		SinNombreDelArchivoDeEntradaException excepcion = new SinNombreDelArchivoDeEntradaException(listaDeArgumentos);
		
		excepcion.getNuevaInstancia();
	}

}
