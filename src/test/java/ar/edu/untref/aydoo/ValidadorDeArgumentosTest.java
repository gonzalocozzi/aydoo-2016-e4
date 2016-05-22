package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ValidadorDeArgumentosTest {
	
	@Test
	public void validadorDeArgumentosRecibeListaDeArgumentos(){
		
		List<String> args = new ArrayList<String>();
		args.add("mi.presentacion.md");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos();
		validador.setListaDeArgumentos(args);
		
		List<String> listaDeArgumentos = validador.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("mi.presentacion.md"));
	}

}
