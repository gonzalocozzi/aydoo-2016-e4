package ar.edu.untref.aydoo.analisisDeArgumentos;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.aydoo.analisisDeArgumentos.ArgumentoInvalidoException;
import ar.edu.untref.aydoo.analisisDeArgumentos.NombreInvalidoException;
import ar.edu.untref.aydoo.analisisDeArgumentos.NumeroDeArgumentosExcedidoException;
import ar.edu.untref.aydoo.analisisDeArgumentos.SinNombreDelArchivoDeEntradaException;
import ar.edu.untref.aydoo.analisisDeArgumentos.ValidadorDeArgumentos;

public class ValidadorDeArgumentosTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();	
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@Test
	public void validadorDeArgumentosRecibeUnParametroYDevuelveElNombreDelArchivoDeEntrada() throws SinNombreDelArchivoDeEntradaException{

		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("mi-presentacion.md");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);

		String nombreDelArchivoDeEntrada = validador.getNombreDelArchivoDeEntrada();

		Assert.assertEquals("mi-presentacion.md", nombreDelArchivoDeEntrada);
	}

	@Test
	public void validadorDeArgumentosRecibeUnParametroYDevuelveElNombreDeLaCarpetaDeSalida() throws SinNombreDelArchivoDeEntradaException{

		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("mipresentacion.md");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);

		String nombreDeLaCarpetaDeSalida = validador.getNombreDeCarpetaDeSalida();

		Assert.assertEquals("mipresentacion", nombreDeLaCarpetaDeSalida);
	}

	@Test
	public void validadorDeArgumentosRecibeVariosParametrosYDevuelveElNombreDeLaCarpetaDeSalida() throws SinNombreDelArchivoDeEntradaException{

		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mipresentacion.md");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);

		String nombreDeLaCarpetaDeSalida = validador.getNombreDeCarpetaDeSalida();

		Assert.assertEquals("mipresentacion", nombreDeLaCarpetaDeSalida);
	}

	@Test
	public void validadorDeArgumentosRecibeVariosParametrosYDevuelveElNombreDeLaCarpetaDeSalidaSinImportarElOrden() throws SinNombreDelArchivoDeEntradaException{

		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("mipresentacion.md");
		listaDeArgumentos.add("--mode=default");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);

		String nombreDeLaCarpetaDeSalida = validador.getNombreDeCarpetaDeSalida();

		Assert.assertEquals("mipresentacion", nombreDeLaCarpetaDeSalida);
	}

	@Test
	public void validadorDeArgumentosRecibeParametroOutputYDevuelveElNombreDeLaCarpetaDeSalida() throws SinNombreDelArchivoDeEntradaException{

		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--output=nuevacarpeta");
		listaDeArgumentos.add("mipresentacion.md");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);

		String nombreDeLaCarpetaDeSalida = validador.getNombreDeCarpetaDeSalida();

		Assert.assertEquals("nuevacarpeta", nombreDeLaCarpetaDeSalida);
	}
	
	@Test
	public void validadorDeArgumentosRecibeParametroOutputYDevuelveElNombreDeLaCarpetaDeSalidaSInImportarElOrden() throws SinNombreDelArchivoDeEntradaException{

		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("mipresentacion.md");
		listaDeArgumentos.add("--output=123");
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);

		String nombreDeLaCarpetaDeSalida = validador.getNombreDeCarpetaDeSalida();

		Assert.assertEquals("123", nombreDeLaCarpetaDeSalida);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void validadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConEspacio(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mi psentacion.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos); 	
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void validadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConEnieMayuscula(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mipresentacionÑ.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos); 	
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void validadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConEnieMinuscula(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mipresentacionñ.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void validadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConBarra(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mi/presentacion.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);	
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void validadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConVocalesMayusculasAcentuadas(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("miprÉsentacion.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);	
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void validadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConVocalesMinusculasAcentuadas(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mipresentación.md");
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validador = new ValidadorDeArgumentos(listaDeArgumentos);
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
