package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class EtiquetaHTMLFactoryTest {
	
	@Test
	public void etiquetaHTMLFactoryDevuelveUnTitulo(){
		
		EtiquetaHTMLFactory creadorDeEtiquetas = new EtiquetaHTMLFactory();
		
		EtiquetaHTML etiquetaCreada = creadorDeEtiquetas.crearEtiqueta("#");
		
		Assert.assertEquals(etiquetaCreada.getClass(), Titulo.class);
	}
	
	@Test
	public void etiquetaHTMLFactoryDevuelveUnSubtitulo(){
		
		EtiquetaHTMLFactory creadorDeEtiquetas = new EtiquetaHTMLFactory();
		
		EtiquetaHTML etiquetaCreada = creadorDeEtiquetas.crearEtiqueta("##");
		
		Assert.assertEquals(etiquetaCreada.getClass(), Subtitulo.class);
	}
	
	@Test
	public void etiquetaHTMLFactoryDevuelveUnaImagen(){
		
		EtiquetaHTMLFactory creadorDeEtiquetas = new EtiquetaHTMLFactory();
		
		EtiquetaHTML etiquetaCreada = creadorDeEtiquetas.crearEtiqueta("i:");
		
		Assert.assertEquals(etiquetaCreada.getClass(), Imagen.class);
	}
	
	@Test
	public void etiquetaHTMLFactoryDevuelveUnItemDeLista(){
		
		EtiquetaHTMLFactory creadorDeEtiquetas = new EtiquetaHTMLFactory();
		
		EtiquetaHTML etiquetaCreada = creadorDeEtiquetas.crearEtiqueta("*");
		
		Assert.assertEquals(etiquetaCreada.getClass(), ItemDeLista.class);
	}

}
