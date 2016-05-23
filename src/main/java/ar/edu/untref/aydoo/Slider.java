package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Slider {
	
	public static void main(String[] args) {
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		
		for(int i = 0; i < args.length; i++){
			//Me aseguro de poder recibir argumentos con cualquier capitalizacion
			listaDeArgumentos.add(i, args[i].toLowerCase());
		}
		
		ValidadorDeArgumentos validadorDeArgumentos = new ValidadorDeArgumentos();
		validadorDeArgumentos.validarListaDeArgumentos(listaDeArgumentos);		
	}

}
