package com.esail.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.esail.model.Bebida;
import com.esail.model.Comestible;
import com.esail.model.Hamburguesa;
import com.esail.model.Hotdog;
import com.esail.model.Patata;

@Service
public class ComidaServiceImpl implements ComidaService {

	@Override
	public Hamburguesa serviceHamburguesa() {
		return new Hamburguesa("Hamburguesa desde service");
	}

	@Override
	public Hotdog serviceHotdog() {
		return new Hotdog("Hotdog desde service");
	}

	@Override
	public List<Hamburguesa> serviceHamburguesa(int cantidad) {
		List<Hamburguesa> lista = new ArrayList<Hamburguesa>();
		
		//Por ejemplo, podemos "controlar" el número de hamburguesas que podemos dar a la vez 
		if (cantidad <=0) {
			cantidad = Math.abs(cantidad);
		}
		if (cantidad >10) {
			cantidad = 10; //Si pide más de 10, lo capamos a 10, ya que no caben más hamburguesas a la vez en la parrilla
		}
		
		//Creamos las hamburguesas definidas
		for (int i=1; i<=cantidad; i++) {
			lista.add(new Hamburguesa("Nº" + i));
		}

		return lista;
	}

	@Override
	public List<Hotdog> serviceHotdog(int cantidad) {
		List<Hotdog> lista = new ArrayList<Hotdog>();
		
		//Así controlamos que no pongan un negativo
		cantidad = Math.abs(cantidad);
		
		//Y como nuestra máquina de perritos no puede hacer más de 20 a la vez, lo limitamos
		if (cantidad > 20) cantidad = 20;
		
		//Hacemos tantos perritos como manden
		for (int i=1 ; i<=cantidad; i++) {
			lista.add(new Hotdog("Nº" + i));
		}
		
		return lista;
	}

	@Override
	public List<Comestible> serviceComestible(int numeroHamburguesas, int numeroPerritos) {
		List<Comestible> lista = new ArrayList<Comestible>();
		
		//TODO comprobar el número máximo de hamburguesas y perritos simultáneos
		//Creamos tantas hamburguesas y perritos como nos pidan, y los añadimos a la lista
		for (int i=1; i<=numeroHamburguesas;i++ ) {
			lista.add(new Hamburguesa("Nº " + i));
		}
		for (int i=1; i<=numeroPerritos;i++ ) {
			lista.add(new Hotdog("Nº " + i));
		}
		
		return lista;
	}

	@Override
	public double servicePrecio(List<Comestible> lista) {
		double precio=0;
		
		for(Comestible c: lista) {
			
			precio+=c.getPrecio();
		}
		return precio;
	}
	
	public Patata servicePatata() { //Devuelve 1 patata
		return new Patata("Patata normales");
	}
	
	public Bebida serviceBebida() { //Devuelve 1 bebida
		return new Bebida ("Agua");
	}

	@Override
	public List<Comestible> serviceMenu(int burger, int hotdog, int chips, int drinks) {
		
		List<Comestible> lista= null; //Inicializamos la lista
		
		//Partimos de una lista con perritos y hamburguesas aprovechando el service
		lista=this.serviceComestible(burger,hotdog);
				
		for(int i=1; i<=chips; i++) {
			
			lista.add(this.servicePatata());
		}
		
		for(int i=1; i<=drinks; i++) {
			
			lista.add(this.serviceBebida());
		}
				
		return lista;
	}
	

	
}
