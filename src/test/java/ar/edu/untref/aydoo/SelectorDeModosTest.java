package ar.edu.untref.aydoo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class SelectorDeModosTest {
	
	@Rule	 
	public TemporaryFolder carpetaDePrueba = new TemporaryFolder();
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@Test
	public void selectorGuardaArgumentosEnUnaLista(){
		
		String[] argumentos = {"mipresentacion1.md"};
		
		SelectorDeModos selector = new SelectorDeModos(argumentos);
		
		List<String> listaEsperada = new ArrayList<String>();
		listaEsperada.add("mipresentacion1.md");
		
		Assert.assertEquals(listaEsperada, selector.getListaDeArgumentos());		
	}
	
	@Test
	public void selectorCreaNombreDelArchivoDeEntradaConUnValidador(){
		
		String[] argumentos = {"mipresentacion1.md"};
		
		SelectorDeModos selector = new SelectorDeModos(argumentos);
		
		String nombreDeArchivoResultante = selector.getNombreDelArchivo();
		
		String nombreEsperado = "mipresentacion1.md";
		
		Assert.assertEquals(nombreEsperado, nombreDeArchivoResultante);
	}
	
	@Test
	public void selectorCreaNombreDeCarpetaDeSalida(){
		
		String[] argumentos = {"mipresentacion1.md"};
		
		SelectorDeModos selector = new SelectorDeModos(argumentos);
		
		String nombreDeArchivoResultante = selector.getNombreDeLaCarpetaDeSalida();
		
		String nombreEsperado = "mipresentacion1";
		
		Assert.assertEquals(nombreEsperado, nombreDeArchivoResultante);		
	}
	
	@Test
	public void selectorSeleccionModeDefault() throws IOException{
		
		String[] argumentos = {"mipresentacion1.md"};		
		SelectorDeModos selector = new SelectorDeModos(argumentos);
				
		File archivoDePrueba = carpetaDePrueba.newFile("mipresentacion1.md");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();
		
		PrintWriter writer = new PrintWriter(direccionDelArchivoTemporal);
		writer.println("primer renglon");
		writer.println("segundo renglon");
		writer.close();	
		
		selector.setArchivoDeEntrada(direccionDelArchivoTemporal);
		selector.setArchivoParaEscribirHtml(direccionDelArchivoTemporal);
		selector.seleccionarModoDefault();
				
		String salidaEsperado = "El archivo fue exportado con exito";
		
		archivoDePrueba.delete();
		
	    Assert.assertEquals(salidaEsperado, outContent.toString().trim());		
	}
}
