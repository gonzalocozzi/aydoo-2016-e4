package ar.edu.untref.aydoo;

import java.util.List;

public class ValidadorDeArgumentos {

	private boolean argumentoEsValido;

	public ValidadorDeArgumentos(){		
		this.argumentoEsValido = false;
	}

	public void validarListaDeArgumentos(List<String> listaDeArgumentos) {
		
		String stringDeArgumentos = listaDeArgumentos.toString();
		Boolean sinNombreDelArchivoDeEntrada = listaDeArgumentos.size() == 0 || listaDeArgumentos.size() == 1 && listaDeArgumentos.get(0).contains("--");
		Boolean argumentoInvalido = listaDeArgumentos.size() == 2 && !stringDeArgumentos.contains("--mode=default") && !stringDeArgumentos.contains("--mode=no-output") && !stringDeArgumentos.contains("--output=");
		Boolean soloArgumentosDeConfiguracion = listaDeArgumentos.size() == 2 && listaDeArgumentos.get(0).contains("--") && listaDeArgumentos.get(1).contains("--");
	
		
		if (sinNombreDelArchivoDeEntrada) {			

			throw new SinNombreDelArchivoDeEntradaException();

		} else if (argumentoInvalido) {

			throw new ArgumentoInvalidoException();

		} else if (soloArgumentosDeConfiguracion) {

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
