package ar.edu.untref.aydoo.traduccion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.edu.untref.aydoo.analisisDeArgumentos.ValidadorDeArgumentos;

public class Traductor {
	
	private List<String> listaDeArgumentos;
	private List<ModoDeSalida> modosDeSalidaDisponibles;
	private ValidadorDeArgumentos validadorDeArgumentos;
	private String nombreDelArchivoDeEntrada;
	
	public Traductor(String[] argumentos){
		this.modosDeSalidaDisponibles = new ArrayList<>();
		this.listaDeArgumentos = new ArrayList<>();
		this.setListaDeArgumentos(argumentos);		
		this.validadorDeArgumentos = new ValidadorDeArgumentos(this.listaDeArgumentos);
		this.nombreDelArchivoDeEntrada = this.validadorDeArgumentos.getNombreDelArchivoDeEntrada();
		
		//Se agregan modos de traduccion por default
		ModoDeSalidaDefault modoDefault = new ModoDeSalidaDefault(this.listaDeArgumentos, this.nombreDelArchivoDeEntrada);
		ModoDeSalidaNoOutput modoNoOutput = new ModoDeSalidaNoOutput(this.listaDeArgumentos, this.nombreDelArchivoDeEntrada);
		this.agregarModoDeSalida(modoDefault);
		this.agregarModoDeSalida(modoNoOutput);
	}	
	
	public List<String> getListaDeArgumentos(){
		return this.listaDeArgumentos;
	}
	
	public List<ModoDeSalida> getModosDeSalidaDisponibles(){
		return this.modosDeSalidaDisponibles;
	}
	
	public void agregarModoDeSalida(ModoDeSalida modo){
		this.modosDeSalidaDisponibles.add(modo);
	}	
	
	private void setListaDeArgumentos(String[] argumentos){		
		//Se completa la lista de argumentos con el arreglo de argumentos
		for(int i = 0; i < argumentos.length; i++){
			this.listaDeArgumentos.add(i, argumentos[i]);
		}
	}
	
	public void traducir() throws IOException, InstantiationException, IllegalAccessException {	
		for(ModoDeSalida modoDeSalida: this.modosDeSalidaDisponibles){
			modoDeSalida.traducir();
		}
	}

}
