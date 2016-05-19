package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TextoSinFormatoTest {
	
	@Test
	public void textoSinFormatoSeCreaSinPrefijo(){
		
		TextoSinFormato textoSinFormato = new TextoSinFormato();
		
		String prefijo = textoSinFormato.getPrefijo();
		
		Assert.assertEquals("", prefijo);
	}

}
