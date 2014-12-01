package fernandowirtz.primitiva;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AcercaDe extends Activity implements OnClickListener{
	
	Button boton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acerca_de);
		
		boton = (Button)findViewById(R.id.btnAcercaDe);
		boton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		this.finish();
		
	}
}
