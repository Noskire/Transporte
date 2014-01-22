package com.example.transporte;

import com.example.transporte.ItemContract.ItemEntry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ItemDBHelper extends SQLiteOpenHelper{
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "item.db";
	private static final String TEXT_TYPE = " TEXT";
	private static final String INTEGER_TYPE = " INTEGER";
	private static final String DOUBLE_TYPE = " DOUBLE";
	private static final String COMMA_SEP = ",";
	
	private static final String SQL_CREATE_ENTRIES =
			"CREATE TABLE " + ItemEntry.TABLE_ITENS + " ( " +
			ItemEntry.COLUMN_ID + " " + INTEGER_TYPE + " PRIMARY KEY " + COMMA_SEP +
			ItemEntry.COLUMN_NOME + " " + TEXT_TYPE + " " + COMMA_SEP +
			ItemEntry.COLUMN_COMP + " " + DOUBLE_TYPE + " " + COMMA_SEP +
			ItemEntry.COLUMN_LARG + " " + DOUBLE_TYPE + " " + COMMA_SEP +
			ItemEntry.COLUMN_ALT + " " + DOUBLE_TYPE + " " + COMMA_SEP +
			ItemEntry.COLUMN_PESO + " " + DOUBLE_TYPE + " " + COMMA_SEP +
			ItemEntry.COLUMN_QUANT + " " + INTEGER_TYPE + " )";

	private static final String SQL_DELETE_ENTRIES =
			"DROP TABLE IF EXISTS " + ItemEntry.TABLE_ITENS;
	
	public ItemDBHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL(SQL_CREATE_ENTRIES);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		db.execSQL(SQL_DELETE_ENTRIES);
		onCreate(db);
	}
}