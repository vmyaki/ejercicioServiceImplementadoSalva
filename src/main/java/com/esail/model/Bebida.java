package com.esail.model;

public class Bebida implements Comestible {
	//Atributos
	private String nombre;
	
	//Constructores
	public Bebida(String nombre) {
		this.nombre = nombre;
	}

	//Métodos
	
	//Getters and Setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	@Override
	public double getPrecio() {
		return 1.5;
	}

	@Override
	public String comer() {
		//pendiente
		return null;
	}
	
	//ToString
	public String toString() {
		
		return "Bebida [nombre="+nombre+"]";
		
	}
	

}
