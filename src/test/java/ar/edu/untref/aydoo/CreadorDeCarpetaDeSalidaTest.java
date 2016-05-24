package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CreadorDeCarpetaDeSalidaTest {
	
		
	@Test
	public void creadorDeCarpetaDeSalidaRecibeUbicacionDeLaNuevaCarpeta(){
		
		String direccionDeLaCarpetaDeSalida = "una direccion";
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(direccionDeLaCarpetaDeSalida, "");
		
		String direccionAlmacenadaDeLaCarpeta = creadorDeCarpetaDeSalida.getDireccionDeLaCarpetaDeSalida();
		
		Assert.assertEquals(direccionDeLaCarpetaDeSalida + "/", direccionAlmacenadaDeLaCarpeta);
	}
	
	@Test
	public void creadorDeCarpetaDeSalidaRecibeNombreDeLaNuevaCarpeta(){
		
		String direccionDeLaCarpetaDeSalida = "una direccion";
		String nombreDeLaNuevaCarpeta = "un nombre";
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(direccionDeLaCarpetaDeSalida, nombreDeLaNuevaCarpeta);
		
		String nombreAlmacenadoDeLaCarpeta = creadorDeCarpetaDeSalida.getNombreDeLaCarpetaDeSalida();
		
		Assert.assertEquals(nombreDeLaNuevaCarpeta, nombreAlmacenadoDeLaCarpeta);
	}
	
	@Test
	public void creadorDeCarpetaDeSalidaIndicaDireccionCompletaDeLaNuevaCarpeta(){
		
		String direccionDeLaCarpetaDeSalida = "una direccion";
		String nombreDeLaNuevaCarpeta = "un nombre";
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(direccionDeLaCarpetaDeSalida, nombreDeLaNuevaCarpeta);
		
		String direccionAlmacenadaDeLaCarpeta = creadorDeCarpetaDeSalida.getDireccionDeLaCarpetaDeSalida();
		
		Assert.assertEquals(direccionDeLaCarpetaDeSalida + "/" + nombreDeLaNuevaCarpeta, direccionAlmacenadaDeLaCarpeta);
	}

}
