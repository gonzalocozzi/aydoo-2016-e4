package ar.edu.untref.aydoo.analisisDeArgumentos;

import java.util.List;

public class SinNombreDelArchivoDeEntradaException extends ArgumentosException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6344319782237687844L;
	private String mensaje = "por favor, indique el nombre del archivo markdown de entrada.";
	private List<String> listaDeArgumentos;	

	public SinNombreDelArchivoDeEntradaException(List<String> listaDeArgumentos) {
		this.listaDeArgumentos = listaDeArgumentos;
	}

	@Override
	public String getMessage(){
		return this.mensaje;
	}

	@Override
	public void getNuevaInstancia(){		
		Boolean sinNombreDelArchivoDeEntrada = this.listaDeArgumentos.size() == 0 
				|| this.listaDeArgumentos.size() == 1 
				&& this.listaDeArgumentos.get(0).contains("--");

		Boolean soloArgumentosDeConfiguracion = this.listaDeArgumentos.size() == 2 
				&& this.listaDeArgumentos.get(0).contains("--") 
				&& this.listaDeArgumentos.get(1).contains("--");

		if(sinNombreDelArchivoDeEntrada || soloArgumentosDeConfiguracion){
			throw new SinNombreDelArchivoDeEntradaException(listaDeArgumentos);
		}
	}

}
