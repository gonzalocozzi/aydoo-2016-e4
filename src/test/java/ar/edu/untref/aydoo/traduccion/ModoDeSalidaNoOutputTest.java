package ar.edu.untref.aydoo.traduccion;

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

public class ModoDeSalidaNoOutputTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Rule	 
	public TemporaryFolder carpetaDePrueba = new TemporaryFolder();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void modoDeSalidaNoOutputLeeArchivoDeEntradaCorrectamenteYDevuelveSalidaHTMLPorConsola() throws IOException{

		File archivoDePrueba = carpetaDePrueba.newFile("mipresentacion1.md");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();

		PrintWriter writer = new PrintWriter(direccionDelArchivoTemporal);
		writer.println("#titulo");
		writer.println("##subtitulo");
		writer.close();	

		List<String> listaDeArgumentos = new ArrayList<>();
		listaDeArgumentos.add("mipresentacion1.md");
		listaDeArgumentos.add("--mode=no-output");

		ModoDeSalidaNoOutput modo = new ModoDeSalidaNoOutput(listaDeArgumentos, direccionDelArchivoTemporal);
		modo.traducir();

		String salidaEsperado = "Salida HTML generada\n"+"<h1>titulo</h1>\n"+"<h2>subtitulo</h2>";

		Assert.assertEquals(salidaEsperado, outContent.toString().trim());
	}	

}
