package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SelectorDeModosTest {
	
	@Test
	public void selectorGuardaArgumentosEnUnaLista(){
		
		String[] argumentos = {"argumento 1","argumento 2"};
		
		SelectorDeModos selector = new SelectorDeModos(argumentos);
		
		List<String> listaEsperada = new ArrayList<String>();
		listaEsperada.add("argumento 1");
		listaEsperada.add("argumento 2");
		
		Assert.assertEquals(listaEsperada, selector.getListaDeArgumentos());		
	}
}
