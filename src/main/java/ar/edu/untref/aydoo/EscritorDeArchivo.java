package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class EscritorDeArchivo {
	
	private List<String> listaDeLineas;
	
	public void escribirEnArchivo(String nombreArchivo) throws IOException{
				
        BufferedReader file = new BufferedReader(new FileReader(nombreArchivo));
        String line;
        String input = "";

        while ((line = file.readLine()) != null){
        	
        	if((line.trim()).equals("[este-es-el-texto-a-reemplazar]")){
        	
        		for(String linea: this.listaDeLineas){
        			input += linea + "\n";
        		}
        	
        	}else{	        		
        		input += line + '\n';
        	}
        }
        
        System.out.println(input);
    	file.close();
    	
        FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
        fileOut.write(input.getBytes());
        fileOut.close();
	}
	
	public List<String> getListaDeLineas() {
		return this.listaDeLineas;
	}
	
	public void setListaAEscribir(List<String> listaDeLineas) {
		this.listaDeLineas = listaDeLineas;
	}
}
