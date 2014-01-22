package com.example.transporte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro extends Activity implements OnClickListener{
	public final static String MESSAGE = "MESSAGE";
	public final static String COMP = "COMP";
	public final static String LARG ="LARG";
	public final static String ALT = "ALT";
	public final static String PESO = "PESO";
	public final static String QUANT = "QUANT";
	private Button confirmar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro);
		confirmar = (Button) findViewById(R.id.button_confirmar);
		confirmar.setOnClickListener(this);
	}

	public void onClick(View v){
		Intent intent = new Intent(this, ConfirmaCadastro.class);
		EditText editText = (EditText) findViewById(R.id.nome);
		String message = editText.getText().toString();
		intent.putExtra(MESSAGE, message);
		
		editText = (EditText) findViewById(R.id.comp);
		message = editText.getText().toString();
		intent.putExtra(COMP, message);
		
		editText = (EditText) findViewById(R.id.larg);
		message = editText.getText().toString();
		intent.putExtra(LARG, message);
		
		editText = (EditText) findViewById(R.id.alt);
		message = editText.getText().toString();
		intent.putExtra(ALT, message);
		
		editText = (EditText) findViewById(R.id.peso);
		message = editText.getText().toString();
		intent.putExtra(PESO, message);
		
		editText = (EditText) findViewById(R.id.quant);
		message = editText.getText().toString();
		intent.putExtra(QUANT, message);
		
		startActivity(intent);
    }
}
