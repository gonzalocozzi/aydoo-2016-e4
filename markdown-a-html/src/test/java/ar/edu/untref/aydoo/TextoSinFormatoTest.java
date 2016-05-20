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
	
	@Test
	public void textoSinFormatoSeCreaSinSufijo(){
		
		TextoSinFormato textoSinFormato = new TextoSinFormato();
		
		String sufijo = textoSinFormato.getSufijo();
		
		Assert.assertEquals("", sufijo);
	}
	
	@Test
	public void seIncorporaTextoAlTextoSinFormato(){
		
		TextoSinFormato textoSinFormato = new TextoSinFormato();	
		String contenido = "solo texto sin nada mas";
		textoSinFormato.setTexto(contenido);
		
		String textoDevuelto = textoSinFormato.getTexto();
		
		Assert.assertEquals(contenido, textoDevuelto);		
	}
}