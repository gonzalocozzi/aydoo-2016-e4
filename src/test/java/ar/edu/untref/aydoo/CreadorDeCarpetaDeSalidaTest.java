package ar.edu.untref.aydoo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class CreadorDeCarpetaDeSalidaTest {
	
	@Rule	 
	public TemporaryFolder testFolder = new TemporaryFolder();
	
	@Test
	public void creadorDeCarpetaDeSalidaRecibeNombreDeLaNuevaCarpeta() throws IOException{
		
		String nombreDeLaCarpetaDeSalida = "un nombre";
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(nombreDeLaCarpetaDeSalida);
		
		String nombreAlmacenadoDeLaCarpeta = creadorDeCarpetaDeSalida.getNombreDeLaCarpetaDeSalida();
		
		Assert.assertEquals("un nombre", nombreAlmacenadoDeLaCarpeta);
	}
}
