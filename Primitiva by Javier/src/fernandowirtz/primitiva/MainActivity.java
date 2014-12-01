package fernandowirtz.primitiva;

import java.util.ArrayList;

import org.w3c.dom.Text;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 
 * @author Javier
 *@startuml
 *MainActivity -> Primitiva : llama a el método mostrarResultado
 *MainActivity <-- Primitiva :devuelve combinación
 *note left:muestra combinación
 *Preferencias <- MainActivity : llama a guardarCombinacion
 *note right: guarda combinación si el usuario lo desea
 *MainActivity -> AcercaDe: muestra info sobre autor
 *
 *@enduml
 */

public class MainActivity extends Activity implements OnClickListener{
	
	private ImageView image;
	private ArrayList<TextView> listaEditText = new ArrayList<>();
	private Primitiva primitiva;
	private SharedPreferences prefer;
	private boolean guardar;
	private int []combinacion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		image = (ImageView)findViewById(R.id.botonPlay);
		image.setOnClickListener(this);
		
		
		guardar = getSharedPreferences("guardar", Context.MODE_PRIVATE).getBoolean("ok", false);
		
		obtenerTextView();
		
		if (guardar) {
			cargarArray();
		}
		
		//mostarPreferencias();
			
	}

	private void obtenerTextView() {
		TextView t1 = (TextView)findViewById(R.id.textbola1);
		TextView t2 = (TextView)findViewById(R.id.textbola2);
		TextView t3 = (TextView)findViewById(R.id.textbola3);
		TextView t4 = (TextView)findViewById(R.id.textbola4);
		TextView t5 = (TextView)findViewById(R.id.textbola5);
		TextView t6 = (TextView)findViewById(R.id.textbola6);
		listaEditText.add(t1);
		listaEditText.add(t2);
		listaEditText.add(t3);
		listaEditText.add(t4);
		listaEditText.add(t5);
		listaEditText.add(t6);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflate = getMenuInflater();
		inflate.inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.preferencias: {
			Intent i = new Intent(this, PreferenciasActivity.class);
			startActivity(i);
			break;			
		}
		case R.id.acercaDe: {
			Intent i = new Intent(this, AcercaDe.class);
			startActivity(i);
			break;			
		}
		}
		return super.onOptionsItemSelected(item);
	}
	
	

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (guardar) {
			guardarArray();
		}
	}

	@Override
	public void onClick(View v) {
			mostrarCombinacion();
	}
	
	private void mostrarCombinacion(){
		int pos = 0;
		primitiva = new Primitiva();
		combinacion = primitiva.getCombinacion();
		
		for (TextView t : listaEditText) {
			t.setText(""+combinacion[pos]);
			pos++;
		}
	}
	
	public void cargarArray () {
		prefer = getSharedPreferences("combinacion", 0);
		for (int i = 0; i < listaEditText.size(); i++) {
			listaEditText.get(i).setText(prefer.getString("texto" +i, "?"));
		}
	}
	
	public void guardarArray() {
		prefer = getSharedPreferences("combinacion", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefer.edit(); 

		for (int i = 0; i < listaEditText.size(); i++) {
			editor.putString("texto"+i, listaEditText.get(i).getText().toString());
		}
		editor.commit();
	}
	
}
