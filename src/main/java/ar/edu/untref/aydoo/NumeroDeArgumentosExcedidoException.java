package ar.edu.untref.aydoo;

public class NumeroDeArgumentosExcedidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1718834974640833326L;
	
	public NumeroDeArgumentosExcedidoException(String string) {
		System.out.println("No debe ingresar mas de 2 argumentos. Por favor, intentelo nuevamente.");
	}

}
