package ar.edu.untref.aydoo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AnalizadorDeArgumentosTest {
	
	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaUnArgumentoEnSuLista() throws NoInputFileNameException{
		
		String[] args = {"mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		List<String> listaDeArgumentos = analizador.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("mipresentacion.md"));
	}
	
	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaVariosArgumentosEnSuLista1() throws NoInputFileNameException{
		
		String[] args = {"--mode=default", "mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		List<String> listaDeArgumentos = analizador.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("mipresentacion.md"));
	}
	
	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaVariosArgumentosEnSuLista2() throws NoInputFileNameException{
		
		String[] args = {"--mode=default", "mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		List<String> listaDeArgumentos = analizador.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("--mode=default"));
	}
	
	@Test
	public void analizadorDeArgumentosRecibeUnParametroYDevuelveElNombreDeLaCarpetaDeSalida() throws NoInputFileNameException{
		
		String[] args = {"mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		String nombreDeLaCarpetaDeSalida = analizador.getNombreDeCarpetaDeSalida();
		
		Assert.assertEquals("mipresentacion", nombreDeLaCarpetaDeSalida);
	}
	
	@Test
	public void analizadorDeArgumentosRecibeVariosParametrosYDevuelveElNombreDeLaCarpetaDeSalida() throws NoInputFileNameException{
		
		String[] args = {"--mode=default", "mipresentacion.md"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
		
		String nombreDeLaCarpetaDeSalida = analizador.getNombreDeCarpetaDeSalida();
		
		Assert.assertEquals("mipresentacion", nombreDeLaCarpetaDeSalida);
	}
	
	@Test(expected=NoInputFileNameException.class)
	public void analizadorDeArgumentosRecibeUnParametroDeFormatoSinNombreDeArchivoYExigeNombreDeArchivo() throws NoInputFileNameException{
		
		String[] args = {"--mode=default"};
		@SuppressWarnings("unused")
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args);
	}

}
