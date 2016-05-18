package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SeccionTest {

	@Test
	public void seccionSeCreaConPrefijo(){

		Seccion seccion = new Seccion();

		String prefijo = seccion.getPrefijo();

		Assert.assertEquals("<section>", prefijo);
	}

	@Test
	public void seccionSeCreaConSufijo(){

		Seccion seccion = new Seccion();

		String sufijo = seccion.getSufijo();

		Assert.assertEquals("</section>", sufijo);
	}

}
