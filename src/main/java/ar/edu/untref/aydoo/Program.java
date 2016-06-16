package ar.edu.untref.aydoo;

import java.io.IOException;

import ar.edu.untref.aydoo.traduccion.Traductor;

public class Program {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {			
		Traductor traductor = new Traductor(args);
		traductor.traducir();
	}

}
