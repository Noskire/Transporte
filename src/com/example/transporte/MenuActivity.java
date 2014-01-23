package com.example.transporte;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class MenuActivity extends ListActivity{
	private ItemDAO datasource;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		datasource = new ItemDAO(this);
		datasource.open();
		
		List<Item> values = datasource.getAllComments();

		ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this,
		android.R.layout.simple_list_item_1, values);
		//adapter = (ArrayAdapter<Item>) getListAdapter();
		setListAdapter(adapter);
		
		// Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
	}
	
	@Override
	protected void onResume() {
		datasource.open();
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		datasource.close();
		super.onPause();
	}

	
	public void callCadastro(View v) {
		Intent i = new Intent(this, Cadastro.class);
		startActivity(i);
	}
}