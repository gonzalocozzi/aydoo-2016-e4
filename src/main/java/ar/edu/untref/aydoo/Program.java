package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
	
	public static void main(String[] args) throws IOException {	
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		
		//Se completa la lista de argumentos con el arreglo de argumentos
		for(int i = 0; i < args.length; i++){
			listaDeArgumentos.add(i, args[i].toLowerCase());
		}
		
		ValidadorDeArgumentos validadorDeArgumentos = new ValidadorDeArgumentos(listaDeArgumentos);
		AnalizadorDeArgumentos analizadorDeArgumentos = new AnalizadorDeArgumentos(listaDeArgumentos);
				
		if(analizadorDeArgumentos.isModeDefault()){	
			
			modeDefault(validadorDeArgumentos.getNombreDeCarpetaDeSalida());
			
		} else if(analizadorDeArgumentos.isModeNoOutput()){
			
			modeNoOutput();
		}
		
	}	

	private static void modeDefault(String nombreDeLaCarpetaDeSalida) throws IOException {		
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(nombreDeLaCarpetaDeSalida);
		creadorDeCarpetaDeSalida.crearCarpetaDeSalida();
		LectorDeArchivo lectorDeArchivo = new LectorDeArchivo();
		List<String> entradaDeMarkdown = lectorDeArchivo.leerArchivo("/home/gonzalo/Documentos/UNTREF/Análisis y Diseño Orientado a Objetos/Práctica/aydoo-2016-e4/target/mipresentacion1.md");
		CreadorDeEtiquetas creadorDeEtiquetas = new CreadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetasHTML = creadorDeEtiquetas.crearListaDeEtiquetas(entradaDeMarkdown);
		CreadorDeSalidaHTML creadorDeSalidaHTML = new CreadorDeSalidaHTML(listaDeEtiquetasHTML);
		List<String> listaDeSalidaHTML = creadorDeSalidaHTML.getListaDeSalidaHTML();
		EscritorDeArchivoHTML escritorDeArchivo = new EscritorDeArchivoHTML();
		escritorDeArchivo.setListaAEscribir(listaDeSalidaHTML);
		escritorDeArchivo.escribirEnArchivo("/home/gonzalo/Documentos/UNTREF/Análisis y Diseño Orientado a Objetos/Práctica/aydoo-2016-e4/target/mipresentacion1.md");
	}
	
	private static void modeNoOutput() throws IOException {
		LectorDeArchivo lectorDeArchivo = new LectorDeArchivo();
		List<String> entradaDeMarkdown = lectorDeArchivo.leerArchivo("/home/gonzalo/Documentos/UNTREF/Análisis y Diseño Orientado a Objetos/Práctica/aydoo-2016-e4/target/mipresentacion1.md");
		CreadorDeEtiquetas creadorDeEtiquetas = new CreadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetasHTML = creadorDeEtiquetas.crearListaDeEtiquetas(entradaDeMarkdown);
		CreadorDeSalidaHTML creadorDeSalidaHTML = new CreadorDeSalidaHTML(listaDeEtiquetasHTML);
		String salidaHTML = creadorDeSalidaHTML.getSalidaHTML();
		
		System.out.println(salidaHTML);
	}

}
