package ar.edu.untref.aydoo;

public interface Visitor {
	
	public void visitar(Titulo titulo);

	public void visitar(Subtitulo subtitulo);

	public void visitar(Imagen imagen);

	public void visitar(TextoSinFormato textoSinFormato);

	public void visitar(ItemDeLista itemDeLista);
}
