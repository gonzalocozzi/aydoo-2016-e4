package ar.edu.untref.aydoo;

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
	
	public EtiquetaHTML crearConMd(String entradaMarkdown) {
		if(entradaMarkdown.startsWith(encabezadoMD)){
			texto = this.buscarTexto(entradaMarkdown);
			this.setTexto(texto);
			return this;
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
