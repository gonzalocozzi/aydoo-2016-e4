package ar.edu.untref.aydoo.traduccion;

import java.io.IOException;
import java.util.List;

public class ModoDeSalidaNoOutput extends ModoDeSalida {

	public ModoDeSalidaNoOutput(List<String> listaDeArgumentos, String nombreDelArchivoDeEntrada) {
		super(listaDeArgumentos, nombreDelArchivoDeEntrada);
	}

	@Override
	public void traducir() throws IOException {
		if(super.analizadorDeArgumentos.contieneModoNoOutput()){
			List<String> listaDeSalida = super.getListaHTMLDeSalida();
			System.out.println("Salida HTML generada");

			for(String salida: listaDeSalida){
				System.out.println(salida);			
			}
		}
	}

}
