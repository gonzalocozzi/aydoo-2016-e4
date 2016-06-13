package ar.edu.untref.aydoo.analisisDeArgumentos;

import java.util.List;

public class NumeroDeArgumentosExcedidoException extends ArgumentosException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1718834974640833326L;
	private String mensaje;
	private List<String> listaDeArgumentos;

	public NumeroDeArgumentosExcedidoException(List<String> listaDeArgumentos, String mensaje) {
		this.mensaje = mensaje;
		this.listaDeArgumentos = listaDeArgumentos;
	}

	@Override
	public String getMessage(){
		return this.mensaje;
	}
	
	@Override
	public void getNuevaInstancia(){
		if(this.listaDeArgumentos.size() > 2){
			throw new NumeroDeArgumentosExcedidoException(listaDeArgumentos, mensaje);
		}
	}

}
