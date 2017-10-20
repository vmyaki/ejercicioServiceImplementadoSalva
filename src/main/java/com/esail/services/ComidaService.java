package com.esail.services;

import java.util.List;


import com.esail.model.Comestible;
import com.esail.model.Hamburguesa;
import com.esail.model.Hotdog;


public interface ComidaService {
	final int COMIDA_HOTDOG = 1;
	final int COMIDA_HAMBURGUESA = 2;
	
	public Hamburguesa serviceHamburguesa() ;
	public List<Hamburguesa> serviceHamburguesa(int cantidad);
	
	public Hotdog serviceHotdog();
	public List<Hotdog> serviceHotdog(int cantidad);
	
	public List<Comestible> serviceComestible(int numeroHamburguesas, int numeroPerritos);
	
	public double servicePrecio(List<Comestible> lista);
	
	public List<Comestible> serviceMenu(int burger, int hotdog, int chips, int drinks);
	
}
