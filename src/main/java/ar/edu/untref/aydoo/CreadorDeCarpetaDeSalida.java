package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CreadorDeCarpetaDeSalida {
	
	private String nombreDeLaCarpetaDeSalida;
	
	//Se obtiene de la direccion del JAR, ubicado al lado de la carpeta de salida
	private File archivo = new File(System.getProperty("java.class.path"));
	private File direccion = archivo.getAbsoluteFile().getParentFile();	
	private String direccionDeLaCarpetaDeSalida = direccion.toString();

	public CreadorDeCarpetaDeSalida(String nombreDeLaNuevaCarpeta) throws IOException {
		this.nombreDeLaCarpetaDeSalida = nombreDeLaNuevaCarpeta;
		this.direccionDeLaCarpetaDeSalida = direccionDeLaCarpetaDeSalida + "/" + nombreDeLaNuevaCarpeta;
	}
	
	public void crearCarpetaDeSalida() throws IOException{	
		File directorioFuente = new File("/home/fernando/workspace/aydoo-2016-e4/target/plantilla");
		File carpetaDeSalida = new File(this.direccionDeLaCarpetaDeSalida + "/" + this.nombreDeLaCarpetaDeSalida);
		FileUtils.copyDirectory(directorioFuente, carpetaDeSalida);
	}

	public String getDireccionDeLaCarpetaDeSalida() {
		return this.direccionDeLaCarpetaDeSalida;
	}
	
	public String getNombreDeLaCarpetaDeSalida(){
		return this.nombreDeLaCarpetaDeSalida;
	}

}
