package ar.edu.untref.aydoo.traduccion;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TraductorTest {
	
	@Test
	public void traductorAlmacenaArgumento(){
		
		String[] argumentos = {"argumento1"};
		Traductor traductor = new Traductor(argumentos);
		
		List<String> listaDeArgumentos = traductor.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("argumento1"));
	}

}
