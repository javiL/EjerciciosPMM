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

public class Pantalla_personal extends Activity{
	private Personal[] personal;
	
	TextView txtCodigo;
	TextView txtDNI;
	TextView txtApellidos;
	Spinner spinnerPersonal;
	
	class PersonalAdapter extends ArrayAdapter<Personal>{
		Activity activity;
		public PersonalAdapter(Activity activityB) {
			super(activityB,R.layout.vista_spinner_personal, personal);
			this.activity = activityB;
		}
		public View getDropDownView (int position, View convertView,ViewGroup parent){
			return getView(position, convertView, parent);
		}
		public View getView (int position, View convertView,ViewGroup parent){
			LayoutInflater InflaterSpinner = activity.getLayoutInflater();
			View item = InflaterSpinner.inflate(R.layout.vista_spinner_personal, null);
			
			txtCodigo = (TextView)item.findViewById(R.id.SpCodigo2);
			txtDNI = (TextView)item.findViewById(R.id.SpDNI);
			txtApellidos = (TextView)item.findViewById(R.id.SpApellidos);
			
			txtCodigo.setText(personal[position].getCodigoCentro());
			txtDNI.setText(personal[position].getDNI());
			txtApellidos.setText(personal[position].getApellidos());
			
			return (item);
		}
	}
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantalla_consulta_personal);
		
		try{
			String[] c = new String[] {"cod_centro","dni","apellidos"};
			BDCentrosHelper BDCentros = new BDCentrosHelper(this, "BDCentros", null, 1);
			SQLiteDatabase bd = BDCentros.getReadableDatabase();
			
			Cursor cursor = bd.query("personal",c,null,null,null,null,null);
			personal = new Personal[cursor.getCount()+1];
			personal[0] = new Personal("Codigo del centro del personal","DNI de la persona","Apellidos de la persona,Nombre");
			
			int j = 1;
			if (cursor.moveToFirst()){
				do {
					String codigo = cursor.getString(0);
					String dni = cursor.getString(1);
					String direccion = cursor.getString(2);
					
					personal[j] = new Personal(codigo,dni,direccion);
					j++;
				}
				while (cursor.moveToNext());
			}
		}
		catch(Exception e){
			
		}
		
		spinnerPersonal = (Spinner)findViewById(R.id.SpPersonal);
		PersonalAdapter adapter = new PersonalAdapter(this);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerPersonal.setAdapter(adapter);
	}
}