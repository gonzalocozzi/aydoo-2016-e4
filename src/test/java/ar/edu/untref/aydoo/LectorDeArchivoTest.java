package ar.edu.untref.aydoo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class LectorDeArchivoTest {
	
	@Test
	public void lectorDeArchivoRecibeDireccionDelArchivoALeer() throws IOException{
		
		String direccionDelArchivo = "direccion de prueba";
		LectorDeArchivo lectorDeArchivo = new LectorDeArchivo();
		lectorDeArchivo.setDireccionDelArchivo(direccionDelArchivo);
		
		String direccionAlmacenada = lectorDeArchivo.getDireccionDelArchivo();
		
		Assert.assertEquals(direccionAlmacenada, direccionDelArchivo);
	}

}
