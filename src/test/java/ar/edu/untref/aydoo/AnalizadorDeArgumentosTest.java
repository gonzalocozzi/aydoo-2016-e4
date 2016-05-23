package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AnalizadorDeArgumentosTest {
	
	@Test
	public void analizadorDeArgumentosRecibeUnParametroYDevuelveElNombreDeLaCarpetaDeSalida() throws SinNombreDelArchivoDeEntradaException{
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("mipresentacion.md");
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
		
		String nombreDeLaCarpetaDeSalida = analizador.getNombreDeCarpetaDeSalida();
		
		Assert.assertEquals("mipresentacion", nombreDeLaCarpetaDeSalida);
	}
	
	@Test
	public void analizadorDeArgumentosRecibeVariosParametrosYDevuelveElNombreDeLaCarpetaDeSalida() throws SinNombreDelArchivoDeEntradaException{
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mipresentacion.md");
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
		
		String nombreDeLaCarpetaDeSalida = analizador.getNombreDeCarpetaDeSalida();
		
		Assert.assertEquals("mipresentacion", nombreDeLaCarpetaDeSalida);
	}
	
	@Test
	public void analizadorDeArgumentosRecibeVariosParametrosYDevuelveElNombreDeLaCarpetaDeSalidaSinImportarElOrden() throws SinNombreDelArchivoDeEntradaException{
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("mipresentacion.md");
		listaDeArgumentos.add("--mode=default");
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
		
		String nombreDeLaCarpetaDeSalida = analizador.getNombreDeCarpetaDeSalida();
		
		Assert.assertEquals("mipresentacion", nombreDeLaCarpetaDeSalida);
	}
	
	@Test
	public void analizadorDeArgumentosRecibeParametroOutputYDevuelveElNombreDeLaCarpetaDeSalida() throws SinNombreDelArchivoDeEntradaException{
		
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--output=nuevacarpeta");
		listaDeArgumentos.add("mipresentacion.md");
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
		
		String nombreDeLaCarpetaDeSalida = analizador.getNombreDeCarpetaDeSalida();
		
		Assert.assertEquals("nuevacarpeta", nombreDeLaCarpetaDeSalida);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConEspacio(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mi psentacion.md");
		
		@SuppressWarnings("unused")
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConEnieMayuscula(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mipresentacionÑ.md");
		
		@SuppressWarnings("unused")
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConEnieMinuscula(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mipresentacionñ.md");
		
		@SuppressWarnings("unused")
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConBarra(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mi/presentacion.md");
		
		@SuppressWarnings("unused")
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConVocalesMayusculasAcentuadas(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("miprÉsentacion.md");
		
		@SuppressWarnings("unused")
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConVocalesMinusculasAcentuadas(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("--mode=default");
		listaDeArgumentos.add("mipresentación.md");
		
		@SuppressWarnings("unused")
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(listaDeArgumentos);
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
