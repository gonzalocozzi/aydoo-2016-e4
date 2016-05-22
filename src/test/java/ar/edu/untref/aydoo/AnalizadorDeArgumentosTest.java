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
		
		String[] args = {"--output=presentacion1", "otra.presentacion.md", "--mode=default"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		String nombreDeLaCarpetaDeSalida = analizador.getNombreDeCarpetaDeSalida();
		
		Assert.assertEquals("otra.presentacion", nombreDeLaCarpetaDeSalida);
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

}
