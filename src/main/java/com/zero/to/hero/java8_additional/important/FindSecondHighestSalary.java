package com.zero.to.hero.java8_additional.important;
import model.Employee1;
import model.EmployeeDatabase;

import java.util.Comparator;
import java.util.stream.Collectors;

public class FindSecondHighestSalary {

	public static void main(String[] args) {
		String empName = EmployeeDatabase.getEmployees().stream()
				.sorted(Comparator.comparing(Employee1::getSalary).reversed())
			     .collect(Collectors.toList()).get(1).getName();
		System.out.println(empName);
	}

}
