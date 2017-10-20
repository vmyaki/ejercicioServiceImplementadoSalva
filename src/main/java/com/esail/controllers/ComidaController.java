package com.esail.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.esail.model.Comestible;
import com.esail.model.Hamburguesa;

import com.esail.services.ComidaService;


@Controller
@RequestMapping("/pedir")
public class ComidaController {
	
	@Autowired //Crea un objeto cocina de la clase ComidaService
	private ComidaService cocina; //Creamos un atributo, para poder usar el service desde cualquier método, y no tener que crearlo
	
	@RequestMapping(value= {"","/", "/carta"}) //Si vamos a "/pedir/" o si vamos a "/pedir", funcionará igualmente, ya que si no, lo distingue
	public String pedir() {
		return "listadoComidas";
	}
	
	@RequestMapping(value="/hamburguesa")
	public String hamburguesa(Model model){
		
		//Devolvemos 1 hamburguesa, que es lo que nos han pedido (1 solo)
		Hamburguesa h = this.cocina.serviceHamburguesa();
		model.addAttribute("resultado", h);
		return "index";
	}
	
	//Hemos sustituido el envío de parámetros, haciéndolo todo a través de 
	//URL amigables, capturando los "parámetros" con @PathVariable
	@RequestMapping(value="/hamburguesa/{n}")
	public String hamburguesa(Model model,
			@PathVariable(name="n") Integer numero){
		
		//Devolvemos 1 hamburguesa, que es lo que nos han pedido
		model.addAttribute("resultado", this.cocina.serviceHamburguesa(numero));
		return "index";
	}
	
	
	@RequestMapping(value="/hotdog/{n}")
	public String hotdog(Model model,
			@PathVariable(name="n") Integer numero) {
		
		//Damos un hotdog, el que me entrega el servicio
		model.addAttribute("resultado", this.cocina.serviceHotdog(numero));
		return "index";
	}
	
	@RequestMapping(value="/hotdog")
	public String hotdog(Model model) {
		
		//Damos un hotdog, el que me entrega el servicio
		model.addAttribute("resultado", this.cocina.serviceHotdog() );		
		return "index";
	}
	
	@RequestMapping(value="/combo")
	public String combo5(Model model) {
		
		model.addAttribute("resultado", this.cocina.serviceComestible(5, 5));
		return "index";
	}
	
	@RequestMapping(value="/combo/{h}/{p}")
	public String combo(Model model,
			@PathVariable(name="h") Integer h, 
			@PathVariable(name="p") Integer p
			) {
		
		//Quitamos los posibles negativos que pongan en la url, para evitar a los listos
		h = Math.abs(h);
		p = Math.abs(p);
		
		List <Comestible> lista=this.cocina.serviceComestible(h,p);
		model.addAttribute("resultado", lista);
		model.addAttribute("precio",lista);
		return "index";
	}
	
	@RequestMapping(value="/menu/{n}")
	public String menu(Model model, @PathVariable(name="n") Integer numero) {
		
		//Llamamos al servicio Menú que nos devuelve una lista y por lo tanto lo metemos en una lista menú
		List <Comestible> menu = this.cocina.serviceMenu(1,1,2,2);
		
		//Enviamos al index
		model.addAttribute("resultado",menu);
		model.addAttribute("precio", this.cocina.servicePrecio(menu));
		
		
		return "index";
		
	}
	
	
	
	
	
}
