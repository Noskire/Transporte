package com.example.transporte;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ConfirmaCadastro extends ListActivity {
	private ItemDAO datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirma_cadastro);
		
        datasource = new ItemDAO(this);
		datasource.open();
		
		List<Item> values = datasource.getAllComments();

		ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this,
		android.R.layout.simple_list_item_1, values);
		//adapter = (ArrayAdapter<Item>) getListAdapter();
		setListAdapter(adapter);

		Intent intent = getIntent();
		String nome = intent.getStringExtra(Cadastro.MESSAGE);
		String comp = intent.getStringExtra(Cadastro.COMP);
		double dcomp = Double.parseDouble(comp.equals("")?"0":comp);
		String larg = intent.getStringExtra(Cadastro.LARG);
		double dlarg = Double.parseDouble(larg.equals("")?"0":larg);
		String alt = intent.getStringExtra(Cadastro.ALT);
		double dalt = Double.parseDouble(alt.equals("")?"0":alt);
		String peso = intent.getStringExtra(Cadastro.PESO);
		double dpeso = Double.parseDouble(peso.equals("")?"0":peso);
		String quant = intent.getStringExtra(Cadastro.QUANT);
		long lquant = Integer.parseInt(quant.equals("")?"0":quant);
		long lest = 0;
		
		/*TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText(nome + " / " + dcomp + " / " + dlarg + " / " + dalt
	    		 + " / " + dpeso + " / " + lquant);
	    setContentView(textView);*/

		//ArrayAdapter<Item> adapter = (ArrayAdapter<Item>) getListAdapter();
		Item item = null;
		item = datasource.createItem(nome, dcomp, dlarg, dalt, dpeso, lquant, lest);
		adapter.add(item);
		adapter.notifyDataSetChanged();
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
}