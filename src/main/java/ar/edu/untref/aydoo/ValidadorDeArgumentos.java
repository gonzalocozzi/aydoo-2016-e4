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

			throw new SinNombreDelArchivoDeEntradaException();

		} else if (listaDeArgumentos.size() == 2 && !stringDeArgumentos.contains("--mode=default") && !stringDeArgumentos.contains("--mode=no-output") && !stringDeArgumentos.contains("--output=")) {

			throw new ArgumentoInvalidoException();

		} else if (listaDeArgumentos.size() == 2 && listaDeArgumentos.get(0).contains("--") && listaDeArgumentos.get(1).contains("--")) {

			throw new SinNombreDelArchivoDeEntradaException();

		} else if (listaDeArgumentos.size() > 2) {

			throw new NumeroDeArgumentosExcedidoException();

		} else {

			this.argumentoEsValido = true;
		}

	}

	public boolean argumentoEsValido() {
		return this.argumentoEsValido;
	}	

}
