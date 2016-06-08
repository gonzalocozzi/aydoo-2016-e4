package ar.edu.untref.aydoo;

import java.io.File;

public class ReconocedorDeDireccionDelJAR {

	private File archivo;
	private File direccion;
	private String direccionDelJAR;

	public ReconocedorDeDireccionDelJAR(){
		//Se obtiene de la direccion del JAR, ubicado al lado de la carpeta de salida
		this.archivo = new File(System.getProperty("java.class.path"));
		this.direccion = archivo.getAbsoluteFile().getParentFile();	
		this.direccionDelJAR = direccion.toString();
	}

	public String getDireccionDelJAR() {
		return this.direccionDelJAR;
	}

	public void setDireccionDelJAR(String direccion){
		this.direccionDelJAR = direccion;
	}		

}
