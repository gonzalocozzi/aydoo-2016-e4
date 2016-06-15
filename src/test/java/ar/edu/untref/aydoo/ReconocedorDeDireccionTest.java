package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.io.ReconocedorDeDireccionDelJAR;

public class ReconocedorDeDireccionTest {
	
	@Test
	public void creadorDeCarpetaDeSalidaDevuelveDireccionDelJAR() throws IOException{
		
		File archivo = new File(System.getProperty("java.class.path"));
		File direccion = archivo.getAbsoluteFile().getParentFile();		
		String direccionDelJAR = direccion.toString();
		
		ReconocedorDeDireccionDelJAR reconocedor = new ReconocedorDeDireccionDelJAR();
		String direccionAlmacenadaDelJAR = reconocedor.getDireccionDelJAR();
		
		Assert.assertEquals(direccionDelJAR, direccionAlmacenadaDelJAR);
	}
	
}
