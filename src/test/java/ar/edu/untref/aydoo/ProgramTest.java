package ar.edu.untref.aydoo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ProgramTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Rule	 
	public TemporaryFolder testFolder = new TemporaryFolder();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
}
