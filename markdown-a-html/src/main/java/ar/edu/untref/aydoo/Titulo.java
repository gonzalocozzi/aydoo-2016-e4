package ar.edu.untref.aydoo;

public class Titulo {
	
	private String prefijo;
	private String sufijo;
	
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

}
