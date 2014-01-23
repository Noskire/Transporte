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
		long lquant = Integer.parseInt(quant.equals("")?"0":quant);

        datasource = new ItemDAO(this);
		datasource.open();
		
		List<Item> values = datasource.getAllComments();

		ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this,
		android.R.layout.simple_list_item_1, values);
		//adapter = (ArrayAdapter<Item>) getListAdapter();
		//setListAdapter(adapter);

		adapter.getItem(id).setQuant(lquant);
		adapter.notifyDataSetChanged();
		
		datasource.close();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ver_item, menu);
		return true;
	}

}
