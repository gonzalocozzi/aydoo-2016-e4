package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class EscritorDeArchivoTest {
	
	@Rule	 
	public TemporaryFolder testFolder = new TemporaryFolder();
	
	@Test
	public void recibeListaDeLineasVacia(){
		
		List<String> listaDeLineas = new LinkedList<String>();
		
		EscritorDeArchivo escritor = new EscritorDeArchivo();
		escritor.setListaAEscribir(listaDeLineas);
		
		Assert.assertEquals(listaDeLineas, escritor.getListaDeLineas());
	}

	@Test(expected = IOException.class)
	public void recibeNombreArchivoInvalidoLanzaIOException() throws IOException{
		
		File archivoDePrueba = new File("");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();
		
		EscritorDeArchivo escritor = new EscritorDeArchivo();
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("primer renglon");
		listaDeLineas.add("segundo renglon");
		escritor.setListaAEscribir(listaDeLineas);
		escritor.escribirEnArchivo(direccionDelArchivoTemporal);
	}	
	
	@Test
	public void guardaLineaDeArchivoQueNoHayQueReemplazarPorHtmlEntrante(){
		
		EscritorDeArchivo escritor = new EscritorDeArchivo();
		List<String> listaDeLineas = new LinkedList<String>();
		listaDeLineas.add("primera linea");
		escritor.setListaAEscribir(listaDeLineas);
		String entradaResultante = "";
		String lineaAEscribir = escritor.guardarLineaDeEntrada("<div>", entradaResultante);
		
		String lineaEsperada = "<div>"+"\n";
		
		Assert.assertEquals(lineaEsperada, lineaAEscribir);
	}
}
