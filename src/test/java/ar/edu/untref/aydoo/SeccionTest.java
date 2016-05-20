package ar.edu.untref.aydoo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SeccionTest {

	@Test
	public void seccionSeCreaConPrefijo(){

		Seccion seccion = new Seccion();

		String prefijo = seccion.getPrefijo();

		Assert.assertEquals("<section>", prefijo);
	}

	@Test
	public void seccionSeCreaConSufijo(){

		Seccion seccion = new Seccion();

		String sufijo = seccion.getSufijo();

		Assert.assertEquals("</section>", sufijo);
	}

	@Test
	public void seccionAgregaUnTitulo(){

		Seccion seccion = new Seccion();
		Titulo titulo = new Titulo();
		seccion.agregarElemento(titulo);

		List<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(titulo));
	}

	@Test
	public void seccionAgregaUnSubtitulo(){

		Seccion seccion = new Seccion();
		Subtitulo subtitulo = new Subtitulo();
		seccion.agregarElemento(subtitulo);

		List<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(subtitulo));
	}

	@Test
	public void seccionAgregaTextoSinFormato(){

		Seccion seccion = new Seccion();
		TextoSinFormato textoSinFormato = new TextoSinFormato();
		textoSinFormato.setTexto("solo texto sin nada mas");
		seccion.agregarElemento(textoSinFormato);

		List<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(textoSinFormato));
	}

	@Test
	public void seccionAgregaUnaImagen(){

		Seccion seccion = new Seccion();
		Imagen imagen = new Imagen();
		seccion.agregarElemento(imagen);

		List<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(imagen));
	}

	@Test
	public void seccionAgregaUnaListaSinOrden(){

		Seccion seccion = new Seccion();
		ListaSinOrden listaSinOrden = new ListaSinOrden();

		seccion.agregarElemento(listaSinOrden);

		List<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();

		Assert.assertTrue(listaDeElementos.contains(listaSinOrden));
	}
}
