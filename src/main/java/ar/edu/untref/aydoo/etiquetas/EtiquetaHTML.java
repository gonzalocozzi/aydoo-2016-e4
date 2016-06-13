package ar.edu.untref.aydoo.etiquetas;

import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitable;

public abstract class EtiquetaHTML implements Visitable{

	protected String prefijo;
	protected String sufijo;
	private String texto;
	protected String encabezadoMD;	

	public String getPrefijo() {
		return this.prefijo;
	}

	public String getSufijo() {
		return this.sufijo;
	}

	public void setTexto(String texto) {
		this.texto = texto;	
	}

	public String getTexto() {
		return this.texto;
	}
	
	public String getEncabezado() {
		return this.encabezadoMD;
	}
	
	protected EtiquetaHTML crearNuevaInstancia(){
		return this;
	}
	
	public EtiquetaHTML crearConMD(String entradaMarkdown) {
		EtiquetaHTML etiqueta = this.crearNuevaInstancia();
		if(entradaMarkdown.startsWith(encabezadoMD)){
			texto = this.buscarTexto(entradaMarkdown);
			etiqueta.setTexto(texto);
			return etiqueta;
		}
		return null;
	}

	private String buscarTexto(String linea) {
		String textoADevolver = linea;
		String encabezado = "";	
		encabezado = this.getEncabezado();
		textoADevolver = linea.substring(encabezado.length(), linea.length());
		return textoADevolver;
	}
}
