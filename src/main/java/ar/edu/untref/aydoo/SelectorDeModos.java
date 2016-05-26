package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class SelectorDeModos {
	
	private List<String> listaDeArgumentos;
	private ValidadorDeArgumentos validadorDeArgumentos;
	private AnalizadorDeArgumentos analizadorDeArgumentos;

	public SelectorDeModos(String[] argumentos) {
		this.listaDeArgumentos = new ArrayList<String>();
		this.setListaDeArgumentos(argumentos);
		this.validarArgumentos();
		this.analizarArgumentos();
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

	public String getNombreDelArchivo() {		
		return validadorDeArgumentos.getNombreDelArchivoDeEntrada();
	}
	
	private ValidadorDeArgumentos validarArgumentos(){
		this.validadorDeArgumentos = new ValidadorDeArgumentos(listaDeArgumentos);
		return validadorDeArgumentos;
	}
	
	private AnalizadorDeArgumentos analizarArgumentos(){
		this.analizadorDeArgumentos = new AnalizadorDeArgumentos(listaDeArgumentos);
		return analizadorDeArgumentos;
	}
}
