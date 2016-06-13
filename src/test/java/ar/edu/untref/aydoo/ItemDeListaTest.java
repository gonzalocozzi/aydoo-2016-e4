package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.creacionDeEtiquetas.VisitorDeEtiquetas;
import ar.edu.untref.aydoo.etiquetas.Etiqueta;
import ar.edu.untref.aydoo.etiquetas.ItemDeLista;

public class ItemDeListaTest {
	
	@Test
	public void itemDeListaSeCreaConPrefijo(){
		
		Etiqueta itemDeLista = new ItemDeLista();
		
		String prefijo = itemDeLista.getPrefijoHTML();
		
		Assert.assertEquals("<li>", prefijo);
	}	
	
	@Test
	public void itemDeListaSeCreaConSufijo(){
		
		Etiqueta itemDeLista = new ItemDeLista();
		
		String sufijo = itemDeLista.getSufijoHTML();
		
		Assert.assertEquals("</li>", sufijo);
	}
	
	@Test
	public void seIncorporaTextoAlItemDeLista(){
		
		Etiqueta itemDeLista = new ItemDeLista();
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
	
	@Test
	public void elItemSeCreaConSuEncabezadoMD(){
		ItemDeLista item = new ItemDeLista();
		String encabezadoObtenido = item.getEncabezadoMD();
		
		String encabezadoEsperado = "*";
				
		Assert.assertEquals(encabezadoEsperado, encabezadoObtenido);
	}
	
	@Test
	public void elItemSabeReconocerseYCrearseAPartirDeUnaEntradaMD(){
		String entrada = "*item1";
		ItemDeLista item = new ItemDeLista();
		
		Assert.assertEquals(ItemDeLista.class, item.crearConMD(entrada).getClass());
	}
}
