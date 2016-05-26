package ar.edu.untref.aydoo;

import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException {	
	
		SelectorDeModos selector = new SelectorDeModos(args);		
		selector.setArchivoDeEntrada(selector.getNombreDelArchivo());
		selector.setArchivoParaEscribirHtml(selector.getNombreDeLaCarpetaDeSalida()+"/index.html");
		selector.seleccionarModo();
	}
}
