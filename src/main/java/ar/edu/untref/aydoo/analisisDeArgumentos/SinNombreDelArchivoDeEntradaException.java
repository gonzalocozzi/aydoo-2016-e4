package ar.edu.untref.aydoo.analisisDeArgumentos;

import java.util.List;

public class SinNombreDelArchivoDeEntradaException extends ArgumentosException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6344319782237687844L;
	private String mensaje;
	private List<String> listaDeArgumentos;	
	
	public SinNombreDelArchivoDeEntradaException(List<String> listaDeArgumentos, String mensaje) {
		this.mensaje = mensaje;
		this.listaDeArgumentos = listaDeArgumentos;
	}

	@Override
	public String getMessage(){
		return this.mensaje;
	}
	
	public void getInstance(){		
		Boolean sinNombreDelArchivoDeEntrada = this.listaDeArgumentos.size() == 0 || this.listaDeArgumentos.size() == 1 && this.listaDeArgumentos.get(0).contains("--");
		Boolean soloArgumentosDeConfiguracion = this.listaDeArgumentos.size() == 2 && this.listaDeArgumentos.get(0).contains("--") && this.listaDeArgumentos.get(1).contains("--");
		if(sinNombreDelArchivoDeEntrada || soloArgumentosDeConfiguracion){
			throw new SinNombreDelArchivoDeEntradaException(listaDeArgumentos, mensaje);
		}
	}

}
