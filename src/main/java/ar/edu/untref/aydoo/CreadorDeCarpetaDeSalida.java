package ar.edu.untref.aydoo;

public class CreadorDeCarpetaDeSalida {
	
	private String direccionDeLaCarpetaDeSalida;
	private String nombreDeLaCarpetaDeSalida;

	public CreadorDeCarpetaDeSalida(String direccionDelJAR, String nombreDeLaNuevaCarpeta) {
		this.nombreDeLaCarpetaDeSalida = nombreDeLaNuevaCarpeta;
		this.direccionDeLaCarpetaDeSalida = direccionDelJAR + "/" + nombreDeLaNuevaCarpeta;
	}

	public String getDireccionDeLaCarpetaDeSalida() {
		return this.direccionDeLaCarpetaDeSalida;
	}
	
	public String getNombreDeLaCarpetaDeSalida(){
		return this.nombreDeLaCarpetaDeSalida;
	}

}
