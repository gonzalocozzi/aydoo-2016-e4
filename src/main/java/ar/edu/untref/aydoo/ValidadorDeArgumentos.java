package ar.edu.untref.aydoo;

import java.util.List;

public class ValidadorDeArgumentos {
	
	private List<String> listaDeArgumentos;

	public void validarListaDeArgumentos(List<String> args) {
		
		if(args.size() == 1 && args.get(0).contains("--")){			
			throw new SinNombreDelArchivoDeEntradaException();
		}
		
		this.listaDeArgumentos = args;		
	}

	public List<String> getListaDeArgumentos() {
		return this.listaDeArgumentos;
	}

}
