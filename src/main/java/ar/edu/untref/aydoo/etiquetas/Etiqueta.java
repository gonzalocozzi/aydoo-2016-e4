package ar.edu.untref.aydoo.etiquetas;

import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitable;

public abstract class Etiqueta implements Visitable{

	protected String prefijoHTML;
	protected String sufijoHTML;
	protected String encabezadoMD;	
	private String texto;

	public String getPrefijoHTML() {
		return this.prefijoHTML;
	}

	public String getSufijoHTML() {
		return this.sufijoHTML;
	}

	public void setTexto(String texto) {
		this.texto = texto;	
	}

	public String getTexto() {
		return this.texto;
	}

	public String getEncabezadoMD() {
		return this.encabezadoMD;
	}

	protected Etiqueta getNuevaInstancia(){
		return this;
	}

	public Etiqueta crearConMD(String entradaMarkdown) {
		Etiqueta etiqueta = this.getNuevaInstancia();
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
		encabezado = this.getEncabezadoMD();
		textoADevolver = linea.substring(encabezado.length(), linea.length());
		return textoADevolver;
	}
}
