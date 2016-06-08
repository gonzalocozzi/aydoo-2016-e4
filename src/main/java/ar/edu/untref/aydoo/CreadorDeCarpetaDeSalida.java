package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CreadorDeCarpetaDeSalida {

	private String nombreDeLaCarpetaDeSalida;
	private String direccionDeLaCarpetaDeSalida;
	private ReconocedorDeDireccionDelJar reconocedor;

	public CreadorDeCarpetaDeSalida(String nombreDeLaCarpetaDeSalida) throws IOException {
		this.nombreDeLaCarpetaDeSalida = nombreDeLaCarpetaDeSalida;
		this.reconocedor = new ReconocedorDeDireccionDelJar();
		this.direccionDeLaCarpetaDeSalida = this.reconocedor.getDireccionDelJar() + "/" + nombreDeLaCarpetaDeSalida;
	}

	public void crearCarpetaDeSalida() {	
		File directorioFuente = new File(this.reconocedor.getDireccionDelJar() + "/plantilla");
		File carpetaDeSalida = new File(this.direccionDeLaCarpetaDeSalida);

		try {
			FileUtils.copyDirectory(directorioFuente, carpetaDeSalida);
		} catch (IOException e) {
			//Solo para test
			this.reconocedor.setDireccionDelJar("");
		}
	}

	public String getDireccionDeLaCarpetaDeSalida() {
		return this.direccionDeLaCarpetaDeSalida;
	}

	public String getNombreDeLaCarpetaDeSalida(){
		return this.nombreDeLaCarpetaDeSalida;
	}
}
