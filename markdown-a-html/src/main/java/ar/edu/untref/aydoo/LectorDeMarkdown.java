package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectorDeMarkdown {

	public String leerMarkDown(String direccionDelArchivo) throws IOException{
		File archivo = new File (direccionDelArchivo);
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		boolean seguirLeyendo = true;
		String textoADevolver = "";
		while(seguirLeyendo == true){
			String linea = br.readLine();
			if(linea == null){
				seguirLeyendo = false;
			}
			else{
				textoADevolver += linea;
				textoADevolver += "\n";
			}
		}
		br.close();
		return textoADevolver;
	}

}
