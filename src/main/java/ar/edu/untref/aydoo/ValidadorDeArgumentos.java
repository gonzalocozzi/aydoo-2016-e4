package ar.edu.untref.aydoo;

import java.util.List;

public class ValidadorDeArgumentos {
	
	private List<String> listaDeArgumentos;

	public void validarListaDeArgumentos(List<String> args) {
		
		if(args.size() == 1 && args.get(0).contains("--")){			
			
			throw new SinNombreDelArchivoDeEntradaException("Debe especificar el nombre del archivo de entrada.");
			
		} else if (args.size() == 2){
			
			String stringDeArgumentos = args.toString();
			
			if(!stringDeArgumentos.contains("--mode=default") && !stringDeArgumentos.contains("--mode=no-output") && !stringDeArgumentos.contains("--output=")){
				
				throw new ArgumentoInvalidoException("Ha ingresado un argumento invalido. Por favor, intente nuevamente.");
			}
		}
		
		this.listaDeArgumentos = args;		
	}

	public List<String> getListaDeArgumentos() {
		return this.listaDeArgumentos;
	}

}
