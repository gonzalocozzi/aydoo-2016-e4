package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class EscritorDeArchivoHTMLTest {
	
	@Rule	 
	public TemporaryFolder testFolder = new TemporaryFolder();
	
	@Test
	public void recibeListaDeLineasVacia(){
		
		List<String> listaDeLineas = new LinkedList<String>();
		
		EscritorDeArchivo escritor = new EscritorDeArchivo();
		escritor.setListaAEscribir(listaDeLineas);
		
		Assert.assertEquals(listaDeLineas, escritor.getListaDeLineas());
	}
	
	@Test
	public void escritorDeArchivoDevuelveListaDeRenglonesDelArchivoConUnRenglon() throws IOException{
		
		File archivoDePrueba = new File("temp.txt");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();
		
		EscritorDeArchivo escritor = new EscritorDeArchivo();
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("primer renglon");
		escritor.setListaAEscribir(listaDeLineas);
		escritor.escribirEnArchivo(direccionDelArchivoTemporal);
				
		LectorDeArchivo lectorDeArchivo = new LectorDeArchivo(direccionDelArchivoTemporal);
		List<String> listaDeRenglonesDelArchivo = lectorDeArchivo.getListaDeRenglonesDelArchivo();
		
		archivoDePrueba.delete();
		
		Assert.assertTrue(listaDeRenglonesDelArchivo.get(0).equals("primer renglon"));
	}
	
	@Test
	public void escritorDeArchivoEscribeListaConTresRenglones() throws IOException{
		
		File archivoDePrueba = new File("temp.txt");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();
		
		EscritorDeArchivo escritor = new EscritorDeArchivo();
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("primer renglon");
		listaDeLineas.add("segundo renglon");
		escritor.setListaAEscribir(listaDeLineas);
		escritor.escribirEnArchivo(direccionDelArchivoTemporal);
				
		LectorDeArchivo lectorDeArchivo = new LectorDeArchivo(direccionDelArchivoTemporal);
		List<String> listaDeRenglonesDelArchivo = lectorDeArchivo.getListaDeRenglonesDelArchivo();
		
		archivoDePrueba.delete();
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("primer renglon");
		listaEsperada.add("segundo renglon");
		
		Assert.assertEquals(listaEsperada,listaDeRenglonesDelArchivo);
	}
}
