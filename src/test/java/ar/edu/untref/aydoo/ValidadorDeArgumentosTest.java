package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ValidadorDeArgumentosTest {

	@Test
	public void analizadorDeArgumentosRecibeUnParametroYDevuelveElNombreDeLaCarpetaDeSalida() throws SinNombreDelArchivoDeEntradaException{

		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("mipresentacion.md");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);

		String nombreDeLaCarpetaDeSalida = validador.getNombreDeCarpetaDeSalida();

		Assert.assertEquals("mipresentacion", nombreDeLaCarpetaDeSalida);
	}

	@Test
	public void analizadorDeArgumentosRecibeVariosParametrosYDevuelveElNombreDeLaCarpetaDeSalida() throws SinNombreDelArchivoDeEntradaException{

		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mipresentacion.md");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);

		String nombreDeLaCarpetaDeSalida = validador.getNombreDeCarpetaDeSalida();

		Assert.assertEquals("mipresentacion", nombreDeLaCarpetaDeSalida);
	}

	@Test
	public void analizadorDeArgumentosRecibeVariosParametrosYDevuelveElNombreDeLaCarpetaDeSalidaSinImportarElOrden() throws SinNombreDelArchivoDeEntradaException{

		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("mipresentacion.md");
		listaDeArgumentos.add("--mode=default");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);

		String nombreDeLaCarpetaDeSalida = validador.getNombreDeCarpetaDeSalida();

		Assert.assertEquals("mipresentacion", nombreDeLaCarpetaDeSalida);
	}

	@Test
	public void analizadorDeArgumentosRecibeParametroOutputYDevuelveElNombreDeLaCarpetaDeSalida() throws SinNombreDelArchivoDeEntradaException{


		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--output=nuevacarpeta");
		listaDeArgumentos.add("mipresentacion.md");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);

		String nombreDeLaCarpetaDeSalida = validador.getNombreDeCarpetaDeSalida();

		Assert.assertEquals("nuevacarpeta", nombreDeLaCarpetaDeSalida);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConEspacio(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mi psentacion.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConEnieMayuscula(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mipresentacionÑ.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConEnieMinuscula(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mipresentacionñ.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConBarra(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mi/presentacion.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConVocalesMayusculasAcentuadas(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("miprÉsentacion.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConVocalesMinusculasAcentuadas(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mipresentación.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);
	}

	@Test
	public void validadorDeArgumentosIndicaQueArgumentoEsValido(){

		List<String> args = new ArrayList<String>();
		args.add("mi.presentacion.md");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(args);

		Assert.assertTrue(validador.argumentosSonValidos());
	}

	@Test(expected=SinNombreDelArchivoDeEntradaException.class)
	public void validadorDeArgumentosExigeNombreDelArchivoDeEntrada(){

		List<String> args = new ArrayList<String>();
		args.add("--mode=default");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(args);
	}

	@Test(expected=ArgumentoInvalidoException.class)
	public void validadorDeArgumentosImpideElIngresoDeUnArgumentoModeInvalido(){

		List<String> args = new ArrayList<String>();
		args.add("--mode=algo");
		args.add("mi.presentacion.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(args);
	}

	@Test(expected=ArgumentoInvalidoException.class)
	public void validadorDeArgumentosImpideElIngresoDeUnArgumentoInvalido(){

		List<String> args = new ArrayList<String>();
		args.add("argumento-invalido");
		args.add("mi.presentacion.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(args);
	}

	@Test(expected=NumeroDeArgumentosExcedidoException.class)
	public void validadorDeArgumentosImpideElIngresoDeMasDeDosArgumentos(){

		List<String> args = new ArrayList<String>();
		args.add("--output=salida");
		args.add("--mode=no-output");
		args.add("mi.presentacion.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(args);
	}

	@Test(expected=SinNombreDelArchivoDeEntradaException.class)
	public void validadorDeArgumentosExigeNombreDelArchivoDeEntradaCuandoRecibeDosArgumentos(){

		List<String> args = new ArrayList<String>();
		args.add("--output=salida");
		args.add("--mode=no-output");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(args);
	}

	@Test(expected=SinNombreDelArchivoDeEntradaException.class)
	public void validadorDeArgumentosExigeIngresarElNombreDelArchivoDeEntradaCuandoNoRecibeArgumentos(){

		List<String> args = new ArrayList<String>();
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(args);
	}

}
