package ar.edu.untref.aydoo;

import java.io.File;
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
	
	@Test
	public void creadorDeCarpetaDeSalidaIndicaDireccionCompletaDeLaNuevaCarpeta() throws IOException{
		
		File archivo = new File(System.getProperty("java.class.path"));
		File direccion = archivo.getAbsoluteFile().getParentFile();		
		String direccionDeLaCarpetaDeSalida = direccion.toString();
		
		String nombreDeLaCarpetaDeSalida = "un nombre";
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(nombreDeLaCarpetaDeSalida);
		
		String direccionAlmacenadaDeLaCarpeta = creadorDeCarpetaDeSalida.getDireccionDeLaCarpetaDeSalida();
		
		Assert.assertEquals(direccionDeLaCarpetaDeSalida + "/" + "un nombre", direccionAlmacenadaDeLaCarpeta);
	}
	
	@Test
	public void creadorDeCarpetaDeSalidaDevuelveDireccionDelJAR() throws IOException{
		
		File archivo = new File(System.getProperty("java.class.path"));
		File direccion = archivo.getAbsoluteFile().getParentFile();		
		String direccionDelJAR = direccion.toString();
		
		String nombreDeLaCarpetaDeSalida = "un nombre";
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(nombreDeLaCarpetaDeSalida);
		
		String direccionAlmacenadaDelJAR = creadorDeCarpetaDeSalida.getDireccionDelJAR();
		
		Assert.assertEquals(direccionDelJAR, direccionAlmacenadaDelJAR);
	}

}
