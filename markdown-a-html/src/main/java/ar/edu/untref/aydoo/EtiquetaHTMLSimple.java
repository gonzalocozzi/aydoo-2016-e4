package ar.edu.untref.aydoo;

public class EtiquetaHTMLSimple extends EtiquetaHTML {

	private String texto;

	public void setTexto(String texto) {
		this.texto = texto;	
	}

	public String getTexto() {
		return this.texto;
	}

	public String getHTML() {		
		String html = this.prefijo + this.texto + this.sufijo;
		return html;
	}

}