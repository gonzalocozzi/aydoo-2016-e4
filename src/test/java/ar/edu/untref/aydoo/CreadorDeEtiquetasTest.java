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
	public void laRepresentacionDelTituloEstaAsociadaConUnObjetoDeTipoTitulo(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertEquals(Titulo.class, miCreador.getDiccionario().get("#").getClass());
	}
	
	@Test
	public void seTieneLaRepresentacionDelSubtitulo(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertEquals(true, miCreador.getDiccionario().containsKey("##"));
	}
	
	@Test
	public void laRepresentacionDelSubtituloEstaAsociadaConUnObjetoDeTipoSubtitulo(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertEquals(Subtitulo.class, miCreador.getDiccionario().get("##").getClass());
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