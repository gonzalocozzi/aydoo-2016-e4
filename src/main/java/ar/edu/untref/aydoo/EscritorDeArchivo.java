package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscritorDeArchivo {
	
	private List<String> listaDeLineas;
	
	public void escribirEnArchivo(String nombreArchivo) throws IOException{
	    File archivo = new File(nombreArchivo);
	    BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo));
	    escritorAuxiliar(escritor);
	}

	public void escritorAuxiliar(BufferedWriter escritor){		
		
		try{			
			for(int i = 0; i < this.listaDeLineas.size(); i++){
				escritor.write(this.listaDeLineas.get(i)+"\n");
			}
		
			escritor.close();
		
		} catch (IOException e){			
			
			System.out.println("No se puede escribir en este archivo");
		}	
	}
	
	public List<String> getListaDeLineas() {
		return this.listaDeLineas;
	}

	public void setListaAEscribir(List<String> listaDeLineas) {
		this.listaDeLineas = listaDeLineas;
	}
}
