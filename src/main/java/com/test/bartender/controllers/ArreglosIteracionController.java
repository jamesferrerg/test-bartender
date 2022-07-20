package com.test.bartender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.test.bartender.services.IArregloService;

@RestController
@RequestMapping("/api")
public class ArreglosIteracionController {

	@Autowired
	private IArregloService arregloService;

	@GetMapping("/iteracion-arreglo/{arregloInput}")
	public ResponseEntity<?> bartender(@PathVariable Integer arregloInput, @RequestParam(value = "iteraciones") Integer iteraciones) {
		String resp = "{ \"Respuesta\": \"" + arregloService.iteracionArray(arregloInput, iteraciones) + "\" }";
		JsonObject jsonObject = new JsonParser().parse(resp).getAsJsonObject();
		return ResponseEntity.ok().body(jsonObject);
	}

}
