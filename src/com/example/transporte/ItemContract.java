package com.example.transporte;

public final class ItemContract{
	public ItemContract(){
		// TODO Auto-generated constructor stub
	}

	public static abstract class ItemEntry{
		public static final String TABLE_ITENS = "itens";
		public static final String COLUMN_ID = "id";
		public static final String COLUMN_NOME = "nome";
		public static final String COLUMN_COMP = "comprimento";
		public static final String COLUMN_LARG = "largura";
		public static final String COLUMN_ALT = "altura";
		public static final String COLUMN_PESO = "peso";
		public static final String COLUMN_QUANT = "quantidade";
	}
}