package ar.edu.untref.aydoo;

import java.io.IOException;

import ar.edu.untref.aydoo.analisisDeArgumentos.SelectorDeModo;

public class Program {

	public static void main(String[] args) throws IOException {		
		SelectorDeModo selectorDeModo = new SelectorDeModo(args);
		selectorDeModo.seleccionarModo();		
	}

}
