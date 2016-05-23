package ar.edu.untref.aydoo;

import java.util.List;

public class ValidadorDeArgumentos {

	private boolean argumentoEsValido;

	public ValidadorDeArgumentos(){		
		this.argumentoEsValido = false;
	}

	public void validarListaDeArgumentos(List<String> listaDeArgumentos) {				

		String stringDeArgumentos = listaDeArgumentos.toString();
		
		if (listaDeArgumentos.size() == 0 || listaDeArgumentos.size() == 1 && listaDeArgumentos.get(0).contains("--")) {			

			throw new SinNombreDelArchivoDeEntradaException("Debe especificar el nombre del archivo de entrada.");

		} else if (listaDeArgumentos.size() == 2 && !stringDeArgumentos.contains("--mode=default") && !stringDeArgumentos.contains("--mode=no-output") && !stringDeArgumentos.contains("--output=")) {

			throw new ArgumentoInvalidoException("Ha ingresado un argumento invalido. Por favor, intentelo nuevamente.");

		} else if (listaDeArgumentos.size() == 2 && listaDeArgumentos.get(0).contains("--") && listaDeArgumentos.get(1).contains("--")) {

			throw new SinNombreDelArchivoDeEntradaException("Debe especificar el nombre del archivo de entrada.");

		} else if (listaDeArgumentos.size() > 2) {

			throw new NumeroDeArgumentosExcedidoException("Puede ingresar hasta 2 argumentos, de los cuales uno debe ser el nombre del archivo de entrada.");

		} else {

			this.argumentoEsValido = true;
		}

	}

	public boolean argumentoEsValido() {
		return this.argumentoEsValido;
	}	

}
