package ar.edu.untref.aydoo;

public abstract class EtiquetaHTML {
	
	protected String prefijo;
	protected String sufijo;
	
	public String getPrefijo() {
		return this.prefijo;
	}

	public String getSufijo() {
		return this.sufijo;
	}
	
	public abstract String getHTML();

}
