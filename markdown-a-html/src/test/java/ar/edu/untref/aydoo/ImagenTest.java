package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ImagenTest {
	
	@Test
	public void imagenSeCreaConPrefijo(){
		
		MarcaDeTexto imagen = new Imagen();
		
		String prefijo = imagen.getPrefijo();
		
		Assert.assertEquals("<img src=\"", prefijo);
	}	
	
	@Test
	public void imagenSeCreaConSufijo(){
		
		MarcaDeTexto imagen = new Imagen();
		
		String sufijo = imagen.getSufijo();
		
		Assert.assertEquals("\"/>", sufijo);
	}

}
