package ar.edu.untref.aydoo.analisisDeArgumentos;

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

import ar.edu.untref.aydoo.analisisDeArgumentos.SelectorDeModo;

public class SelectorDeModoTest {
	
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
	public void selectorGuardaArgumentosEnUnaLista() throws IOException{
		
		String[] argumentos = {"mipresentacion1.md"};		
		SelectorDeModo selector = new SelectorDeModo(argumentos);		
		List<String> listaEsperada = new ArrayList<String>();
		listaEsperada.add("mipresentacion1.md");
		
		List<String> listaHTMLALmacenada = selector.getListaDeArgumentos();
		
		Assert.assertEquals(listaEsperada, listaHTMLALmacenada);		
	}
	
	@Test
	public void selectorSeleccionaModeDefault() throws IOException{
		
		String[] argumentos = {"mipresentacion1.md"};		
		SelectorDeModo selector = new SelectorDeModo(argumentos);
				
		File archivoDePrueba = carpetaDePrueba.newFile("mipresentacion1.md");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();
		
		PrintWriter writer = new PrintWriter(direccionDelArchivoTemporal);
		writer.println("primer renglon");
		writer.println("segundo renglon");
		writer.close();	
		
		selector.setNombreDelArchivoDeEntrada(direccionDelArchivoTemporal);
		selector.setDireccionDelArchivoParaEscribirConSalidaHTML(direccionDelArchivoTemporal);
		
		selector.seleccionarModoDefault();
				
		String salidaEsperada = "El archivo fue exportado con exito.";
		
		archivoDePrueba.delete();
		
	    Assert.assertEquals(salidaEsperada, outContent.toString().trim());		
	}
	
	@Test
	public void selectorSeleccionModeNoOutput() throws IOException{
		
		String[] argumentos = {""};		
		SelectorDeModo selector = new SelectorDeModo(argumentos);
				
		File archivoDePrueba = carpetaDePrueba.newFile("mipresentacion1.md");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();
		
		PrintWriter writer = new PrintWriter(direccionDelArchivoTemporal);
		writer.println("primer renglon");
		writer.println("segundo renglon");
		writer.close();	
		
		selector.setNombreDelArchivoDeEntrada(direccionDelArchivoTemporal);
		selector.setDireccionDelArchivoParaEscribirConSalidaHTML(direccionDelArchivoTemporal);
		
		selector.seleccionarModoNoOutput();
				
		String salidaEsperada = "Salida HTML generada\n"+"primer renglon\n"+"segundo renglon";
		
		archivoDePrueba.delete();
		
	    Assert.assertEquals(salidaEsperada, outContent.toString().trim());		
	}
	
	@Test
	public void selectorAnalizaQueModoSeleccionarYResultaNoOutput() throws IOException{
		
		String[] argumentos = {"mipresentacion1.md","--mode=no-output"};		
		SelectorDeModo selector = new SelectorDeModo(argumentos);
		
		File archivoDePrueba = carpetaDePrueba.newFile("mipresentacion1.md");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();
		
		PrintWriter writer = new PrintWriter(direccionDelArchivoTemporal);
		writer.println("primer renglon");
		writer.println("segundo renglon");
		writer.close();	
		
		selector.setNombreDelArchivoDeEntrada(direccionDelArchivoTemporal);
		selector.setDireccionDelArchivoParaEscribirConSalidaHTML(direccionDelArchivoTemporal);
		
		selector.seleccionarModo();
		
		String salidaEsperado = "Salida HTML generada\n"+"primer renglon\n"+"segundo renglon";
		
		Assert.assertEquals(salidaEsperado, outContent.toString().trim());		
	}
	
	@Test
	public void selectorAnalizaQueModoSeleccionarYResultaDefaultCuandoNoSeIndicaNingunModoPorArgumento() throws IOException{
		
		String[] argumentos = {"mipresentacion1.md"};		
		SelectorDeModo selector = new SelectorDeModo(argumentos);
				
		File archivoDePrueba = carpetaDePrueba.newFile("mipresentacion1.md");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();
		
		PrintWriter writer = new PrintWriter(direccionDelArchivoTemporal);
		writer.println("primer renglon");
		writer.println("segundo renglon");
		writer.close();	
		
		selector.setNombreDelArchivoDeEntrada(direccionDelArchivoTemporal);
		selector.setDireccionDelArchivoParaEscribirConSalidaHTML(direccionDelArchivoTemporal);
		
		selector.seleccionarModo();
				
		String salidaEsperado = "El archivo fue exportado con exito.";
		
		archivoDePrueba.delete();
		
	    Assert.assertEquals(salidaEsperado, outContent.toString().trim());		
	}
	
	@Test
	public void selectorAnalizaQueModoSeleccionarYResultaDefault() throws IOException{
		
		String[] argumentos = {"mipresentacion1.md", "--mode=default"};		
		SelectorDeModo selector = new SelectorDeModo(argumentos);
				
		File archivoDePrueba = carpetaDePrueba.newFile("mipresentacion1.md");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();
		
		PrintWriter writer = new PrintWriter(direccionDelArchivoTemporal);
		writer.println("primer renglon");
		writer.println("segundo renglon");
		writer.close();	
		
		selector.setNombreDelArchivoDeEntrada(direccionDelArchivoTemporal);
		selector.setDireccionDelArchivoParaEscribirConSalidaHTML(direccionDelArchivoTemporal);
		
		selector.seleccionarModo();
				
		String salidaEsperado = "El archivo fue exportado con exito.";
		
		archivoDePrueba.delete();
		
	    Assert.assertEquals(salidaEsperado, outContent.toString().trim());		
	}
	
}
