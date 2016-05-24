package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CreadorDeCarpetaDeSalida {
	
	private String direccionDeLaCarpetaDeSalida;
	private String nombreDeLaCarpetaDeSalida;

	public CreadorDeCarpetaDeSalida(String direccionDelJAR, String nombreDeLaNuevaCarpeta) throws IOException {
		this.nombreDeLaCarpetaDeSalida = nombreDeLaNuevaCarpeta;
		this.direccionDeLaCarpetaDeSalida = direccionDelJAR + "/" + nombreDeLaNuevaCarpeta;
	}
	
	public void crearCarpetaDeSalida(String direccionDelJAR) throws IOException{	
		File directorioFuente = new File(direccionDelJAR + "/plantilla");
		File carpetaDeSalida = new File(this.direccionDeLaCarpetaDeSalida);
		FileUtils.copyDirectory(directorioFuente, carpetaDeSalida);
	}

	public String getDireccionDeLaCarpetaDeSalida() {
		return this.direccionDeLaCarpetaDeSalida;
	}
	
	public String getNombreDeLaCarpetaDeSalida(){
		return this.nombreDeLaCarpetaDeSalida;
	}

}
