package ar.edu.untref.aydoo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LectorDeArchivo {

	private List<String> listaDeLineasDelArchivo;
	private String direccionDelArchivo;

	public LectorDeArchivo(String direccionDelArchivo){		
		this.listaDeLineasDelArchivo = new LinkedList<String>();
		this.direccionDelArchivo = direccionDelArchivo;
	}

	public List<String> getLineasDelArchivo() throws IOException{		
		this.leerArchivo();

		return this.listaDeLineasDelArchivo;
	}
	
	public String getDireccionDelArchivo() {
		return this.direccionDelArchivo;
	}

	private void leerArchivo() throws FileNotFoundException, IOException {		
		File archivo = new File (this.direccionDelArchivo);
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();

		while(linea != null){
			this.listaDeLineasDelArchivo.add(linea);
			linea = br.readLine();
		}

		br.close();
	}	

}