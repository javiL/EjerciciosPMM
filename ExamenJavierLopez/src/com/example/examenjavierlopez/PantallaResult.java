package com.example.examenjavierlopez;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PantallaResult extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantallaresultado);
		
		//declaramos variables
		TextView tarifaFinal = (TextView)findViewById(R.id.TxtTarifa);
		TextView valor = (TextView)findViewById(R.id.TxtValor);
		Bundle bund = this.getIntent().getExtras();
		int billete500, billete200, billete100, billete50, billete20, billete10, billete5, 
   	    moneda2, moneda1, cent50, cent20, cent10, cent5, cent2, cent1;
		
		//recogemos los bundle
		tarifaFinal.setText(bund.getString("Tarifa"));
		double precio = bund.getDouble("PrecioFinal");
		
		//pasamos el preciofinal a integer
		int precioFinal=(int)precio;
   	 	double decima = precio - precioFinal;
   
   	 //Calculamos la parte entera con los billetes y monedas ya que el precio es 
   	 // "PARTEENTERA.XX"
   	 billete500 = precioFinal / 500; 
   	 precioFinal = precioFinal % 500; 
   	 billete200 = precioFinal / 200; 
   	 precioFinal = precioFinal % 200; 
   	 billete100 = precioFinal / 100; 
   	 precioFinal = precioFinal % 100; 
   	 billete50 = precioFinal / 50; 
   	 precioFinal = precioFinal % 50; 
   	 billete20 = precioFinal / 20; 
   	 precioFinal = precioFinal % 20; 
   	 billete10 = precioFinal / 10; 
   	 precioFinal = precioFinal % 10; 
   	 billete5 = precioFinal / 5; 
   	 precioFinal = precioFinal % 5; 
   	 moneda2 = precioFinal / 2; 
   	 precioFinal = precioFinal % 2; 
   	 moneda1 = precioFinal / 1; 
   	 precioFinal = precioFinal % 1; 
   	 
   	//Calculamos la parte decimal con los centimos "XX.centimos"
   	 int restante = (int)(decima * 1000 + 0.5);
   	 cent50 = restante / 500; 
   	 restante = restante % 500; 
   	 cent20 = restante / 200; 
   	 restante = restante % 200; 
   	 cent10 = restante / 100; 
   	 restante = restante % 100; 
   	 cent5 = restante / 50; 
   	 restante = restante % 50; 
   	 cent2 = restante / 20; 
   	 restante = restante % 20; 
   	 cent1 = restante / 10; 
   	   
   	 
   	 valor.setText("A pagar: " +
   	 		 "\n" + billete500 + " Billete/s de 500" + 
   			 "\n" + billete200 + " Billete/s de 200" + 
   			 "\n" + billete100 + " Billete/s de 100" +
   			 "\n" + billete50  + " Billete/s de 50"  +
   			 "\n" + billete20  + " Billete/s de 20"  + 
   			 "\n" + billete10  + " Billete/s de 10"  +
   			 "\n" + billete5   + " Billete/s de 5"   +
   			 "\n" + moneda2    + " Moneda/s de 2"    +
   			 "\n" + moneda1    + " Moneda/s de 1"    +
   			 "\n" + cent50 	   + " Moneda/s de 50cent" +
   			 "\n" + cent20	   + " Moneda/s de 20cent" +
   			 "\n" + cent10	   + " Moneda/s de 10cent" +
   			 "\n" + cent5      + " Moneda/s de 5cent" + 
   			 "\n" + cent2	   + " Moneda/s de 2cent" +
   			 "\n" + cent1	   + " Moneda/s de 1cent");
		
	}
}
