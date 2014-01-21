package com.example.transporte;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro extends Activity implements OnClickListener{
	public final static String MESSAGE = "Item Cadastrado.";
	private Button confirmar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro);
		confirmar = (Button) findViewById(R.id.button_confirmar);
		confirmar.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}

	public void onClick(View v){
		Intent intent = new Intent(this, ConfirmaCadastro.class);
		EditText editText = (EditText) findViewById(R.id.nome);
		String message = editText.getText().toString();
		intent.putExtra(MESSAGE, message);
		startActivity(intent);
    }
}
