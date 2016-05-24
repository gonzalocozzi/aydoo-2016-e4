package ar.edu.untref.aydoo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class CreadorDeCarpetaDeSalidaTest {
	
	@Test
	public void creadorDeCarpetaDeSalidaRecibeUbicacionDeLaNuevaCarpeta() throws IOException{
				
		String direccionDeLaCarpetaDeSalida = "una direccion";
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(direccionDeLaCarpetaDeSalida, "");
		
		String direccionAlmacenadaDeLaCarpeta = creadorDeCarpetaDeSalida.getDireccionDeLaCarpetaDeSalida();
		
		Assert.assertEquals(direccionDeLaCarpetaDeSalida + "/", direccionAlmacenadaDeLaCarpeta);
	}
	
	@Test
	public void creadorDeCarpetaDeSalidaRecibeNombreDeLaNuevaCarpeta() throws IOException{
		
		String direccionDeLaCarpetaDeSalida = "una direccion";
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(direccionDeLaCarpetaDeSalida, "un nombre");
		
		String nombreAlmacenadoDeLaCarpeta = creadorDeCarpetaDeSalida.getNombreDeLaCarpetaDeSalida();
		
		Assert.assertEquals("un nombre", nombreAlmacenadoDeLaCarpeta);
	}
	
	@Test
	public void creadorDeCarpetaDeSalidaIndicaDireccionCompletaDeLaNuevaCarpeta() throws IOException{
		
		String direccionDeLaCarpetaDeSalida = "una direccion";
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(direccionDeLaCarpetaDeSalida, "un nombre");
		
		String direccionAlmacenadaDeLaCarpeta = creadorDeCarpetaDeSalida.getDireccionDeLaCarpetaDeSalida();
		
		Assert.assertEquals(direccionDeLaCarpetaDeSalida + "/" + "un nombre", direccionAlmacenadaDeLaCarpeta);
	}

}
