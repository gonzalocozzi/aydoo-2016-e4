package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CreadorDeCarpetaDeSalidaTest {
	
		
	@Test
	public void creadorDeCarpetaDeSalidaRecibeDireccionDeLaNuevaCarpeta(){
		
		String direccionDeLaNuevaCarpeta = "una direccion";
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(direccionDeLaNuevaCarpeta, null);
		
		String direccionAlmacenadaDeLaCarpeta = creadorDeCarpetaDeSalida.getDireccionDeLaCarpetaDeSalida();
		
		Assert.assertEquals(direccionDeLaNuevaCarpeta, direccionAlmacenadaDeLaCarpeta);
	}
	
	@Test
	public void creadorDeCarpetaDeSalidaRecibeNombreDeLaNuevaCarpeta(){
		
		String direccionDeLaNuevaCarpeta = "una direccion";
		String nombreDeLaNuevaCarpeta = "un nombre";
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(direccionDeLaNuevaCarpeta, nombreDeLaNuevaCarpeta);
		
		String nombreAlmacenadoDeLaCarpeta = creadorDeCarpetaDeSalida.getNombreDeLaCarpetaDeSalida();
		
		Assert.assertEquals(nombreDeLaNuevaCarpeta, nombreAlmacenadoDeLaCarpeta);
	}

}
