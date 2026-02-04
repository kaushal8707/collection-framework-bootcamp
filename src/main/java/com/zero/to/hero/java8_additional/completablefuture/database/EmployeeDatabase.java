package com.zero.to.hero.java8_additional.completablefuture.database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zero.to.hero.java8_additional.completablefuture.dto.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EmployeeDatabase {

	public static List<Employee> fetchEmployee(){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper
					.readValue(new File("employee.json"), new TypeReference<List<Employee>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; 
	}
}
