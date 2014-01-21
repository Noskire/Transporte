package com.example.transporte;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ConfirmaCadastro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirma_cadastro);
		
		Intent intent = getIntent();
		String message = intent.getStringExtra(Cadastro.MESSAGE);
		
		TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText(message);
	    setContentView(textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.confirma_cadastro, menu);
		return true;
	}

}
