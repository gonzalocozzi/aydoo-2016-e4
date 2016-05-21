package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import org.junit.Assert;

public class CreadorDeSalidaHTMLTest {

	@Test
	public void recibeUnListaVacia(){
		
		List<EtiquetaHTML> lista = new LinkedList<EtiquetaHTML>();
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
	}
	
	@Test
	public void recibeUnaListaConUnTitulo(){
		
		List<EtiquetaHTML> lista = new LinkedList<EtiquetaHTML>();
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		lista.add(titulo);
		
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("<h1>un titulo</h1>");
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
		
	}
	
	@Test
	public void recibeUnaListaConUnSubtitulo(){
		
		List<EtiquetaHTML> lista = new LinkedList<EtiquetaHTML>();
		Subtitulo subtitulo = new Subtitulo();
		subtitulo.setTexto("un subtitulo");
		lista.add(subtitulo);
		
		CreadorDeSalidaHTML creador = new CreadorDeSalidaHTML(lista);
		
		List<String> listaEsperada = new LinkedList<String>();
		listaEsperada.add("<h2>un subtitulo</h2>");
		
		Assert.assertEquals(listaEsperada, creador.getListaDeSalidaHTML());
		
	}
}
