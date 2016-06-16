package ar.edu.untref.aydoo.traduccion;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TraductorTest {
	
	@Test
	public void traductorAlmacenaArgumento(){
		
		String[] argumentos = {"argumento1"};
		Traductor traductor = new Traductor(argumentos);
		
		List<String> listaDeArgumentos = traductor.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("argumento1"));
	}
	
	@Test
	public void traductorAlmacenaModoDeSalida(){
		
		String[] argumentos = {"argumento1"};
		Traductor traductor = new Traductor(argumentos);
		
		ModoDeSalidaNoOutput nuevoModoDeSalida = new ModoDeSalidaNoOutput(traductor.getListaDeArgumentos(), "nombre del archivo de entrada");		
		traductor.agregarModoDeSalida(nuevoModoDeSalida);
		
		List<ModoDeSalida> listaDeModosDeSalida = traductor.getModosDeSalidaDisponibles();
		
		Assert.assertTrue(listaDeModosDeSalida.contains(nuevoModoDeSalida));
	}

}
