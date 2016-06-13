package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.creacionDeEtiquetas.VisitorDeEtiquetas;
import ar.edu.untref.aydoo.etiquetas.EtiquetaHTML;
import ar.edu.untref.aydoo.etiquetas.Imagen;

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
	public void imagenAceptaElVisitor(){
		
		Imagen imagen = new Imagen();
		imagen.setTexto("imagen.jpg");
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		imagen.aceptarVisitor(visitor);
		
		String resultadoEsperado = "<img src=\"imagen.jpg\"/>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void laImagenSeCreaConSuEncabezadoMD(){
		Imagen imagen = new Imagen();
		String encabezadoObtenido = imagen.getEncabezado();
		
		String encabezadoEsperado = "i:";
				
		Assert.assertEquals(encabezadoEsperado, encabezadoObtenido);
	}
	
	@Test
	public void laImagenSabeReconocerseYCrearseAPartirDeUnaEntradaMD(){
		String entrada = "i:imagen.jpg";
		Imagen imagen = new Imagen();
		
		Assert.assertEquals(Imagen.class, imagen.crearConMD(entrada).getClass());
	}
}
