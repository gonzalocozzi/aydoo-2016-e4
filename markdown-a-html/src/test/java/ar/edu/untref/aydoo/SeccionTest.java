package ar.edu.untref.aydoo;

import java.util.ArrayList;

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
		
		ArrayList<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();
		
		Assert.assertTrue(listaDeElementos.contains(titulo));
	}
	
	@Test
	public void seccionAgregaUnSubtitulo(){
		
		Seccion seccion = new Seccion();
		Subtitulo subtitulo = new Subtitulo();
		seccion.agregarElemento(subtitulo);
		
		ArrayList<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();
		
		Assert.assertTrue(listaDeElementos.contains(subtitulo));
	}
	
	@Test
	public void seccionAgregaTextoSinFormato(){
		
		Seccion seccion = new Seccion();
		TextoSinFormato textoSinFormato = new TextoSinFormato("solo texto sin nada mas");
		seccion.agregarElemento(textoSinFormato);
		
		ArrayList<EtiquetaHTML> listaDeElementos = seccion.getListaDeElementos();
		
		Assert.assertTrue(listaDeElementos.contains(textoSinFormato));
	}

}
