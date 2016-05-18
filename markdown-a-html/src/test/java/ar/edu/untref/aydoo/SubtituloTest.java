package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SubtituloTest {
	
	@Test
	public void subtituloSeCreaConPrefijo(){
		
		Subtitulo subtitulo = new Subtitulo();
		
		String prefijo = subtitulo.getPrefijo();
		
		Assert.assertEquals("<h2>", prefijo);
	}

}
