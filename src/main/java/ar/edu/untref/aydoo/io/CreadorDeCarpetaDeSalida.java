package ar.edu.untref.aydoo.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CreadorDeCarpetaDeSalida {

	private String nombreDeLaCarpetaDeSalida;
	private String direccionDeLaCarpetaDeSalida;
	private ReconocedorDeDireccionDelJAR reconocedor;

	public CreadorDeCarpetaDeSalida(String nombreDeLaCarpetaDeSalida) throws IOException {
		this.nombreDeLaCarpetaDeSalida = nombreDeLaCarpetaDeSalida;
		this.reconocedor = new ReconocedorDeDireccionDelJAR();
		this.direccionDeLaCarpetaDeSalida = this.reconocedor.getDireccionDelJAR() + "/" + nombreDeLaCarpetaDeSalida;
	}

	public void crearCarpetaDeSalida() {	
		File directorioFuente = new File(this.reconocedor.getDireccionDelJAR() + "/plantilla");
		File carpetaDeSalida = new File(this.direccionDeLaCarpetaDeSalida);

		try {
			FileUtils.copyDirectory(directorioFuente, carpetaDeSalida);
		} catch (IOException e) {
			//Solo para test
			this.reconocedor.setDireccionDelJAR("");
		}
	}

	public String getDireccionDeLaCarpetaDeSalida() {
		return this.direccionDeLaCarpetaDeSalida;
	}

	public String getNombreDeLaCarpetaDeSalida(){
		return this.nombreDeLaCarpetaDeSalida;
	}
}
