package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ItemDeListaTest {
	
	@Test
	public void itemDeListaSeCreaConPrefijo(){
		
		EtiquetaHTML itemDeLista = new ItemDeLista();
		
		String prefijo = itemDeLista.getPrefijo();
		
		Assert.assertEquals("<li>", prefijo);
	}	
	
	@Test
	public void itemDeListaSeCreaConSufijo(){
		
		EtiquetaHTML itemDeLista = new ItemDeLista();
		
		String sufijo = itemDeLista.getSufijo();
		
		Assert.assertEquals("</li>", sufijo);
	}
	
	@Test
	public void seIncorporaTextoAlItemDeLista(){
		
		EtiquetaHTML itemDeLista = new ItemDeLista();
		String contenido = "un item de la lista";
		itemDeLista.setTexto(contenido);
		
		String textoDelItem = itemDeLista.getTexto();
		
		Assert.assertEquals(contenido, textoDelItem);		
	}
	
	@Test
	public void itemDeListaAceptaElVisitor(){
		
		ItemDeLista itemDeLista = new ItemDeLista();
		itemDeLista.setTexto("item de lista");
		VisitorDeEtiquetas visitor = new VisitorDeEtiquetas();
		itemDeLista.aceptarVisitor(visitor);
		
		String resultadoEsperado = "<li>item de lista</li>";
		
		Assert.assertEquals(resultadoEsperado, visitor.getListaDeLineas().get(0));
	}
}
