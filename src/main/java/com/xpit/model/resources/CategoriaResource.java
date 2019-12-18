package com.xpit.model.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//endereço do endpoint REST 
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	// requisicao basica Get
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "Rest está funcionando";
	}

}
