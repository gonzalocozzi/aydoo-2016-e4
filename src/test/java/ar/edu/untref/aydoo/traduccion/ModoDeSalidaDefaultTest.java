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

public class ModoDeSalidaDefaultTest {
	
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
	public void modoDeSalidaDefaultEscribeArchivoConSalidaHTML() throws IOException{
		
		File archivoDePrueba = carpetaDePrueba.newFile("mipresentacion1.md");
		String direccionDelArchivoTemporal = archivoDePrueba.getAbsolutePath();

		PrintWriter writer = new PrintWriter(direccionDelArchivoTemporal);
		writer.println("#titulo");
		writer.println("##subtitulo");
		writer.close();	

		List<String> listaDeArgumentos = new ArrayList<>();
		listaDeArgumentos.add("mipresentacion1.md");
		listaDeArgumentos.add("--mode=default");

		ModoDeSalidaDefault modo = new ModoDeSalidaDefault(listaDeArgumentos, direccionDelArchivoTemporal);
		modo.setDireccionDelArchivoAEscribirConSalidaHTML(direccionDelArchivoTemporal);
		modo.traducir();

		String salidaEsperada = "El archivo fue exportado con exito.";

		Assert.assertEquals(salidaEsperada, outContent.toString().trim());
	}

}
