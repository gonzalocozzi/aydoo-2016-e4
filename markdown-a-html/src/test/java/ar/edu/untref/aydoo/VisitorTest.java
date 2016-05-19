package ar.edu.untref.aydoo;

import org.junit.Test;

import org.junit.Assert;

public class VisitorTest {
	
	@Test
	public void visitaUnTituloYPideContenido(){
		
		Visitor visitor = new Visitor();
		
		Titulo titulo = new Titulo();
		titulo.setTexto("un titulo");
		
		visitor.visitar(titulo);
		
		String resultadoEsperado = "<h1>un titulo</h1>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
		
	}

}
