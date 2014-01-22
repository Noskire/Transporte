package com.example.transporte;

public class Item{
	private long id;
	private String nome;
	private double comp;
	private double larg;
	private double alt;
	private double peso;
	private long quant;
	
	public Item(){
		// TODO Auto-generated constructor stub
	}

	public Item(long id, String nome, double comp, double larg, double alt, double peso, long quant){
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nome = nome;
		this.comp = comp;
		this.larg = larg;
		this.alt = alt;
		this.peso = peso;
		this.quant = quant;
	}
	
	public long getId(){
		return this.id;
	}
	
	public void setId(long id){
		this.id = id;
	}

	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}

	public double getComp(){
		return this.comp;
	}
	
	public void setComp(double comp){
		this.comp = comp;
	}

	public double getLarg(){
		return this.larg;
	}
	
	public void setLarg(double larg){
		this.larg = larg;
	}

	public double getAlt(){
		return this.alt;
	}
	
	public void setAlt(double alt){
		this.alt = alt;
	}

	public double getPeso(){
		return this.peso;
	}
	
	public void setPeso(double peso){
		this.peso = peso;
	}

	public long getQuant(){
		return this.quant;
	}
	
	public void setQuant(long quant){
		this.quant = quant;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated constructor stub
		return (this.nome + ", " + this.comp + ", " + this.larg + ", " + this.alt
				 + ", " + this.peso + ", " + this.quant);
	}
}
