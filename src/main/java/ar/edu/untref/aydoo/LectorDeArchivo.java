package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LectorDeArchivo {
	
	private List<String> listaDeRenglonesDelArchivo;
	private String direccionDelArchivo;
	
	public LectorDeArchivo(String direccionDelArchivo){		
		this.listaDeRenglonesDelArchivo = new LinkedList<String>();
		this.direccionDelArchivo = direccionDelArchivo;
	}
	
	public List<String> getListaDeRenglonesDelArchivo() throws IOException{		
		this.leerArchivo();
		return this.listaDeRenglonesDelArchivo;
	}

	private void leerArchivo() throws FileNotFoundException, IOException {		
		File archivo = new File (this.direccionDelArchivo);
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
				
		String linea = br.readLine();
		while(linea != null){
			this.listaDeRenglonesDelArchivo.add(linea);
			linea = br.readLine();
		}
		
		br.close();
	}	

	public String getDireccionDelArchivo() {
		return this.direccionDelArchivo;
	}

}