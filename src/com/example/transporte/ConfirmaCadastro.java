package com.example.transporte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmaCadastro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirma_cadastro);
		
		Intent intent = getIntent();
		String message = intent.getStringExtra(Cadastro.MESSAGE);
		String comp = intent.getStringExtra(Cadastro.COMP);
		String larg = intent.getStringExtra(Cadastro.LARG);
		String alt = intent.getStringExtra(Cadastro.ALT);
		String peso = intent.getStringExtra(Cadastro.PESO);
		String quant = intent.getStringExtra(Cadastro.QUANT);
		
		TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText(message + " / " + comp + " / " + larg + " / " + alt
	    		 + " / " + peso + " / " + quant);
	    setContentView(textView);
	}

	

}
