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
		boolean seguirLeyendo = true;
		
		while(seguirLeyendo){
			String linea = br.readLine();
			if(linea == null){
				seguirLeyendo = false;
			}
			else{
				this.listaDeRenglonesDelArchivo.add(linea);
			}
		}
		
		br.close();
	}	

	public String getDireccionDelArchivo() {
		return this.direccionDelArchivo;
	}

}
