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
		validador.validarListaDeArgumentos(args);
		
		List<String> listaDeArgumentos = validador.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("mi.presentacion.md"));
	}
	
	@Test(expected=SinNombreDelArchivoDeEntradaException.class)
	public void validadorDeArgumentosExigeNombreDelArchivoDeEntrada(){
		
		List<String> args = new ArrayList<String>();
		args.add("--mode=default");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos();
		validador.validarListaDeArgumentos(args);
	}
	
	@Test(expected=ArgumentoInvalidoException.class)
	public void validadorDeArgumentosImpideElIngresoDeUnArgumentoModeInvalido(){
		
		List<String> args = new ArrayList<String>();
		args.add("--mode=algo");
		args.add("mi.presentacion.md");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos();
		validador.validarListaDeArgumentos(args);
	}

}
