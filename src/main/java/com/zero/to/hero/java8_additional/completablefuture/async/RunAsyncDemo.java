package com.zero.to.hero.java8_additional.completablefuture.async;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zero.to.hero.java8_additional.completablefuture.dto.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RunAsyncDemo {
	
	//anonymous implementation of Runnable
	public Void saveEmployees(File jsonFile) throws InterruptedException, ExecutionException {
		ObjectMapper mapper = new ObjectMapper();
		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(new Runnable() {
			
			@Override
			public void run() {
				try {
					List<Employee> employees = mapper
							.readValue(jsonFile, new TypeReference<List<Employee>>() {
					});
					//write logic to save list of employee to database
					//repository.saveAll(employees)		
					System.out.println("Thread : "+Thread.currentThread().getName());
					//employees.stream().forEach(System.out::println);
					System.out.println("Total Employees : "+employees.size()); 
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		});
		return runAsyncFuture.get();
	}
	
	//converted to lambda
	public Void saveEmployeesWithCustomExecutor(File jsonFile) throws InterruptedException, ExecutionException {
		ObjectMapper mapper = new ObjectMapper();
		Executor executor =Executors.newFixedThreadPool(5);
		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(
				()-> {
				try {
					List<Employee> employees = mapper
							.readValue(jsonFile, new TypeReference<List<Employee>>() {
					});
					//write logic to save list of employee to database
					//repository.saveAll(employees)		
					System.out.println("Thread : "+Thread.currentThread().getName());
					System.out.println("Total Employees : "+employees.size()); 
				} catch (IOException e) {
					e.printStackTrace();
				} 
		}, executor);
		runAsyncFuture.toCompletableFuture();
		return runAsyncFuture.get();
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		RunAsyncDemo asyncDemo = new RunAsyncDemo();
		asyncDemo.saveEmployees(new File("employee.json"));
		asyncDemo.saveEmployeesWithCustomExecutor(new File("employee.json"));
	}
}
