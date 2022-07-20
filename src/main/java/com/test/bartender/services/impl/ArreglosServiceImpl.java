package com.test.bartender.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.bartender.models.entity.Arreglos;
import com.test.bartender.models.repository.IArreglosRepository;
import com.test.bartender.services.IArregloService;

@Service
public class ArreglosServiceImpl implements IArregloService {

	@Autowired
	private IArreglosRepository arregloRepository;

	@Override
	@Transactional(readOnly = true)
	public Optional<Arreglos> findById(Integer id) {

		return arregloRepository.findById(id);
	}

	@Override
	public String iteracionArray(Integer id, Integer iteraciones) {

		String respuestaString = null;

		try {
			String unArreglo = findById(id).get().getInputArray();
			String[] unArregloSplit = unArreglo.split(",");
			List<String> lista = new ArrayList<String>(Arrays.asList(unArregloSplit));

			List<Integer> listaInt = lista.stream().map(st -> Integer.parseInt(st)).collect(Collectors.toList());

			List<Integer> a, b, respuesta = new ArrayList<Integer>();

			for (int i = 0; i < iteraciones; i++) {
				Integer n = PRIMOS.get(i);
				b = listaInt.stream().filter(div -> div % n == 0).collect(Collectors.toList());
				a = listaInt.stream().filter(div -> div % n != 0).collect(Collectors.toList());
				listaInt.clear();
				listaInt.addAll(a);
				respuesta.addAll(b);
				if ((iteraciones - 1) == i) {
					respuesta.addAll(a);
				}

			}

			respuestaString = String.valueOf(respuesta).replace("[", "").replace("]", "");

			return respuestaString;
		
		} catch (NoSuchElementException ex) {
			respuestaString = "Error: " + ex.getMessage();
			return respuestaString;
		}

	}

}
