package com.esail.model;

import java.util.Random;

public class Hotdog implements Comestible{
	private String nombre;
	private boolean cebollaFrita;
	private boolean salsas;
	public String getNombre() {
		return nombre;
	}
	
	public Hotdog(String nombre, boolean cebollaFrita, boolean salsas) {
		this.nombre = nombre;
		this.cebollaFrita = cebollaFrita;
		this.salsas = salsas;
	}

	public Hotdog(String nombre) {
		Random r = new Random();
		this.nombre = nombre;
		this.cebollaFrita = r.nextBoolean();
		this.salsas = r.nextBoolean();
	}
	


	//Getters y Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isCebollaFrita() {
		return cebollaFrita;
	}
	public void setCebollaFrita(boolean cebollaFrita) {
		this.cebollaFrita = cebollaFrita;
	}
	public boolean isSalsas() {
		return salsas;
	}
	public void setSalsas(boolean salsas) {
		this.salsas = salsas;
	}

	@Override
	public String toString() {
		return "Hotdog [nombre=" + nombre + ", cebollaFrita=" + cebollaFrita + ", salsas=" + salsas + "]";
	}

	@Override
	public double getPrecio() {
		// TODO Auto-generated method stub
		return 0.50;
	}

	@Override
	public String comer() {
		// TODO Auto-generated method stub
		return "Ñam Ñam ->" + this.toString();
	}
	
	
	
	

}
