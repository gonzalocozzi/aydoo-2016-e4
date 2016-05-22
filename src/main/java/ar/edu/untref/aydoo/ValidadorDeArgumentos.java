package ar.edu.untref.aydoo;

import java.util.List;

public class ValidadorDeArgumentos {
	
	private List<String> listaDeArgumentos;

	public void validarListaDeArgumentos(List<String> args) {
		
		if(args.size() == 1 && args.get(0).contains("--")){			
			
			throw new SinNombreDelArchivoDeEntradaException("Debe especificar el nombre del archivo Markdown de entrada.");
			
		} else if (args.size() > 1){
			
			if(!args.contains("--mode=default") && !args.contains("--mode=no-output")){
				
				throw new ArgumentoInvalidoException("Ha ingresado un argumento invalido. Por favor, intente nuevamente.");
			}
		}
		
		this.listaDeArgumentos = args;		
	}

	public List<String> getListaDeArgumentos() {
		return this.listaDeArgumentos;
	}

}
