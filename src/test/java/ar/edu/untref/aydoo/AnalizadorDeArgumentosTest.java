package ar.edu.untref.aydoo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AnalizadorDeArgumentosTest {
	
	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaUnArgumentoEnSuLista() throws SinNombreDelArchivoDeEntradaException{
		
		String[] args = {"mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		List<String> listaDeArgumentos = analizador.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("mipresentacion.md"));
	}
	
	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaVariosArgumentosEnSuLista1() throws SinNombreDelArchivoDeEntradaException{
		
		String[] args = {"--mode=default", "mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		List<String> listaDeArgumentos = analizador.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("mipresentacion.md"));
	}
	
	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaVariosArgumentosEnSuLista2() throws SinNombreDelArchivoDeEntradaException{
		
		String[] args = {"--mode=default", "mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		List<String> listaDeArgumentos = analizador.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("--mode=default"));
	}
	
	@Test
	public void analizadorDeArgumentosRecibeUnParametroYDevuelveElNombreDeLaCarpetaDeSalida() throws SinNombreDelArchivoDeEntradaException{
		
		String[] args = {"mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		String nombreDeLaCarpetaDeSalida = analizador.getNombreDeCarpetaDeSalida();
		
		Assert.assertEquals("mipresentacion", nombreDeLaCarpetaDeSalida);
	}
	
	@Test
	public void analizadorDeArgumentosRecibeVariosParametrosYDevuelveElNombreDeLaCarpetaDeSalida() throws SinNombreDelArchivoDeEntradaException{
		
		String[] args = {"--mode=default", "mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		String nombreDeLaCarpetaDeSalida = analizador.getNombreDeCarpetaDeSalida();
		
		Assert.assertEquals("mipresentacion", nombreDeLaCarpetaDeSalida);
	}
	
	@Test
	public void analizadorDeArgumentosRecibeVariosParametrosYDevuelveElNombreDeLaCarpetaDeSalidaSinImportarElOrden() throws SinNombreDelArchivoDeEntradaException{
		
		String[] args = {"--mode=default", "otra.presentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		String nombreDeLaCarpetaDeSalida = analizador.getNombreDeCarpetaDeSalida();
		
		Assert.assertEquals("otra.presentacion", nombreDeLaCarpetaDeSalida);
	}
	
	@Test
	public void analizadorDeArgumentosRecibeParametroOutputYDevuelveElNombreDeLaCarpetaDeSalida() throws SinNombreDelArchivoDeEntradaException{
		
		String[] args = {"--output=nuevacarpeta", "mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		String nombreDeLaCarpetaDeSalida = analizador.getNombreDeCarpetaDeSalida();
		
		Assert.assertEquals("nuevacarpeta", nombreDeLaCarpetaDeSalida);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConEspacio(){
		
		String[] args = {"--mode=default", "mi presentacion.md"};
		@SuppressWarnings("unused")
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConEnieMayuscula(){
		
		String[] args = {"--mode=default", "mipresentacionÑ.md"};
		@SuppressWarnings("unused")
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConEnieMinuscula(){
		
		String[] args = {"--mode=default", "mipresentacionñ.md"};
		@SuppressWarnings("unused")
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConBarra(){
		
		String[] args = {"--mode=default", "mi/presentacion.md"};
		@SuppressWarnings("unused")
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConVocalesMayusculasAcentuadas(){
		
		String[] args = {"--mode=default", "mipresentacionÉ.md"};
		@SuppressWarnings("unused")
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
	}
	
	@Test(expected=NombreInvalidoException.class)
	public void analizadorDeArgumentosNoAceptaNombreDeArchivoDeEntradaConVocalesMinusculasAcentuadas(){
		
		String[] args = {"--mode=default", "mipresentación.md"};
		@SuppressWarnings("unused")
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
	}
	
	@Test
	public void analizadorDeArgumentosIndicaQueSeRecibioArgumentoModeDefault(){
		
		String[] args = {"--mode=default", "otra.presentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		Boolean modeDefault = analizador.isModeDefault();
		
		Assert.assertTrue(modeDefault);
	}
	
	@Test
	public void analizadorDeArgumentosIndicaQueSeRecibioArgumentoModeNoOutput(){
		
		String[] args = {"--mode=no-output", "otra.presentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		Boolean modeNoOutput = analizador.isModeNoOutput();
		
		Assert.assertTrue(modeNoOutput);
	}
	
	@Test
	public void analizadorDeArgumentosIndicaQueSeRecibioArgumentoOutput(){
		
		String[] args = {"--output=algo", "otra.presentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		Boolean output = analizador.isOutput();
		
		Assert.assertTrue(output);
	}

}
