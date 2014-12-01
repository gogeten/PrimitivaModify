package fernandowirtz.primitiva;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class PreferenciasActivity extends Activity implements OnClickListener{
	
	private Button botonOk;
	private CheckBox chkGuardar;
	SharedPreferences prefer;
	boolean guardar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grabar_preferencias);
		
		botonOk = (Button)findViewById(R.id.btnOk);
		botonOk.setOnClickListener(this);
		
		chkGuardar = (CheckBox)findViewById(R.id.chkGuardar);
		guardar = getSharedPreferences("guardar", Context.MODE_PRIVATE).getBoolean("ok", false);
		
		if (guardar) {
			cargarCombinacion();
		}
	}

	@Override
	public void onClick(View v) {
		guardarCombinacion();
		this.finish();
		
	}
	
	private void guardarCombinacion() {
		prefer = getSharedPreferences("guardar", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefer.edit();
		
		if (chkGuardar.isChecked()) {
			editor.putBoolean("ok", true);
		}
		else {
			editor.putBoolean("ok", false);
		}
		editor.commit();
	}
	
	private void cargarCombinacion() {
		prefer = getSharedPreferences("guardar", Context.MODE_PRIVATE);
		guardar = prefer.getBoolean("ok", false);
		
		if (guardar) {
			chkGuardar.setChecked(true);
		}
		else {
			chkGuardar.setChecked(false);
		}
	}
}
