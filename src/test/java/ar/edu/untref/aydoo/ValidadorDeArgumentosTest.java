package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ValidadorDeArgumentosTest {
	
	@Test
	public void validadorDeArgumentosIndicaQueArgumentoEsValido(){
		
		List<String> args = new ArrayList<String>();
		args.add("mi.presentacion.md");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos();
		validador.validarListaDeArgumentos(args);
		
		Assert.assertTrue(validador.argumentoEsValido());
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
	
	@Test(expected=ArgumentoInvalidoException.class)
	public void validadorDeArgumentosImpideElIngresoDeUnArgumentoInvalido(){
		
		List<String> args = new ArrayList<String>();
		args.add("argumento-invalido");
		args.add("mi.presentacion.md");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos();
		validador.validarListaDeArgumentos(args);
	}
	
	@Test(expected=NumeroDeArgumentosExcedidoException.class)
	public void validadorDeArgumentosImpideElIngresoDeMasDeDosArgumentos(){
		
		List<String> args = new ArrayList<String>();
		args.add("--output=salida");
		args.add("--mode=no-output");
		args.add("mi.presentacion.md");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos();
		validador.validarListaDeArgumentos(args);
	}
	
	@Test(expected=SinNombreDelArchivoDeEntradaException.class)
	public void validadorDeArgumentosExigeNombreDelArchivoDeEntradaCuandoRecibeDosArgumentos(){
		
		List<String> args = new ArrayList<String>();
		args.add("--output=salida");
		args.add("--mode=no-output");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos();
		validador.validarListaDeArgumentos(args);
	}
	
	@Test(expected=SinNombreDelArchivoDeEntradaException.class)
	public void validadorDeArgumentosExigeIngresarElNombreDelArchivoDeEntradaCuandoNoRecibeArgumentos(){
		
		List<String> args = new ArrayList<String>();
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos();
		validador.validarListaDeArgumentos(args);
	}

}
