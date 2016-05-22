package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

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
	public void laRepresentacionDeLaImagenEstaAsociadaConUnObjetoDeTipoImagen(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertEquals(Imagen.class, miCreador.getDiccionario().get("i:").getClass());
	}
	
	@Test
	public void seTieneLaRepresentacionDeUnItem(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertEquals(true, miCreador.getDiccionario().containsKey("*"));
	}
	
	@Test
	public void laRepresentacionDeUnItemEstaAsociadaConUnObjetoDeTipoItem(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertEquals(ItemDeLista.class, miCreador.getDiccionario().get("*").getClass());
	}
	
	@Test
	public void seTieneLaRepresentacionDeUnaSeccion(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertEquals(true, miCreador.getDiccionario().containsKey("---"));
	}
	
	@Test
	public void laRepresentacionDeUnaSeccionEstaAsociadaConUnObjetoDeTipoSeccion(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		Assert.assertEquals(Seccion.class, miCreador.getDiccionario().get("---").getClass());
	}
	
	@Test
	public void seGeneraUnaListaDeUnaEtiquetaDeTipoTituloYSubtituloAPartirDeUnaLista(){
		CreadorDeEtiquetas miCreador = new CreadorDeEtiquetas();
		List<String> miLista = new LinkedList<String>();
		miLista.add("#tituloDePrueba");
		miLista.add("##subtituloDePrueba");
		Assert.assertEquals(Titulo.class, miCreador.crearListaDeEtiquetas(miLista).get(0).getClass());
	}
}
