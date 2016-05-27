package ar.edu.untref.aydoo;

public class SinNombreDelArchivoDeEntradaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6344319782237687844L;
	private String mensaje;

	public SinNombreDelArchivoDeEntradaException(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String getMessage(){
		return this.mensaje;
	}

}
