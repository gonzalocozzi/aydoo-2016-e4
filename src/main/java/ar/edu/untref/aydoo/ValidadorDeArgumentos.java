package ar.edu.untref.aydoo;

import java.util.List;

public class ValidadorDeArgumentos {
	
	private boolean argumentoEsValido;
	
	public ValidadorDeArgumentos(){		
		this.argumentoEsValido = false;
	}

	public void validarListaDeArgumentos(List<String> args) {
		
		if (args.size() == 0 || args.size() == 1 && args.get(0).contains("--")) {			
			
			throw new SinNombreDelArchivoDeEntradaException("Debe especificar el nombre del archivo de entrada.");
			
		} else if (args.size() == 2) {
			
			String stringDeArgumentos = args.toString();
			
			if(!stringDeArgumentos.contains("--mode=default") && !stringDeArgumentos.contains("--mode=no-output") && !stringDeArgumentos.contains("--output=")){
				
				throw new ArgumentoInvalidoException("Ha ingresado un argumento invalido. Por favor, intentelo nuevamente.");
			}
			
			if(args.get(0).contains("--") && args.get(1).contains("--")) {
				
				throw new SinNombreDelArchivoDeEntradaException("Debe especificar el nombre del archivo de entrada.");
			}
			
		} else if (args.size() > 2) {
			
			throw new NumeroDeArgumentosExcedidoException("Puede ingresar hasta 2 argumentos, de los cuales uno debe ser el nombre del archivo de entrada.");
			
		} else {
			
			this.argumentoEsValido = true;
		}
		
	}

	public boolean argumentoEsValido() {
		return this.argumentoEsValido;
	}	

}
