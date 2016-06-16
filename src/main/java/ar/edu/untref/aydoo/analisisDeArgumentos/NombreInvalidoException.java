package ar.edu.untref.aydoo.analisisDeArgumentos;

public class NombreInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 892162960126581410L;
	private String mensaje = "el nombre del archivo de entrada no es valido. Por favor, intentelo nuevamente.";

	@Override
	public String getMessage(){
		return this.mensaje;
	}

}
