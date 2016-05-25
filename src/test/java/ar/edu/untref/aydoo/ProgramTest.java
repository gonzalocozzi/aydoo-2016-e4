package ar.edu.untref.aydoo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProgramTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();	

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@Test(expected=SinNombreDelArchivoDeEntradaException.class)
	public void sliderExigeElIngresoDeUnArgumentoConElNombreDelArchivoDeEntrada() throws IOException{
		
		String[] args = {};
		Program.main(args);
	}
<<<<<<< HEAD
	
=======
>>>>>>> 6d638cd12cab758dc5bcd616dca1b1aaef8556b9
}
