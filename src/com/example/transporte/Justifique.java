package com.example.transporte;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Justifique extends Activity implements OnClickListener{
	private Button confirmar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_justifique);
		confirmar = (Button) findViewById(R.id.button_confirmar);
		confirmar.setOnClickListener(this);

		TextView t = (TextView) findViewById(R.id.textView);
		t.setText("Falta(m) item(ns). Justifique:");
	}

	public void onClick(View v){
		EditText editText = (EditText) findViewById(R.id.quant);
		String just = editText.getText().toString();
		just.compareTo("");
		setResult(RESULT_OK);
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.justifique, menu);
		return true;
	}

}
