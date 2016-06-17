package ar.edu.untref.aydoo.etiquetas;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.creacionDeEtiquetas.VisitorDeEtiquetas;
import ar.edu.untref.aydoo.etiquetas.Etiqueta;
import ar.edu.untref.aydoo.etiquetas.Titulo;

public class TituloTest {
	
	@Test
	public void tituloSeCreaConPrefijo(){
		
		Etiqueta titulo = new Titulo();
		
		String prefijo = titulo.getPrefijoHTML();
		
		Assert.assertEquals("<h1>", prefijo);
	}	
	
	@Test
	public void tituloSeCreaConSufijo(){
		
		Etiqueta titulo = new Titulo();
		
		String sufijo = titulo.getSufijoHTML();
		
		Assert.assertEquals("</h1>", sufijo);
	}
	
	@Test
	public void seIncorporaTextoAlTitulo(){
		
		Etiqueta titulo = new Titulo();		
		String contenido = "el titulo";
		titulo.setTexto(contenido);
		
		String textoDelTitulo = titulo.getTexto();
		
		Assert.assertEquals(contenido, textoDelTitulo);		
	}
	
	@Test
	public void tituloAceptaElVisitor(){
		
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		titulo.aceptarVisitor(visitor);
		
		String resultadoEsperado = "<h1>un titulo</h1>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
	
	@Test
	public void elTituloSeCreaConSuEncabezadoMD(){
		Titulo titulo = new Titulo();
		String encabezadoObtenido = titulo.getEncabezadoMarkdown();
		
		String encabezadoEsperado = "#";
				
		Assert.assertEquals(encabezadoEsperado, encabezadoObtenido);
	}
	
	@Test
	public void elTituloSabeReconocerseYCrearseAPartirDeUnaEntradaMD(){
		String entrada = "# titulo de prueba";
		Titulo titulo = new Titulo();
		
		Assert.assertEquals(Titulo.class, titulo.crearDesdeArchivoMarkdown(entrada).getClass());
	}
	
}
