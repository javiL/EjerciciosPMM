package com.example.barraprogreso;

import com.example.pruebabarra.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	Button BtnDescarga;
	ProgressDialog barraProgreso;
	private int estadoBarraProgreso = 0;
	private Handler handlerBarraProgreso = new Handler();

	private long tamañoDescarga = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addListenerOnButton();

	}

	public void addListenerOnButton() {

		BtnDescarga = (Button) findViewById(R.id.BotonDescarga);
		BtnDescarga.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// algunas opciones de la barra de progreso
				barraProgreso = new ProgressDialog(v.getContext());
				barraProgreso.setCancelable(true);
				barraProgreso.setMessage("Descargando...");
				barraProgreso.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				barraProgreso.setProgress(0);
				barraProgreso.setMax(100);
				barraProgreso.show();

				//reinicio del estado de la barra del progreso
				estadoBarraProgreso = 0;
				
				//tamaño de la descarga simulada
				tamañoDescarga = 0;
				
				new Thread(new Runnable() {
					public void run() {
						while (estadoBarraProgreso < 100) {

							// simula que hacemos algo
							estadoBarraProgreso = Simulador();

							// Dormir 1 segundo
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							// Actualizamos la barra de progreso
							handlerBarraProgreso.post(new Runnable() {
								public void run() {
									barraProgreso.setProgress(estadoBarraProgreso);
								}
							});
						}

						// Se ha completado la descarga
						if (estadoBarraProgreso >= 100) {

							// dormir 2 segundos
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							// cierra la barra de progreso cuando se ha acabado
							barraProgreso.dismiss();
						}
					}
				}).start();

			}

		});

	}

	

	// simula que estamos descargando un fichero
	public int Simulador() {

		while (tamañoDescarga <= 1000000) {

			tamañoDescarga++;

			if (tamañoDescarga == 100000) {
				return 10;
			} else if (tamañoDescarga == 200000) {
				return 20;
			} else if (tamañoDescarga == 300000) {
				return 30;
			} else if (tamañoDescarga == 500000) {
				return 50;
			} else if (tamañoDescarga == 900000) {
				return 90;
			}
			

		}

		return 100;

	}

}
