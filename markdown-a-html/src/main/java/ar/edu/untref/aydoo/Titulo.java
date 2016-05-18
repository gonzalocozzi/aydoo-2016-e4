package ar.edu.untref.aydoo;

public class Titulo {
	
	private String prefijo;
	private String sufijo;
	private String texto;
	
	public Titulo(){		
		this.prefijo = "<h1>";
		this.sufijo = "</h1>";
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
