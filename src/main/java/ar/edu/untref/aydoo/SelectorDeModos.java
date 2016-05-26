package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class SelectorDeModos {
	
	private List<String> listaDeArgumentos;

	public SelectorDeModos(String[] argumentos) {
		this.listaDeArgumentos = new ArrayList<String>();
		this.setListaDeArgumentos(argumentos);
	}

	public List<String> getListaDeArgumentos() {
		return this.listaDeArgumentos;
	}
	
	private void setListaDeArgumentos(String[] argumentos){		
		//Se completa la lista de argumentos con el arreglo de argumentos
		for(int i = 0; i < argumentos.length; i++){
			this.listaDeArgumentos.add(i, argumentos[i]);
		}
	}

}
