package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class EtiquetaDeImagenTest {
	
	@Test
	public void imagenSeCreaConPrefijo(){
		
		EtiquetaHTML imagen = new EtiquetaDeImagen();
		
		String prefijo = imagen.getPrefijo();
		
		Assert.assertEquals("<img src=\"", prefijo);
	}	
	
	@Test
	public void imagenSeCreaConSufijo(){
		
		EtiquetaHTML imagen = new EtiquetaDeImagen();
		
		String sufijo = imagen.getSufijo();
		
		Assert.assertEquals("\"/>", sufijo);
	}
	
	@Test
	public void seIncorporaRutaDeLaImagen(){
		
		EtiquetaHTML imagen = new EtiquetaDeImagen();	
		String ruta = "imagen.png";
		imagen.setTexto(ruta);
		
		String rutaDeLaImagen = imagen.getTexto();
		
		Assert.assertEquals(ruta, rutaDeLaImagen);		
	}
	
	@Test
	public void imagenDevuelveHTML(){
		
		EtiquetaHTML imagen = new EtiquetaDeImagen();	
		String ruta = "imagen.png";
		imagen.setTexto(ruta);
		
		String imagenHTML = imagen.getHTML();
		
		Assert.assertEquals("<img src=\"imagen.png\"/>", imagenHTML);	
	}

}
