package ar.edu.untref.aydoo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import ar.edu.untref.aydoo.etiquetas.Etiqueta;
import ar.edu.untref.aydoo.etiquetas.Subtitulo;
import ar.edu.untref.aydoo.etiquetas.Titulo;
import ar.edu.untref.aydoo.traduccion.ModoDeSalida;

public class ModoDeSalidaTest {
	
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
	public void modoDeSalidaGuardaElNombreDelArchivoDeEntrada(){
		
		List<String> listaDeArgumentos = new ArrayList<>();
		
		ModoDeSalida modo = new ModoDeSalida(listaDeArgumentos, "archivo.txt");
		String archivo = "archivo.txt";
		Assert.assertEquals(archivo, modo.getNombreDeArchivoDeEntrada());
	}
	
	@Test
	public void modoDeSalidaLeeArchivoDeEntradaCorrectamenteYDevuelveListaDeLineasMarkdown() throws IOException{
		
		File archivoDePrueba = carpetaDePrueba.newFile("mipresentacion1.md");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();
		
		PrintWriter writer = new PrintWriter(direccionDelArchivoTemporal);
		writer.println("primer renglon");
		writer.println("segundo renglon");
		writer.close();	
		
		List<String> listaDeLineasEsperada = new ArrayList<>();
		listaDeLineasEsperada.add("primer renglon");
		listaDeLineasEsperada.add("segundo renglon");
			
		List<String> listaDeArgumentosAux = new ArrayList<>();
		listaDeArgumentosAux.add("mipresentacion1.md");
		ModoDeSalida modo = new ModoDeSalida(listaDeArgumentosAux, direccionDelArchivoTemporal);
		
		Assert.assertEquals(listaDeLineasEsperada, modo.leerArchivoDeEntrada());		
	}
	
	@Test
	public void modoDeSalidaCreaEtiquetasHTMLCorrectamente(){
		
		List<String> listaMD = new LinkedList<>();
		listaMD.add("# titulo");
		listaMD.add("## subtitulo");
		
		List<String> listaDeArgumentosAux = new ArrayList<>();
		listaDeArgumentosAux.add("mipresentacion1.md");
		ModoDeSalida modo = new ModoDeSalida(listaDeArgumentosAux, "archivo.txt");
		
		List<Etiqueta> listaHTML = new LinkedList<>();
		
		Titulo titulo = new Titulo();
		titulo.setTexto("titulo");
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("subtitulo");
		
		listaHTML.add(titulo);
		listaHTML.add(subtitulo);
		
		Assert.assertEquals(listaHTML.get(0).getClass(), modo.crearEtiquetasHTML(listaMD).get(0).getClass());	
		Assert.assertEquals(listaHTML.get(1).getClass(), modo.crearEtiquetasHTML(listaMD).get(1).getClass());
	}
	
	@Test
	public void modoDeSalidaCreaSalidaHTMLCorrectamente(){
		
		List<String> listaDeArgumentosAux = new ArrayList<>();
		listaDeArgumentosAux.add("mipresentacion1.md");
		ModoDeSalida modo = new ModoDeSalida(listaDeArgumentosAux, "archivo.txt");
		
		List<Etiqueta> listaHTML = new LinkedList<>();
		
		Titulo titulo = new Titulo();
		titulo.setTexto("titulo");
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("subtitulo");
		
		listaHTML.add(titulo);
		listaHTML.add(subtitulo);
		
		List<String> listaSalidaHTMLEsperada = new LinkedList<>();
		listaSalidaHTMLEsperada.add("<h1>titulo</h1>");
		listaSalidaHTMLEsperada.add("<h2>subtitulo</h2>");
		
		Assert.assertEquals(listaSalidaHTMLEsperada, modo.crearSalidaHTMLEstandar(listaHTML));
		
	}
	
	@Test
	public void modoDeSalidaCreaListaHTMLDeSalidaATravesDeTestIntegral() throws IOException{
		
		File archivoDePrueba = carpetaDePrueba.newFile("mipresentacion1.md");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();
		
		PrintWriter writer = new PrintWriter(direccionDelArchivoTemporal);
		writer.println("#titulo");
		writer.println("##subtitulo");
		writer.close();	
			
		List<String> listaEsperada = new ArrayList<>();
		listaEsperada.add("<h1>titulo</h1>");
		listaEsperada.add("<h2>subtitulo</h2>");
		
		List<String> listaDeArgumentos = new ArrayList<>();
		listaDeArgumentos.add("mipresentacion1.md");
		ModoDeSalida modo = new ModoDeSalida(listaDeArgumentos, direccionDelArchivoTemporal);
		modo.traducir();
		Assert.assertEquals(listaEsperada, modo.getListaHTMLDeSalida());
	}

}
