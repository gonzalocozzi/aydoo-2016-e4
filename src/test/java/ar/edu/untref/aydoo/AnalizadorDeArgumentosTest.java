package ar.edu.untref.aydoo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AnalizadorDeArgumentosTest {
	
	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaUnArgumentoEnSuLista(){
		
		String[] args = {"mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		List<String> listaDeArgumentos = analizador.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("mipresentacion.md"));
	}
	
	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaVariosArgumentosEnSuLista1(){
		
		String[] args = {"--mode=default", "mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		List<String> listaDeArgumentos = analizador.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("mipresentacion.md"));
	}
	
	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaVariosArgumentosEnSuLista2(){
		
		String[] args = {"--mode=default", "mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		List<String> listaDeArgumentos = analizador.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("--mode=default"));
	}

}
