package com.example.bdcentros;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BDCentrosHelper extends SQLiteOpenHelper{

	public BDCentrosHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, "BDCentros", factory, version);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void onCreate(SQLiteDatabase bd) {
		String tableCentros = "CREATE TABLE centros (" +
	                " cod_centro   SMALLINT NOT NULL," +
	                " tipo_centro  CHAR(1)," +
	                "nombre       VARCHAR(30)," +
	                "direccion    VARCHAR(26)," +
	                "telefono     VARCHAR(10)," +
	                "num_plazas   SMALLINT  UNSIGNED," +
	                " PRIMARY KEY (cod_centro) ) ;";
		String tablePersonal = "CREATE TABLE personal (" +
        		"cod_centro   SMALLINT NOT NULL," +
                "dni          INT UNSIGNED NOT NULL," +
                "apellidos    VARCHAR(30)," +
                "funcion      VARCHAR(15)," +
                "salario      FLOAT(7,2)," +
                "PRIMARY KEY (dni)," +
                "FOREIGN KEY (cod_centro) REFERENCES centros (cod_centro));";
		
		String tableProfesores = "CREATE TABLE profesores (" +
                "cod_centro   SMALLINT NOT NULL," +
                "dni          INT UNSIGNED NOT NULL," +
                "apellidos    VARCHAR(30)," +
                "especialidad VARCHAR(16)," +
                "PRIMARY KEY (dni)," +
                "FOREIGN KEY (dni) REFERENCES personal(dni)," +
                "FOREIGN KEY (cod_centro) REFERENCES centros (cod_centro));";
		
		
		bd.execSQL(tableCentros);
		
		bd.execSQL("INSERT INTO centros VALUES (10,'S','IES El Quijote','Avda. Los Molinos 25', '965-887654',538)");
        bd.execSQL("INSERT INTO centros VALUES (15,'P','CP Los Danzantes', 'C/Las Musas s/n','985-112322',250)");
        bd.execSQL("INSERT INTO centros VALUES (22,'S', 'IES Planeta Tierra', 'C/Mina 45','925-443400',300)");
        bd.execSQL("INSERT INTO centros VALUES (45,'P', 'CP Manuel Hidalgo', 'C/Granada 5','926-202310',220)");
        bd.execSQL("INSERT INTO centros VALUES (50,'S', 'IES Antoñete 1', 'C/Los Toreros 21','989-406090',310)");
        
        bd.execSQL(tablePersonal);
        
        bd.execSQL("INSERT INTO personal VALUES (10,4480099, 'Ruano Cerezo, Manuel','ADMINISTRATIVO', 1800.00)");
        bd.execSQL("INSERT INTO personal VALUES (15,1002345, 'Albarrán Serrano, Alicia', 'ADMINISTRATIVO', 1800.00)");
        bd.execSQL("INSERT INTO personal VALUES (15,7002660, 'Munyoz Rey, Felicia', 'ADMINISTRATIVO', 1800.00)");
        bd.execSQL("INSERT INTO personal VALUES (22,5502678, 'Marín Marn, Pedro', 'ADMINISTRATIVO', 1800.00)");
        bd.execSQL("INSERT INTO personal VALUES (22,6600980, 'Peinado Gil, Elena','CONSERJE', 1750.00)");
        bd.execSQL("INSERT INTO personal VALUES (45,4163222, 'Sarro Molina, Carmen','CONSERJE', 1750.00)");
        bd.execSQL("INSERT INTO personal VALUES (10,1112345,'Martnez Salas, Fernando',  'PROFESOR',2200.00)");
        bd.execSQL("INSERT INTO personal VALUES (10,4123005,'Bueno Zarco, Elisa', 'PROFESOR',2200.00)");
        bd.execSQL("INSERT INTO personal VALUES (10,4122025,'Montes Garca, M.Pilar', 'PROFESOR',2200.00)");
        bd.execSQL("INSERT INTO personal VALUES (15,9800990, 'Ramos Ruiz, Luis',     'PROFESOR',2050.00)");
        bd.execSQL("INSERT INTO personal VALUES (15,1112355,'Rivera Silvestre, Ana', 'PROFESOR',2050.00)");
        bd.execSQL("INSERT INTO personal VALUES (15,8660990, 'De Lucas Fdez, M.Angel',  'PROFESOR',2050.00)");
        bd.execSQL("INSERT INTO personal VALUES (22,7650000, 'Ruiz Lafuente, Manuel',  'PROFESOR',2200.00)");
        bd.execSQL("INSERT INTO personal VALUES (45,43526789, 'Serrano Lagua, María','PROFESOR',2050.00);");
		
        bd.execSQL(tableProfesores);
        
        bd.execSQL("INSERT INTO profesores VALUES (10,1112345,'Martínez Salas, Fernando',  'INFORMÁTICA')");
        bd.execSQL("INSERT INTO profesores VALUES (10,4123005,'Bueno Zarco, Elisa', 'MATEMÁTICAS')");
        bd.execSQL("INSERT INTO profesores VALUES (10,4122025,'Montes García, M.Pilar', 'MATEMÁTICAS')");
        bd.execSQL("INSERT INTO profesores VALUES (15,9800990, 'Ramos Ruiz, Luis',     'LENGUA')");
        bd.execSQL("INSERT INTO profesores VALUES (15,1112355,'Rivera Silvestre, Ana', 'DIBUJO')");
        bd.execSQL("INSERT INTO profesores VALUES (15,8660990, 'De Lucas Fdez, M.Angel',  'MATEMÁTICAS')");
        bd.execSQL("INSERT INTO profesores VALUES (22,7650000, 'Ruiz Lafuente, Manuel',  'MATEMÁTICAS')");
        bd.execSQL("INSERT INTO profesores VALUES (45,43526789, 'Serrano Laguía, María','INFORMÁTICA');");
	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
