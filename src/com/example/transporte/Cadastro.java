package com.example.transporte;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends Activity implements OnClickListener {
	public final static String MESSAGE = "MESSAGE";
	public final static String COMP = "COMP";
	public final static String LARG = "LARG";
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

	public void onClick(View v) {

		EditText editText = (EditText) findViewById(R.id.nome);
		String nome = editText.getText().toString();

		editText = (EditText) findViewById(R.id.comp);
		String comp = editText.getText().toString();

		editText = (EditText) findViewById(R.id.larg);
		String larg = editText.getText().toString();

		editText = (EditText) findViewById(R.id.alt);
		String alt = editText.getText().toString();

		editText = (EditText) findViewById(R.id.peso);
		String peso = editText.getText().toString();

		editText = (EditText) findViewById(R.id.quant);
		String quant = editText.getText().toString();

		Double dcomp = .0, dlarg = .0, dalt = .0, dpeso = .0;
		int iquant = 0;
		boolean ok = false;

		try {
			dcomp = Double.parseDouble(comp);
			dlarg = Double.parseDouble(larg);
			dalt = Double.parseDouble(alt);
			dpeso = Double.parseDouble(peso);
			iquant = Integer.parseInt(quant);
			ok = true;
		} catch (Exception e) {
			CharSequence erro = "Verifique os dados";
			Toast torrada = Toast.makeText(this, erro, Toast.LENGTH_SHORT);
			torrada.show();
		}
		if (ok) {
			ItemDAO data = new ItemDAO(this);
			data.open();
			boolean adicionou = data.createItem(nome, dcomp, dlarg, dalt,
					dpeso, iquant);
			if (adicionou) {
				setResult(RESULT_OK);
				finish();
			}
		}

	}
}
