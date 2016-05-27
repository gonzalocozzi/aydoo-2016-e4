package ar.edu.untref.aydoo;

public class NumeroDeArgumentosExcedidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1718834974640833326L;
	private String mensaje;

	public NumeroDeArgumentosExcedidoException(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String getMessage(){
		return this.mensaje;
	}

}
