package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class LectorDeArchivoTest {
	
	@Rule	 
	public TemporaryFolder testFolder = new TemporaryFolder();
		
	@Test
	public void lectorDeArchivoRecibeDireccionDelArchivoALeer() throws IOException{
		
		String direccionDelArchivo = "direccion de prueba";
		LectorDeArchivo lectorDeArchivo = new LectorDeArchivo(direccionDelArchivo);
		
		String direccionAlmacenadaDelArchivo = lectorDeArchivo.getDireccionDelArchivo();
		
		Assert.assertEquals(direccionAlmacenadaDelArchivo, direccionDelArchivo);
	}
	
	@Test
	public void lectorDeArchivoDevuelveListaDeRenglonesDelArchivoConUnRenglon() throws IOException{
		
		File archivoDePrueba = new File("temp.txt");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();
		
		PrintWriter writer = new PrintWriter(direccionDelArchivoTemporal);
		writer.println("primer renglon");
		writer.close();
		
		LectorDeArchivo lectorDeArchivo = new LectorDeArchivo(direccionDelArchivoTemporal);
		List<String> listaDeLineasDelArchivo = lectorDeArchivo.getLineasDelArchivo();
		
		archivoDePrueba.delete();
		
		Assert.assertTrue(listaDeLineasDelArchivo.get(0).equals("primer renglon"));
	}
	
	@Test
	public void lectorDeArchivoDevuelveListaDeRenglonesDelArchivoConVariosRenglones() throws IOException{
		
		File archivoDePrueba = new File("temp.txt");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();
		
		PrintWriter writer = new PrintWriter(direccionDelArchivoTemporal);
		writer.println("primer renglon");
		writer.println("segundo renglon");
		writer.println("tercer renglon");
		writer.println("cuarto renglon");
		writer.close();
		
		LectorDeArchivo lectorDeArchivo = new LectorDeArchivo(direccionDelArchivoTemporal);
		List<String> listaDeLineasDelArchivo = lectorDeArchivo.getLineasDelArchivo();
		
		archivoDePrueba.delete();
		
		Assert.assertTrue(listaDeLineasDelArchivo.get(3).equals("cuarto renglon"));
	}

}
