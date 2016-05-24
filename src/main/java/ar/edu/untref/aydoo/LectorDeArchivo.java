package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LectorDeArchivo {
	
	private List<String> listaDeRenglonesDelArchivo;
	private String direccionDelArchivo;
	
	public LectorDeArchivo(){		
		this.listaDeRenglonesDelArchivo = new LinkedList<String>();
	}
	
	public List<String> leerArchivo(String direccionDelArchivo) throws IOException{
		
		this.setDireccionDelArchivo(direccionDelArchivo);
		
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
		return this.listaDeRenglonesDelArchivo;
	}
	
	public void setDireccionDelArchivo(String direccionDelArchivo){
		this.direccionDelArchivo = direccionDelArchivo;
	}

	public String getDireccionDelArchivo() {
		return this.direccionDelArchivo;
	}

}
