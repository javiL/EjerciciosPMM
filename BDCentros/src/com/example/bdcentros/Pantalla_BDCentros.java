package com.example.bdcentros;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Pantalla_BDCentros extends Activity {
	Button BtnCentros;
	Button BtnPersonal;
	Button BtnProfesores;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pantalla__bdcentros);
		
		BtnCentros = (Button)findViewById(R.id.BtnCentros);
		BtnPersonal = (Button)findViewById(R.id.BtnPersonal);
		BtnProfesores = (Button)findViewById(R.id.BtnProfesores);
		
		BtnCentros.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent IrCentros = new Intent(Pantalla_BDCentros.this, Pantalla_centros.class);
				
				startActivity(IrCentros);
			}
		});
		
		BtnPersonal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent IrPersonal = new Intent(Pantalla_BDCentros.this,Pantalla_personal.class);
				
				startActivity(IrPersonal);
			}
		});
		
/*/		BtnProfesores.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent IrProfesores = new Intent (Pantalla_BDCentros.this,Pantalla_profesores.class);
				
				startActivity(IrProfesores);
			}
		});
/*/		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pantalla__bdcentros, menu);
		return true;
	}

}
