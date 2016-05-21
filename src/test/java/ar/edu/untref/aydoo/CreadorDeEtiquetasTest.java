package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CreadorDeEtiquetasTest {

	@Test
	public void seTieneLaRepresentacionDelTitulo(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertEquals(true, miCreador.getDiccionario().containsKey("#"));
	}
	
	@Test
	public void seTieneLaRepresentacionDelSubtitulo(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertEquals(true, miCreador.getDiccionario().containsKey("##"));
	}
	
	@Test
	public void seTieneLaRepresentacionDeLaImagen(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertEquals(true, miCreador.getDiccionario().containsKey("i:"));
	}
	
	@Test
	public void seTieneLaRepresentacionDeUnItem(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertEquals(true, miCreador.getDiccionario().containsKey("*"));
	}
	
	@Test
	public void seTieneLaRepresentacionDeUnaSeccion(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertEquals(true, miCreador.getDiccionario().containsKey("---"));
	}
}
