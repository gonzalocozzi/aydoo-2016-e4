package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EscritorDeArchivoHTMLTest {
	
	@Test
	public void recibeListaDeLineasVacia(){
		
		List<String> listaDeLineas = new LinkedList<String>();
		
		EscritorDeArchivoHTML escritor = new EscritorDeArchivoHTML(listaDeLineas);
		
		Assert.assertEquals(listaDeLineas, escritor.getListaDeLineas());
		
	}

}
