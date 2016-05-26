package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SelectorDeModosTest {
	
	@Test
	public void selectorGuardaArgumentosEnUnaLista(){
		
		String[] argumentos = {"mipresentacion1.md"};
		
		SelectorDeModos selector = new SelectorDeModos(argumentos);
		
		List<String> listaEsperada = new ArrayList<String>();
		listaEsperada.add("mipresentacion1.md");
		
		Assert.assertEquals(listaEsperada, selector.getListaDeArgumentos());		
	}
	
	@Test
	public void selectorCreaNombreDelArchivoDeEntradaConUnValidador(){
		
		String[] argumentos = {"mipresentacion1.md"};
		
		SelectorDeModos selector = new SelectorDeModos(argumentos);
		
		String nombreDeArchivoResultante = selector.getNombreDelArchivo();
		
		String nombreEsperado = "mipresentacion1.md";
		
		Assert.assertEquals(nombreEsperado, nombreDeArchivoResultante);
	}
}
