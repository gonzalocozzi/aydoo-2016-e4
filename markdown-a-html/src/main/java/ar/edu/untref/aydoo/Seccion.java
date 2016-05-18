package ar.edu.untref.aydoo;

public class Seccion {
	
	private String prefijo;
	private String sufijo;
	
	public Seccion(){
		this.prefijo = "<section>";
		this.sufijo = "</section>";
	}

	public String getPrefijo() {
		return this.prefijo;
	}

	public String getSufijo() {
		return this.sufijo;
	}

}
