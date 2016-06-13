package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.analisisDeArgumentos.AnalizadorDeArgumentos;

public class AnalizadorDeArgumentosTest {
	
	@Test
	public void analizadorDeArgumentosAlmacenaArgumentosEnMinusculas(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--MODE=NO-OUTPUT");
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
		
		List<String> listaDeArgumentosAlmacenada = analizador.getListaDeArgumentos();
		
		Assert.assertEquals(listaDeArgumentosAlmacenada.get(0), "--mode=no-output");
	}
	
	@Test
	public void analizadorDeArgumentosIndicaQueSeRecibioArgumentoModeDefault(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mipresentacion.md");
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
		
		Boolean modeDefault = analizador.isModeDefault();
		
		Assert.assertTrue(modeDefault);
	}
	
	@Test
	public void analizadorDeArgumentosIndicaQueSeRecibioArgumentoModeDefaultCuandoSoloSeIndicaElNombreDelArchivoDeEntrada(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("mipresentacion.md");
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
		
		Boolean modeDefault = analizador.isModeDefault();
		
		Assert.assertTrue(modeDefault);
	}
	
	@Test
	public void analizadorDeArgumentosIndicaQueSeRecibioArgumentoModeNoOutput(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=no-output");
		listaDeArgumentos.add("mipresentacion.md");
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
		
		Boolean modeNoOutput = analizador.isModeNoOutput();
		
		Assert.assertTrue(modeNoOutput);
	}
	
	@Test
	public void analizadorDeArgumentosIndicaQueSeRecibioArgumentoOutput(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--output=algo");
		listaDeArgumentos.add("mipresentacion.md");		
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
		
		Boolean output = analizador.isOutput();
		
		Assert.assertTrue(output);
	}

}
