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
			
			modeNoOutput(validadorDeArgumentos.getNombreDeCarpetaDeSalida());
		}
		
	}	

	private static void modeDefault(String nombreDeLaCarpetaDeSalida) throws IOException {		
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(nombreDeLaCarpetaDeSalida);
		creadorDeCarpetaDeSalida.crearCarpetaDeSalida();
		LectorDeArchivo lectorDeArchivo = new LectorDeArchivo(creadorDeCarpetaDeSalida.getDireccionDelJAR() + "/" + nombreDeLaCarpetaDeSalida + ".md");
		List<String> entradaDeMarkdown = lectorDeArchivo.getListaDeRenglonesDelArchivo();
		CreadorDeEtiquetas creadorDeEtiquetas = new CreadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetasHTML = creadorDeEtiquetas.crearListaDeEtiquetas(entradaDeMarkdown);
		OrganizadorDeEtiquetas organizadorDeEtiquetas = new OrganizadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetasHTMLOrganizada = organizadorDeEtiquetas.organizarEtiquetasHTML(listaDeEtiquetasHTML);
		CreadorDeSalidaHTML creadorDeSalidaHTML = new CreadorDeSalidaHTML(listaDeEtiquetasHTMLOrganizada);
		List<String> listaDeSalidaHTML = creadorDeSalidaHTML.getListaDeSalidaHTML();
		EscritorDeArchivo escritorDeArchivo = new EscritorDeArchivo();
		escritorDeArchivo.setListaAEscribir(listaDeSalidaHTML);
		escritorDeArchivo.escribirEnArchivo(creadorDeCarpetaDeSalida.getDireccionDeLaCarpetaDeSalida() + "/index.html");
	}
	
	private static void modeNoOutput(String nombreDeLaCarpetaDeSalida) throws IOException {		
		LectorDeArchivo lectorDeArchivo = new LectorDeArchivo("mipresentacion1.md");
		List<String> entradaDeMarkdown = lectorDeArchivo.getListaDeRenglonesDelArchivo();
		CreadorDeEtiquetas creadorDeEtiquetas = new CreadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetasHTML = creadorDeEtiquetas.crearListaDeEtiquetas(entradaDeMarkdown);
		CreadorDeSalidaHTML creadorDeSalidaHTML = new CreadorDeSalidaHTML(listaDeEtiquetasHTML);
		List<String> listaDeSalida = creadorDeSalidaHTML.getListaDeSalidaHTML();
		
		for(String salida: listaDeSalida){
			System.out.println(salida);			
		}
	}

}
