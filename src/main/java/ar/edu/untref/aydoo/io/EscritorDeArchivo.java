package ar.edu.untref.aydoo.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class EscritorDeArchivo {

	private List<String> listaDeLineas;

	public void escribirEnArchivo(String nombreArchivo) throws IOException{
		BufferedReader archivo = new BufferedReader(new FileReader(nombreArchivo));
		String lineaArchivo;
		String entrada = "";

		while ((lineaArchivo = archivo.readLine()) != null){        	
			entrada = guardarLineaDeEntrada(lineaArchivo, entrada);
		}
		archivo.close();

		FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
		fileOut.write(entrada.getBytes());
		fileOut.close();
	}

	public String guardarLineaDeEntrada(String lineaArchivo, String entrada) {

		if((lineaArchivo.trim()).equals("[este-es-el-texto-a-reemplazar]")){	

			for(String linea: this.listaDeLineas){
				entrada += linea + "\n";
			}

		} else {	        		
			entrada += lineaArchivo + '\n';
		}

		return entrada;
	}

	public List<String> getListaDeLineas() {
		return this.listaDeLineas;
	}

	public void setListaAEscribir(List<String> listaDeLineas) {
		this.listaDeLineas = listaDeLineas;
	}
}
