package ar.edu.untref.aydoo;

public class CreadorDeCarpetaDeSalida {
	
	private String direccionDeLaCarpetaDeSalida;

	public CreadorDeCarpetaDeSalida(String direccionDelJAR) {
		this.direccionDeLaCarpetaDeSalida = direccionDelJAR;
	}

	public String getDireccionDeLaCarpetaDeSalida() {
		return this.direccionDeLaCarpetaDeSalida;
	}

}
