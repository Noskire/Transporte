package com.example.transporte;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VerItem extends Activity implements OnClickListener{
	private ItemDAO datasource;
	private Button confirmar;
	private int id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ver_item);
		confirmar = (Button) findViewById(R.id.button_confirmar);
		confirmar.setOnClickListener(this);
		

		Intent intent = getIntent();
		this.id = intent.getIntExtra(MenuActivity.ID, 0);
		datasource = new ItemDAO(this);
		datasource.open();
		List<Item> todos = datasource.getAllComments();
		ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this,
				android.R.layout.simple_list_item_1, todos);
		Item i = adapter.getItem(id);		
		TextView t = (TextView) findViewById(R.id.textView);
		t.setText(i.getNome());
		
		datasource.close();
		
	}

	public void onClick(View v){
		EditText editText = (EditText) findViewById(R.id.quant);
		String quant = editText.getText().toString();
		long lquant = 0;
		boolean ok = false;
		try{
			lquant = Integer.parseInt(quant);
			ok = true;
		} catch (Exception e) {
			CharSequence erro = "Verifique o dado";
			Toast torrada = Toast.makeText(this, erro, Toast.LENGTH_SHORT);
			torrada.show();
		}
		if (ok) {
	        datasource = new ItemDAO(this);
			datasource.open();
			
			List<Item> values = datasource.getAllComments();
	
			ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this,
			android.R.layout.simple_list_item_1, values);
			if(adapter.getItem(id).getEstagio() == 0){
				datasource.createItem(adapter.getItem(id).getNome(), adapter.getItem(id).getComp(), adapter.getItem(id).getLarg(),
					adapter.getItem(id).getAlt(), adapter.getItem(id).getPeso(), lquant, 1);
				datasource.deleteItem(adapter.getItem(id));
			}else if(adapter.getItem(id).getEstagio() == 1){
				if((adapter.getItem(id).getQuant() - lquant) == 0){
					datasource.createItem(adapter.getItem(id).getNome(), adapter.getItem(id).getComp(), adapter.getItem(id).getLarg(),
						adapter.getItem(id).getAlt(), adapter.getItem(id).getPeso(), lquant, 2);
					datasource.deleteItem(adapter.getItem(id));
				}else if((adapter.getItem(id).getQuant() - lquant) > 0){
					//Justifique
					datasource.createItem(adapter.getItem(id).getNome(), adapter.getItem(id).getComp(), adapter.getItem(id).getLarg(),
						adapter.getItem(id).getAlt(), adapter.getItem(id).getPeso(), (adapter.getItem(id).getQuant() - lquant), 2);
					datasource.deleteItem(adapter.getItem(id));
					Intent i = new Intent(this, Justifique.class);
					startActivityForResult(i, 0);
				}
			}
			datasource.close();
			setResult(RESULT_OK);
			finish();
		}
    }
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode == RESULT_OK){
			setResult(RESULT_OK);
			finish();
		}else{
			// faz nada =D
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ver_item, menu);
		return true;
	}

}
