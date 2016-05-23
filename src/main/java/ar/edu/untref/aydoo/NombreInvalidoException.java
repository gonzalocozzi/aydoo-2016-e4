package ar.edu.untref.aydoo;

public class NombreInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 892162960126581410L;

	public NombreInvalidoException(){
		System.out.println("Usted ha ingresado un nombre de archivo Markdown invalido. Por favor, intentelo nuevamente.");	
	}

}
