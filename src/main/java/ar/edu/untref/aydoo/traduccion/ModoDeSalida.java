package ar.edu.untref.aydoo.traduccion;

import java.io.IOException;
import java.util.List;

import ar.edu.untref.aydoo.analisisDeArgumentos.AnalizadorDeArgumentos;
import ar.edu.untref.aydoo.creacionDeEtiquetas.CreadorDeEtiquetas;
import ar.edu.untref.aydoo.creacionDeEtiquetas.CreadorDeSalidaHTML;
import ar.edu.untref.aydoo.creacionDeEtiquetas.OrganizadorDeEtiquetas;
import ar.edu.untref.aydoo.etiquetas.Etiqueta;
import ar.edu.untref.aydoo.io.LectorDeArchivo;

public class ModoDeSalida {

	protected AnalizadorDeArgumentos analizadorDeArgumentos;
	private String nombreDelArchivoDeEntrada;
	private LectorDeArchivo lectorDeArchivo;
	private CreadorDeEtiquetas creadorDeEtiquetas;
	private OrganizadorDeEtiquetas organizadorDeEtiquetas;
	private CreadorDeSalidaHTML creadorDeSalidaHTML;	

	public ModoDeSalida(List<String> listaDeArgumentos, String nombreDelArchivoDeEntrada){
		this.analizadorDeArgumentos = new AnalizadorDeArgumentos(listaDeArgumentos);
		this.nombreDelArchivoDeEntrada = nombreDelArchivoDeEntrada;
	}

	public void traducir() throws IOException{}

	public String getNombreDeArchivoDeEntrada() {
		return this.nombreDelArchivoDeEntrada;
	}

	public List<String> getListaHTMLDeSalida() throws IOException{		
		List<String> entradaDeMarkdown = this.leerArchivoDeEntrada();
		List<Etiqueta> listaDeEtiquetasHTMLOrganizada = this.crearEtiquetasHTML(entradaDeMarkdown);
		List<String> listaHTMLDeSalida = this.crearSalidaHTMLEstandar(listaDeEtiquetasHTMLOrganizada);

		return listaHTMLDeSalida;
	}

	//Es public solo para testear el metodo
	public List<String> leerArchivoDeEntrada() throws IOException {
		this.lectorDeArchivo = new LectorDeArchivo(this.nombreDelArchivoDeEntrada);
		List<String> entradaDeMarkdown = lectorDeArchivo.getLineasDelArchivo();

		return entradaDeMarkdown;
	}

	//Es public solo para testear el metodo
	public List<Etiqueta> crearEtiquetasHTML(List<String> entradaDeMarkdown) {
		this.creadorDeEtiquetas = new CreadorDeEtiquetas();
		List<Etiqueta> listaDeEtiquetasHTML = creadorDeEtiquetas.crearListaDeEtiquetas(entradaDeMarkdown);
		this.organizadorDeEtiquetas = new OrganizadorDeEtiquetas();
		List<Etiqueta> listaDeEtiquetasHTMLOrganizada = organizadorDeEtiquetas.organizar(listaDeEtiquetasHTML);

		return listaDeEtiquetasHTMLOrganizada;
	}

	//Es public solo para testear metodo
	public List<String> crearSalidaHTMLEstandar(List<Etiqueta> listaDeEtiquetasHTMLOrganizada) {
		this.creadorDeSalidaHTML = new CreadorDeSalidaHTML(listaDeEtiquetasHTMLOrganizada);
		List<String> listaDeSalidaHTML = creadorDeSalidaHTML.getListaDeSalidaHTML();

		return listaDeSalidaHTML;
	}

}
