package com.test.bartender.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.test.bartender.models.entity.Arreglos;

public interface IArregloService {

	static List<Integer> PRIMOS = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
			61, 67, 71, 73, 79, 83, 89, 97);

	public Optional<Arreglos> findById(Integer id);

	public String iteracionArray(Integer id, Integer iteraciones);

}
