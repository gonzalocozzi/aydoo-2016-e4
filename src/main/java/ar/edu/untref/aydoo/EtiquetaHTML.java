package ar.edu.untref.aydoo;

public abstract class EtiquetaHTML implements Visitable{

	protected String prefijo;
	protected String sufijo;
	private String texto;

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
