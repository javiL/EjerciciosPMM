package com.example.bdcentros;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Pantalla_centros extends Activity{
	
	private Centros[] centros;
	TextView txtCodigo;
	TextView txtNombre;
	TextView txtDireccion;
	Spinner spinnerCentros;
	
	class CentroAdapter extends ArrayAdapter<Centros>{
		Activity activity;
		CentroAdapter(Activity activityB) {
			super(activityB,R.layout.vista_spinner, centros);
			this.activity = activityB;
		}
		public View getDropDownView (int position, View convertView,ViewGroup parent){
			return getView(position, convertView, parent);
		}
		public View getView (int position, View convertView,ViewGroup parent){
			LayoutInflater InflaterSpinner = activity.getLayoutInflater();
			View item = InflaterSpinner.inflate(R.layout.vista_spinner, null);
			
			txtCodigo = (TextView)item.findViewById(R.id.SpCodigo);
			txtNombre = (TextView)item.findViewById(R.id.SpNombre);
			txtDireccion = (TextView)item.findViewById(R.id.SpDireccion);
			
			txtCodigo.setText(centros[position].getCodigoCentro());
			txtNombre.setText(centros[position].getNombreCentro());
			txtDireccion.setText(centros[position].getDir());
			
			return(item);
		}
	}
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantalla_consulta_centros);
		
		try{
			String[] c = new String[] {"cod_centro","nombre","direccion"};
			BDCentrosHelper BDCentros = new BDCentrosHelper(this, "BDCentros", null, 1);
			SQLiteDatabase bd = BDCentros.getReadableDatabase();
			
			Cursor cursor = bd.query("centros", c, null,null,null,null,null);
			
			centros = new Centros[cursor.getCount()+1];
			centros[0] = new Centros("Codigo del centro","Nombre del instituto","Direccion del instituto");
			
			int i = 1;
			if (cursor.moveToFirst()){
				do{
					String codigo = cursor.getString(0);
					String nombre = cursor.getString(1);
					String direccion = cursor.getString(2);
					
					centros[i] = new Centros(codigo,nombre,direccion);
					i++;
				}
				while (cursor.moveToNext());
			}
		}
		catch (Exception e){
			
		}
		
		spinnerCentros = (Spinner)findViewById(R.id.SpCentros);
		CentroAdapter adapter = new CentroAdapter(this);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerCentros.setAdapter(adapter);
	}
	
}
