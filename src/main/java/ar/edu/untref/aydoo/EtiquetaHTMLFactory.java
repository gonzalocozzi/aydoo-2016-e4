package ar.edu.untref.aydoo;

public class EtiquetaHTMLFactory implements EtiquetaHTMLFactoryMethod{

	@Override
	public EtiquetaHTML crearEtiqueta(String encabezado) {

		if(encabezado.equals("#")){
			return new Titulo();
		}
		else if(encabezado.equals("##")){
			return new Subtitulo();
		}
		else if(encabezado.equals("i:")){
			return new Imagen();
		}
		else if(encabezado.equals("*")){
			return new ItemDeLista();
		}
		else if(encabezado.equals("---")){
			return new Seccion();
		}
		else{
			return new TextoSinFormato();
		}

	}


}
