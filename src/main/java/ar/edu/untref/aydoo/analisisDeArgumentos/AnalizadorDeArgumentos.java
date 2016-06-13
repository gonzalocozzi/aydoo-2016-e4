package ar.edu.untref.aydoo.analisisDeArgumentos;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorDeArgumentos {

	private List<String> listaDeArgumentos;

	public AnalizadorDeArgumentos(List<String> listaDeArgumentos) {	

		this.listaDeArgumentos = new ArrayList<String>();

		for(int i=0; i < listaDeArgumentos.size(); i++) {
			this.listaDeArgumentos.add(listaDeArgumentos.get(i).toLowerCase());
		}
	}

	public Boolean contieneModoDefault() {
		return this.listaDeArgumentos.contains("--mode=default") || this.listaDeArgumentos.size() == 1;
	}

	public Boolean contieneModoNoOutput() {
		return this.listaDeArgumentos.contains("--mode=no-output");
	}

	public Boolean contieneOutput() {
		String stringDeArgumentos = this.listaDeArgumentos.toString();
		return stringDeArgumentos.contains("--output=");
	}

	public List<String> getListaDeArgumentos() {
		return this.listaDeArgumentos;
	}	

}
