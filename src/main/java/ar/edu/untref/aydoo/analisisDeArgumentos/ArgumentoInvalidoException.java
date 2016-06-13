package ar.edu.untref.aydoo.analisisDeArgumentos;

import java.util.List;

public class ArgumentoInvalidoException extends ArgumentosException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8530117359768300376L;
	private String mensaje;
	private List<String> listaDeArgumentos;
	
		
	public ArgumentoInvalidoException(List<String> listaDeArgumentos, String mensaje) {
		this.mensaje = mensaje;
		this.listaDeArgumentos = listaDeArgumentos;
	}

	@Override
	public String getMessage(){
		return this.mensaje;
	}
	
	public void getInstance(){
		String stringDeArgumentos = this.listaDeArgumentos.toString().toLowerCase();
		Boolean argumentoInvalido = this.listaDeArgumentos.size() == 2 && !stringDeArgumentos.contains("--mode=default") && !stringDeArgumentos.contains("--mode=no-output") && !stringDeArgumentos.contains("--output=");
		if(argumentoInvalido){
			throw new ArgumentoInvalidoException(listaDeArgumentos, mensaje);
		}
	}

}
