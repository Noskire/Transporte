package com.example.transporte;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ItemDAO{
	private SQLiteDatabase db;
	private ItemDBHelper dbHelper;
	private String[] allColumns = {ItemContract.ItemEntry.COLUMN_ID, ItemContract.ItemEntry.COLUMN_NOME,
			ItemContract.ItemEntry.COLUMN_COMP, ItemContract.ItemEntry.COLUMN_LARG, ItemContract.ItemEntry.COLUMN_ALT,
			ItemContract.ItemEntry.COLUMN_PESO, ItemContract.ItemEntry.COLUMN_QUANT, ItemContract.ItemEntry.COLUMN_EST};
	
	public ItemDAO(Context context){
		dbHelper = new ItemDBHelper(context);
	}
	
	public void open() throws SQLException{
		db = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		dbHelper.close();
	}
	
	public boolean createItem(String nome, double comp, double larg, double alt, double peso, long quant, long est){
		ContentValues values = new ContentValues();
		values.put(ItemContract.ItemEntry.COLUMN_NOME, nome);
		values.put(ItemContract.ItemEntry.COLUMN_COMP, comp);
		values.put(ItemContract.ItemEntry.COLUMN_LARG, larg);
		values.put(ItemContract.ItemEntry.COLUMN_ALT, alt);
		values.put(ItemContract.ItemEntry.COLUMN_PESO, peso);
		values.put(ItemContract.ItemEntry.COLUMN_QUANT, quant);
		values.put(ItemContract.ItemEntry.COLUMN_EST, est);
		
		long insertId = db.insert(ItemContract.ItemEntry.TABLE_ITENS, null, values);
		return insertId != -1;
	}
	
	public void deleteItem(Item item){
		long id = item.getId();
		System.out.println("Comment deleted with id: " + id);
		db.delete(ItemContract.ItemEntry.TABLE_ITENS, (ItemContract.ItemEntry.COLUMN_ID + " = " + id), null);
	}
	
	public List<Item> getAllComments(){
		List<Item> itens = new ArrayList<Item>();
		Cursor cursor = db.query(ItemContract.ItemEntry.TABLE_ITENS, allColumns,
				null, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			Item item = cursorToItem(cursor);
			itens.add(item);
			cursor.moveToNext();
		}
		cursor.close();
		return itens;
	}
	
	private Item cursorToItem(Cursor cursor){
		Item item = new Item();
		item.setId(cursor.getLong(0));
		item.setNome(cursor.getString(1));
		item.setComp(cursor.getDouble(2));
		item.setLarg(cursor.getDouble(3));
		item.setAlt(cursor.getDouble(4));
		item.setPeso(cursor.getDouble(5));
		item.setQuant(cursor.getLong(6));
		item.setEstagio(cursor.getLong(7));
		
		return item;
	}
}
