package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ImagenTest {
	
	@Test
	public void imagenSeCreaConPrefijo(){
		
		EtiquetaHTML imagen = new Imagen();
		
		String prefijo = imagen.getPrefijo();
		
		Assert.assertEquals("<img src=\"", prefijo);
	}	
	
	@Test
	public void imagenSeCreaConSufijo(){
		
		EtiquetaHTML imagen = new Imagen();
		
		String sufijo = imagen.getSufijo();
		
		Assert.assertEquals("\"/>", sufijo);
	}
	
	@Test
	public void seIncorporaRutaDeLaImagen(){
		
		EtiquetaHTML imagen = new Imagen();	
		String ruta = "imagen.png";
		imagen.setTexto(ruta);
		
		String rutaDeLaImagen = imagen.getTexto();
		
		Assert.assertEquals(ruta, rutaDeLaImagen);		
	}
	
	@Test
	public void imagenDevuelveHTML(){
		
		EtiquetaHTML imagen = new Imagen();	
		String ruta = "imagen.png";
		imagen.setTexto(ruta);
		
		String imagenHTML = imagen.getHTML();
		
		Assert.assertEquals("<img src=\"imagen.png\"/>", imagenHTML);	
	}

}
