package ar.edu.untref.aydoo.excepciones;

public class NombreInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 892162960126581410L;
	private String mensaje;

	public NombreInvalidoException(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String getMessage(){
		return this.mensaje;
	}

}
