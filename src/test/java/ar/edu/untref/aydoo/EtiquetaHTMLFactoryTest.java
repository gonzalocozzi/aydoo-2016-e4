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
	public void etiquetaHTMLFactoryDevuelveUnSubitulo(){
		
		EtiquetaHTMLFactory creadorDeEtiquetas = new EtiquetaHTMLFactory();
		
		EtiquetaHTML etiquetaCreada = creadorDeEtiquetas.crearEtiqueta("##");
		
		Assert.assertEquals(etiquetaCreada.getClass(), Subtitulo.class);
	}

}
