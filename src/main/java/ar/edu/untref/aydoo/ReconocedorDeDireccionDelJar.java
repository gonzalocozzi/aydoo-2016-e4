package ar.edu.untref.aydoo;

import java.io.File;

public class ReconocedorDeDireccionDelJar {
	
	private File archivo;
	private File direccion;
	private String direccionDelJar;
	
	public ReconocedorDeDireccionDelJar(){
		//Se obtiene de la direccion del JAR, ubicado al lado de la carpeta de salida
		this.archivo = new File(System.getProperty("java.class.path"));
		this.direccion = archivo.getAbsoluteFile().getParentFile();	
		this.direccionDelJar = direccion.toString();
	}

	public String getDireccionDelJar() {
		return this.direccionDelJar;
	}
	
	public void setDireccionDelJar(String direccion){
		this.direccionDelJar = direccion;
	}		
}
