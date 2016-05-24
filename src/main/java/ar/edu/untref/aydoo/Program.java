package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Program {
	
	public static void main(String[] args) {	
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		
		//Se completa la lista de argumentos con el arreglo de argumentos
		for(int i = 0; i < args.length; i++){
			listaDeArgumentos.add(i, args[i].toLowerCase());
		}
		
		@SuppressWarnings("unused")
		ValidadorDeArgumentos validadorDeArgumentos = new ValidadorDeArgumentos(listaDeArgumentos);
				
	}

}
