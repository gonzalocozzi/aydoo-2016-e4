package ar.edu.untref.aydoo.analisisDeArgumentos;

import java.util.List;

public class NumeroDeArgumentosExcedidoException extends ArgumentosException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1718834974640833326L;
	private String mensaje = "no debe ingresar mas de 2 argumentos. Por favor, intentelo nuevamente.";
	private List<String> listaDeArgumentos;

	public NumeroDeArgumentosExcedidoException(List<String> listaDeArgumentos) {
		this.listaDeArgumentos = listaDeArgumentos;
	}

	@Override
	public String getMessage(){
		return this.mensaje;
	}

	@Override
	public void getNuevaInstancia(){
		if(this.listaDeArgumentos.size() > 2){
			throw new NumeroDeArgumentosExcedidoException(listaDeArgumentos);
		}
	}

}
