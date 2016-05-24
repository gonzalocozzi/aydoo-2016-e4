package ar.edu.untref.aydoo;

import java.util.List;

public class AnalizadorDeArgumentos {

	private List<String> listaDeArgumentos;
	
	public AnalizadorDeArgumentos(List<String> listaDeArgumentos) {
		this.listaDeArgumentos = listaDeArgumentos;	
	}

	public Boolean isModeDefault() {
		return this.listaDeArgumentos.contains("--mode=default") || this.listaDeArgumentos.size() == 1;
	}

	public Boolean isModeNoOutput() {
		return this.listaDeArgumentos.contains("--mode=no-output");
	}

	public Boolean isOutput() {
		String stringDeArgumentos = this.listaDeArgumentos.toString();
		return stringDeArgumentos.contains("--output=");
	}

}
