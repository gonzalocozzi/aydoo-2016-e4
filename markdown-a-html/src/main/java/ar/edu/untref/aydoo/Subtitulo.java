package ar.edu.untref.aydoo;

public class Subtitulo {
	
	private String prefijo;
	private String sufijo;
	private String texto;
	
	public Subtitulo(){
		this.prefijo = "<h2>";	
		this.sufijo = "</h2>";
	}

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

}
