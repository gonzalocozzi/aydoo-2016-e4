package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CreadorDeCarpetaDeSalidaTest {
	
		
	@Test
	public void creadorDeCarpetaDeSalidaRecibeDireccionDeLaNuevaCarpeta(){
		
		String direccionDeLaNuevaCarpeta = "una direccion";
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(direccionDeLaNuevaCarpeta);
		
		Assert.assertEquals(direccionDeLaNuevaCarpeta, creadorDeCarpetaDeSalida.getDireccionDeLaCarpetaDeSalida());
	}

}
