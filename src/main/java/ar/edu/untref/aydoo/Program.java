package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) throws IOException {	
		
		List<String> listaDeArgumentos = new ArrayList<String>();

		//Se completa la lista de argumentos con el arreglo de argumentos
		for(int i = 0; i < args.length; i++){
			listaDeArgumentos.add(i, args[i]);
		}

		ValidadorDeArgumentos validadorDeArgumentos = new ValidadorDeArgumentos(listaDeArgumentos);
		AnalizadorDeArgumentos analizadorDeArgumentos = new AnalizadorDeArgumentos(listaDeArgumentos);

		String nombreDelArchivoDeEntrada = validadorDeArgumentos.getNombreDelArchivoDeEntrada();
		String nombreDeLaCarpetaDeSalida = validadorDeArgumentos.getNombreDeCarpetaDeSalida();

		if(analizadorDeArgumentos.isModeDefault() || analizadorDeArgumentos.isOutput()){	

			modeDefault(nombreDelArchivoDeEntrada, nombreDeLaCarpetaDeSalida);

		} else if(analizadorDeArgumentos.isModeNoOutput()){

			modeNoOutput(nombreDelArchivoDeEntrada, nombreDeLaCarpetaDeSalida);
		}

	}	

	private static void modeDefault(String nombreDelArchivoDeEntrada, String nombreDeLaCarpetaDeSalida) throws IOException {	
		//Se crea la carpeta en donde se guardara el index.html modificado
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = creacionDeLaCarpetaDeSalida(nombreDeLaCarpetaDeSalida);

		//Se lee el archivo markdown de entrada
		List<String> entradaDeMarkdown = lecturaDelArchivoDeEntrada(nombreDelArchivoDeEntrada, creadorDeCarpetaDeSalida);

		//Se crean y organizan las etiquetas HTML a partir de la entrada del archivo markdown
		List<EtiquetaHTML> listaDeEtiquetasHTMLOrganizada = creacionDeEtiquetasHTML(entradaDeMarkdown);

		//Se crea una salida HTML estandar en base a las etiquetas HTML previamente creadas
		List<String> listaDeSalidaHTML = creacionDeSalidaHTMLEstandar(listaDeEtiquetasHTMLOrganizada);

		//Se escribe en el archivo index.html la salida HTML estandar
		escrituraEnArchivoHTML(creadorDeCarpetaDeSalida, listaDeSalidaHTML);

		System.out.println("[INFO] El archivo fue exportado con exito a " + creadorDeCarpetaDeSalida.getDireccionDelJAR() + "/" + nombreDeLaCarpetaDeSalida + "/index.html");
	}

	private static void modeNoOutput(String nombreDelArchivoDeEntrada, String nombreDeLaCarpetaDeSalida) throws IOException {

		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(nombreDeLaCarpetaDeSalida);		

		//Se lee el archivo markdown de entrada
		List<String> entradaDeMarkdown = lecturaDelArchivoDeEntrada(nombreDelArchivoDeEntrada, creadorDeCarpetaDeSalida);

		//Se crean y organizan las etiquetas HTML a partir de la entrada del archivo markdown
		List<EtiquetaHTML> listaDeEtiquetasHTMLOrganizada = creacionDeEtiquetasHTML(entradaDeMarkdown);

		//Se crea una salida HTML estandar en base a las etiquetas HTML previamente creadas
		List<String> listaDeSalidaHTML = creacionDeSalidaHTMLEstandar(listaDeEtiquetasHTMLOrganizada);

		//Salida estandar de la salida HTML
		System.out.println("[INFO] Salida HTML generada a partir de " + nombreDelArchivoDeEntrada);
		for(String salida: listaDeSalidaHTML){
			System.out.println(salida);			
		}

	}

	private static CreadorDeCarpetaDeSalida creacionDeLaCarpetaDeSalida(String nombreDeLaCarpetaDeSalida) throws IOException {
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(nombreDeLaCarpetaDeSalida);
		creadorDeCarpetaDeSalida.crearCarpetaDeSalida();
		return creadorDeCarpetaDeSalida;
	}

	private static List<String> lecturaDelArchivoDeEntrada(String nombreDelArchivoDeEntrada, CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida) throws IOException {
		LectorDeArchivo lectorDeArchivo = new LectorDeArchivo(creadorDeCarpetaDeSalida.getDireccionDelJAR() + "/" + nombreDelArchivoDeEntrada);
		List<String> entradaDeMarkdown = lectorDeArchivo.getLineasDelArchivo();
		return entradaDeMarkdown;
	}

	private static List<EtiquetaHTML> creacionDeEtiquetasHTML(List<String> entradaDeMarkdown) {
		CreadorDeEtiquetas creadorDeEtiquetas = new CreadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetasHTML = creadorDeEtiquetas.crearListaDeEtiquetas(entradaDeMarkdown);
		OrganizadorDeEtiquetas organizadorDeEtiquetas = new OrganizadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetasHTMLOrganizada = organizadorDeEtiquetas.organizarEtiquetasHTML(listaDeEtiquetasHTML);
		return listaDeEtiquetasHTMLOrganizada;
	}

	private static List<String> creacionDeSalidaHTMLEstandar(List<EtiquetaHTML> listaDeEtiquetasHTMLOrganizada) {
		CreadorDeSalidaHTML creadorDeSalidaHTML = new CreadorDeSalidaHTML(listaDeEtiquetasHTMLOrganizada);
		List<String> listaDeSalidaHTML = creadorDeSalidaHTML.getListaDeSalidaHTML();
		return listaDeSalidaHTML;
	}

	private static void escrituraEnArchivoHTML(CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida, List<String> listaDeSalidaHTML) throws IOException {
		EscritorDeArchivo escritorDeArchivo = new EscritorDeArchivo();
		escritorDeArchivo.setListaAEscribir(listaDeSalidaHTML);
		escritorDeArchivo.escribirEnArchivo(creadorDeCarpetaDeSalida.getDireccionDeLaCarpetaDeSalida() + "/index.html");
	}

}
