package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class CreadorDeCarpetaDeSalida {
	
	private String nombreDeLaCarpetaDeSalida;
	private String direccionDeLaCarpetaDeSalida;
	
	//Se obtiene de la direccion del JAR, ubicado al lado de la carpeta de salida
	private File archivo = new File(System.getProperty("java.class.path"));
	private File direccion = archivo.getAbsoluteFile().getParentFile();	
	private String direccionDelJAR = direccion.toString();

	public CreadorDeCarpetaDeSalida(String nombreDeLaCarpetaDeSalida) throws IOException {
		this.nombreDeLaCarpetaDeSalida = nombreDeLaCarpetaDeSalida;
		this.direccionDeLaCarpetaDeSalida = direccionDelJAR + "/" + nombreDeLaCarpetaDeSalida;
	}
	
	//No se ejecuta desde del constructor porque no encuentra correctamente la direccion del JAR
	public void crearCarpetaDeSalida() throws IOException{	
		File directorioFuente = new File(this.direccionDelJAR + "/plantilla");
		File carpetaDeSalida = new File(this.direccionDeLaCarpetaDeSalida);
		FileUtils.copyDirectory(directorioFuente, carpetaDeSalida);
	}

	public String getDireccionDeLaCarpetaDeSalida() {
		return this.direccionDeLaCarpetaDeSalida;
	}
	
	public String getNombreDeLaCarpetaDeSalida(){
		return this.nombreDeLaCarpetaDeSalida;
	}
	
	public String getDireccionDelJAR(){
		return this.direccionDelJAR;
	}

}
