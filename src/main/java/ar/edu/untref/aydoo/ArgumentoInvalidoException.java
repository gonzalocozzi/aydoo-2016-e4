package ar.edu.untref.aydoo;

public class ArgumentoInvalidoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8530117359768300376L;
	
	public ArgumentoInvalidoException(String string) {
		System.out.println("Usted ha ingresado al menos un argumento invalido. Por favor, intentelo nuevamente.");
	}

}
