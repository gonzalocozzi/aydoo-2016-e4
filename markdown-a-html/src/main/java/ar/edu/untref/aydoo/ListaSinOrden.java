package ar.edu.untref.aydoo;

public class ListaSinOrden {
	
	private String prefijo;
	private String sufijo;
	
	public ListaSinOrden(){
		this.prefijo = "<ul>";
		this.sufijo = "</ul>";
	}
	
	public String getPrefijo() {
		return this.prefijo;
	}

	public String getSufijo() {
		return this.sufijo;
	}

}
