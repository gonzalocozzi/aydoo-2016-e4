package ar.edu.untref.aydoo;

public class SinNombreDelArchivoDeEntradaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6344319782237687844L;
	
	public SinNombreDelArchivoDeEntradaException(String string) {
		System.out.println("Por favor, indique el nombre del archivo Markdown de entrada.");
	}

}
