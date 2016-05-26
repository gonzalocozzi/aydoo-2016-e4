package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectorDeModos {
	
	private List<String> listaDeArgumentos;
	private ValidadorDeArgumentos validadorDeArgumentos;
	private AnalizadorDeArgumentos analizadorDeArgumentos;
	private CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida;
	private String archivoEntrada;
	private String archivoParaEscribirHtml;

	public SelectorDeModos(String[] argumentos) {
		this.listaDeArgumentos = new ArrayList<String>();
		this.setListaDeArgumentos(argumentos);
		this.validarArgumentos();
		this.analizarArgumentos();
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
	
	public void setArchivoDeEntrada(String archivo){
		this.archivoEntrada = archivo;
	}

	public void setArchivoParaEscribirHtml(String archivo){
		this.archivoParaEscribirHtml = archivo;
	}

	public String getNombreDelArchivo() {		
		return this.validadorDeArgumentos.getNombreDelArchivoDeEntrada();
	}
	
	public String getNombreDeLaCarpetaDeSalida() {		
		return this.validadorDeArgumentos.getNombreDeCarpetaDeSalida();
	}
	
	private void validarArgumentos(){
		this.validadorDeArgumentos = new ValidadorDeArgumentos(listaDeArgumentos);
	}
	
	private void analizarArgumentos(){
		this.analizadorDeArgumentos = new AnalizadorDeArgumentos(listaDeArgumentos);
	}

	public void seleccionarModoDefault() throws IOException {
		
		//Se escribe en el archivo index.html la salida HTML estandar
		escrituraEnArchivoHTML(creadorDeCarpetaDeSalida, this.prepararListaParaSalida());
		System.out.println("El archivo fue exportado con exito");
	}
	
	public void seleccionarModoNoOutput() throws IOException {
		
		List<String> listaDeSalida = this.prepararListaParaSalida();
		
		System.out.println("Salida HTML generada");
		for(String salida: listaDeSalida){
			System.out.println(salida);			
		}		
	}
	
	private List<String> prepararListaParaSalida() throws IOException{
		
		//Se crea la carpeta en donde se guardara el index.html modificado
		this.creadorDeCarpetaDeSalida = creacionDeLaCarpetaDeSalida(this.getNombreDeLaCarpetaDeSalida());

		//Se lee el archivo markdown de entrada
		List<String> entradaDeMarkdown = lecturaDelArchivoDeEntrada(this.archivoEntrada, this.creadorDeCarpetaDeSalida);

		//Se crean y organizan las etiquetas HTML a partir de la entrada del archivo markdown
		List<EtiquetaHTML> listaDeEtiquetasHTMLOrganizada = creacionDeEtiquetasHTML(entradaDeMarkdown);

		//Se crea una salida HTML estandar en base a las etiquetas HTML previamente creadas
		List<String> listaDeSalidaHTML = creacionDeSalidaHTMLEstandar(listaDeEtiquetasHTMLOrganizada);
		
		return listaDeSalidaHTML;
	}
	
	private CreadorDeCarpetaDeSalida creacionDeLaCarpetaDeSalida(String nombreDeLaCarpetaDeSalida) throws IOException {
		CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(nombreDeLaCarpetaDeSalida);
		creadorDeCarpetaDeSalida.crearCarpetaDeSalida();
		return creadorDeCarpetaDeSalida;
	}
	
	private List<String> lecturaDelArchivoDeEntrada(String nombreDelArchivoDeEntrada, CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida) throws IOException {
		LectorDeArchivo lectorDeArchivo = new LectorDeArchivo(creadorDeCarpetaDeSalida.getDireccionDelJAR() + "/" + nombreDelArchivoDeEntrada);
		List<String> entradaDeMarkdown = lectorDeArchivo.getLineasDelArchivo();
		return entradaDeMarkdown;
	}

	private List<EtiquetaHTML> creacionDeEtiquetasHTML(List<String> entradaDeMarkdown) {
		CreadorDeEtiquetas creadorDeEtiquetas = new CreadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetasHTML = creadorDeEtiquetas.crearListaDeEtiquetas(entradaDeMarkdown);
		OrganizadorDeEtiquetas organizadorDeEtiquetas = new OrganizadorDeEtiquetas();
		List<EtiquetaHTML> listaDeEtiquetasHTMLOrganizada = organizadorDeEtiquetas.organizarEtiquetasHTML(listaDeEtiquetasHTML);
		return listaDeEtiquetasHTMLOrganizada;
	}

	private List<String> creacionDeSalidaHTMLEstandar(List<EtiquetaHTML> listaDeEtiquetasHTMLOrganizada) {
		CreadorDeSalidaHTML creadorDeSalidaHTML = new CreadorDeSalidaHTML(listaDeEtiquetasHTMLOrganizada);
		List<String> listaDeSalidaHTML = creadorDeSalidaHTML.getListaDeSalidaHTML();
		return listaDeSalidaHTML;
	}

	private void escrituraEnArchivoHTML(CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida, List<String> listaDeSalidaHTML) throws IOException {
		EscritorDeArchivo escritorDeArchivo = new EscritorDeArchivo();
		escritorDeArchivo.setListaAEscribir(listaDeSalidaHTML);
		//escritorDeArchivo.escribirEnArchivo(this.getNombreDeLaCarpetaDeSalida() + "/index.html");
		escritorDeArchivo.escribirEnArchivo(this.archivoParaEscribirHtml);
	}	
}
