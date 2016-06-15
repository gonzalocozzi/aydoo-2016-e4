package ar.edu.untref.aydoo.analisisDeArgumentos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.edu.untref.aydoo.creacionDeEtiquetas.CreadorDeEtiquetas;
import ar.edu.untref.aydoo.creacionDeEtiquetas.CreadorDeSalidaHTML;
import ar.edu.untref.aydoo.creacionDeEtiquetas.OrganizadorDeEtiquetas;
import ar.edu.untref.aydoo.etiquetas.Etiqueta;
import ar.edu.untref.aydoo.io.CreadorDeCarpetaDeSalida;
import ar.edu.untref.aydoo.io.EscritorDeArchivo;
import ar.edu.untref.aydoo.io.LectorDeArchivo;

public class SelectorDeModo {

	private List<String> listaDeArgumentos;
	private ValidadorDeArgumentos validadorDeArgumentos;
	private AnalizadorDeArgumentos analizadorDeArgumentos;
	private String nombreDelArchivoEntrada;
	private String direccionDelArchivoParaEscribirConSalidaHTML;

	public SelectorDeModo(String[] argumentos) {
		this.listaDeArgumentos = new ArrayList<String>();
		this.inicializarSelector(argumentos);
	}

	private void inicializarSelector(String[] argumentos) {
		this.setListaDeArgumentos(argumentos);
		this.validadorDeArgumentos = new ValidadorDeArgumentos(listaDeArgumentos);
		this.analizadorDeArgumentos = new AnalizadorDeArgumentos(listaDeArgumentos);
		this.setNombreDelArchivoDeEntrada(this.validadorDeArgumentos.getNombreDelArchivoDeEntrada());
		this.setDireccionDelArchivoParaEscribirConSalidaHTML(this.validadorDeArgumentos.getNombreDeCarpetaDeSalida() + "/index.html");
	}

	public List<String> getListaDeArgumentos() {
		return this.listaDeArgumentos;
	}

	private void setListaDeArgumentos(String[] argumentos){		
		//Se completa la lista de argumentos con el arreglo de argumentos
		for(int i = 0; i < argumentos.length; i++){
			this.listaDeArgumentos.add(i, argumentos[i]);
		}
	}

	public void setNombreDelArchivoDeEntrada(String archivo){
		this.nombreDelArchivoEntrada = archivo;
	}

	public void setDireccionDelArchivoParaEscribirConSalidaHTML(String archivo){
		this.direccionDelArchivoParaEscribirConSalidaHTML = archivo;
	}

	public void seleccionarModo() throws IOException {	
		if(analizadorDeArgumentos.contieneModoDefault() || analizadorDeArgumentos.contieneOutput()){	
			this.seleccionarModoDefault();
		} else if(analizadorDeArgumentos.contieneModoNoOutput()){
			this.seleccionarModoNoOutput();
		}
	}	

	public void seleccionarModoDefault() throws IOException {		
		//Se escribe en el archivo index.html la salida HTML estandar
		this.crearCarpetaDeSalida(this.validadorDeArgumentos.getNombreDeCarpetaDeSalida());
		this.escribirArchivoHTML(this.getListaHTMLDeSalida());
		System.out.println("El archivo fue exportado con exito.");
	}

	public void seleccionarModoNoOutput() throws IOException {		
		List<String> listaDeSalida = this.getListaHTMLDeSalida();
		System.out.println("Salida HTML generada");

		for(String salida: listaDeSalida){
			System.out.println(salida);			
		}		
	}

	private List<String> getListaHTMLDeSalida() throws IOException{		
		List<String> entradaDeMarkdown = leerArchivoDeEntrada(this.nombreDelArchivoEntrada);
		List<Etiqueta> listaDeEtiquetasHTMLOrganizada = crearEtiquetasHTML(entradaDeMarkdown);
		List<String> listaHTMLDeSalida = crearSalidaHTMLEstandar(listaDeEtiquetasHTMLOrganizada);

		return listaHTMLDeSalida;
	}
	
	private List<String> leerArchivoDeEntrada(String nombreDelArchivoDeEntrada) throws IOException {
		LectorDeArchivo lectorDeArchivo = new LectorDeArchivo(nombreDelArchivoDeEntrada);
		List<String> entradaDeMarkdown = lectorDeArchivo.getLineasDelArchivo();
		return entradaDeMarkdown;
	}
	
	private List<Etiqueta> crearEtiquetasHTML(List<String> entradaDeMarkdown) {
		CreadorDeEtiquetas creadorDeEtiquetas = new CreadorDeEtiquetas();
		List<Etiqueta> listaDeEtiquetasHTML = creadorDeEtiquetas.crearListaDeEtiquetas(entradaDeMarkdown);
		OrganizadorDeEtiquetas organizadorDeEtiquetas = new OrganizadorDeEtiquetas();
		List<Etiqueta> listaDeEtiquetasHTMLOrganizada = organizadorDeEtiquetas.organizar(listaDeEtiquetasHTML);
		return listaDeEtiquetasHTMLOrganizada;
	}
	
	private List<String> crearSalidaHTMLEstandar(List<Etiqueta> listaDeEtiquetasHTMLOrganizada) {
		CreadorDeSalidaHTML creadorDeSalidaHTML = new CreadorDeSalidaHTML(listaDeEtiquetasHTMLOrganizada);
		List<String> listaDeSalidaHTML = creadorDeSalidaHTML.getListaDeSalidaHTML();
		return listaDeSalidaHTML;
	}

	private void crearCarpetaDeSalida(String nombreDeLaCarpetaDeSalida) throws IOException {
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(nombreDeLaCarpetaDeSalida);
		creadorDeCarpetaDeSalida.crearCarpetaDeSalida();
	}

	private void escribirArchivoHTML(List<String> listaDeSalidaHTML) throws IOException {
		EscritorDeArchivo escritorDeArchivo = new EscritorDeArchivo();
		escritorDeArchivo.setListaAEscribir(listaDeSalidaHTML);
		escritorDeArchivo.escribirEnArchivo(this.direccionDelArchivoParaEscribirConSalidaHTML);
	}
}
