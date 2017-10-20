package com.esail.model;

public class Patata implements Comestible{
	//Atributos
	private String nombre;
	
	//Constructores
	public Patata (String nombre) {
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
	
	//Métodos obligatorios de la interfaz
	@Override
		public double getPrecio() {
			return 1;
		}
	
	@Override
		public String comer() {
			//pendiente
			return null;
		}
		
		//ToString
		public String toString() {
			
			return "Patata [nombre="+nombre+"]";
			
		}

}
