package com.zero.to.hero.java8_additional.example;

import model.Person;
import model.StudentSapient;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertListToMapAndSortBasedOnKeyOrValue {

	public static void main(String[] args) {
		
		 List<Person> list1 = new ArrayList<>();
	        list1.add(new Person(100, "Mohan"));
	        list1.add(new Person(200, "Sohan"));
	        list1.add(new Person(300, "Mahesh"));
	        Map<Integer, String> map = list1.stream().collect(
	        								Collectors.toMap(Person::getId, Person::getName));
	        map.forEach((x, y) -> System.out.println("Key: " + x +", value: "+ y));
	        
	        
	        List<StudentSapient> list= Arrays.asList(new StudentSapient(5,"zrtt",16),
	                new StudentSapient(1,"raj",56),
	                new StudentSapient(2,"hansh",12),
	                new StudentSapient(3,"komal",34),
	                new StudentSapient(4,"raghu",45)
	                );
			
			System.out.println("Sorting Based on Key");
			list.stream()
				.collect(Collectors.toMap(StudentSapient::getName, StudentSapient::getScore))
						.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList())
								.forEach(System.out::println);
			
			System.out.println("Sorting Based on Value");
			list.stream()
			.collect(Collectors.toMap(StudentSapient::getName, StudentSapient::getScore))
					.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList())
							.forEach(System.out::println);
			
			System.out.println("---------");
			list.stream().sorted(Comparator.comparing(StudentSapient::getScore)).collect(Collectors.toMap(StudentSapient::getName, StudentSapient::getScore)).entrySet().forEach(System.out::print);
		}					
	}
