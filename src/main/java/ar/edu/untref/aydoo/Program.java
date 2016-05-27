package ar.edu.untref.aydoo;

import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException {		
		SelectorDeModo selectorDeModo = new SelectorDeModo(args);
		selectorDeModo.seleccionarModo();
	}
}
