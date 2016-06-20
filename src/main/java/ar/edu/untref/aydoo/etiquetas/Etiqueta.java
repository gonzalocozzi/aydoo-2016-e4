package ar.edu.untref.aydoo.etiquetas;

import ar.edu.untref.aydoo.creacionDeEtiquetas.Visitable;

public abstract class Etiqueta implements Visitable{

	protected String prefijoHTML;
	protected String sufijoHTML;
	protected String encabezadoMarkdown;	
	private String texto;

	/*
	 * Este metodo no nos termina de convencer, pero es la mejor forma que se nos ocurrio para no repetir codigo 
	 * del metodo crearDesdeArchivoMarkDown(String entradaMarkdown) en las clases hijas, es decir, en los distintos 
	 * tipo de Etiquetas (Titulo, Subtitulo, ItemDeLista, etc)
	 */
	protected Etiqueta getNuevaInstancia(){
		return this;
	}

	public String getPrefijoHTML() {
		return this.prefijoHTML;
	}

	public String getSufijoHTML() {
		return this.sufijoHTML;
	}
	
	public String getEncabezadoMarkdown() {
		return this.encabezadoMarkdown;
	}
	
	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;	
	}

	public Etiqueta crearDesdeArchivoMarkdown(String entradaMarkdown) {
		Etiqueta etiqueta = this.getNuevaInstancia();

		if(entradaMarkdown.startsWith(encabezadoMarkdown)){
			texto = this.buscarTexto(entradaMarkdown);
			etiqueta.setTexto(texto);

			return etiqueta;
		}

		return null;
	}

	private String buscarTexto(String linea) {
		String textoADevolver = linea;
		String encabezado = "";	
		encabezado = this.getEncabezadoMarkdown();
		textoADevolver = linea.substring(encabezado.length(), linea.length());

		return textoADevolver;
	}
}
