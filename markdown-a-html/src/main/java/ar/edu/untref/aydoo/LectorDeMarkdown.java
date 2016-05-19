package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LectorDeMarkdown {
	
	public List<String> leerMarkDown(String direccionDelArchivo) throws IOException{
		File archivo = new File (direccionDelArchivo);
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		boolean seguirLeyendo = true;
		List<String> listaADevolver = new LinkedList<String>();
		while(seguirLeyendo){
			String linea = br.readLine();
			if(linea == null){
				seguirLeyendo = false;
			}
			else{
				listaADevolver.add(linea);
			}
		}
		br.close();
		return listaADevolver;
	}

}
