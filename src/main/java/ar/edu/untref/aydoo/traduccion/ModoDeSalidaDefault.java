package ar.edu.untref.aydoo.traduccion;

import java.io.IOException;
import java.util.List;

import ar.edu.untref.aydoo.analisisDeArgumentos.ValidadorDeArgumentos;
import ar.edu.untref.aydoo.io.CreadorDeCarpetaDeSalida;
import ar.edu.untref.aydoo.io.EscritorDeArchivo;

public class ModoDeSalidaDefault extends ModoDeSalida {

	private ValidadorDeArgumentos validadorDeArgumentos;
	private CreadorDeCarpetaDeSalida creadorDeCarpetaDeSalida;
	private EscritorDeArchivo escritorDeArchivo;
	private String direccionDelArchivoAEscribirConSalidaHTML;

	public ModoDeSalidaDefault(List<String> listaDeArgumentos, String nombreDelArchivoDeEntrada) {
		super(listaDeArgumentos, nombreDelArchivoDeEntrada);
		this.validadorDeArgumentos = new ValidadorDeArgumentos(listaDeArgumentos);
		this.setDireccionDelArchivoAEscribirConSalidaHTML(this.validadorDeArgumentos.getNombreDeCarpetaDeSalida() + "/index.html");
	}	

	@Override
	public void traducir() throws IOException {
		if(super.analizadorDeArgumentos.contieneModoDefault() || super.analizadorDeArgumentos.contieneOutput()){
			this.crearCarpetaDeSalida(this.validadorDeArgumentos.getNombreDeCarpetaDeSalida());
			this.escribirEnArchivoHTML(this.getListaHTMLDeSalida());
			System.out.println("El archivo fue exportado con exito.");
		}		
	}
	
	//Es public solo para testear el comportamiento de la clase
	public void setDireccionDelArchivoAEscribirConSalidaHTML(String direccionDelArchivo){
		this.direccionDelArchivoAEscribirConSalidaHTML = direccionDelArchivo;
	}

	private void crearCarpetaDeSalida(String nombreDeLaCarpetaDeSalida) throws IOException {
		this.creadorDeCarpetaDeSalida = new CreadorDeCarpetaDeSalida(nombreDeLaCarpetaDeSalida);
		creadorDeCarpetaDeSalida.crearCarpetaDeSalida();
	}

	private void escribirEnArchivoHTML(List<String> listaDeSalidaHTML) throws IOException {
		this.escritorDeArchivo = new EscritorDeArchivo();
		escritorDeArchivo.setListaAEscribir(listaDeSalidaHTML);
		escritorDeArchivo.escribirEnArchivo(this.direccionDelArchivoAEscribirConSalidaHTML);		
	}

}
