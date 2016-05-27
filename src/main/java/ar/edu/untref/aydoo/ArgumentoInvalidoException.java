package ar.edu.untref.aydoo;

public class ArgumentoInvalidoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8530117359768300376L;
	private String mensaje;

	public ArgumentoInvalidoException(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String getMessage(){
		return this.mensaje;
	}

}
