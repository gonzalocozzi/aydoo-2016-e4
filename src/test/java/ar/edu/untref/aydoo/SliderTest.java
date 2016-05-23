package ar.edu.untref.aydoo;

import org.junit.Test;

public class SliderTest {
	
	@Test(expected=SinNombreDelArchivoDeEntradaException.class)
	public void sliderExigeElIngresoDeUnArgumentoConElNombreDelArchivoDeEntrada(){
		
		String[] args = {};
		Slider.main(args);
	}

}
