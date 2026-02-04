package com.zero.to.hero.java8_additional.completablefuture.async;

import com.zero.to.hero.java8_additional.completablefuture.database.EmployeeDatabase;
import com.zero.to.hero.java8_additional.completablefuture.dto.Employee;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SupplyAsyncDemo {
	public List<Employee> getEmployees() throws InterruptedException, ExecutionException{
		Executor executor = Executors.newCachedThreadPool();
		CompletableFuture<List<Employee>> listCompletableFuture = CompletableFuture
				.supplyAsync(()->{
					System.out.println("Executed By : "+Thread.currentThread().getName());
		   return EmployeeDatabase.fetchEmployee();
		}, executor);
		
		return listCompletableFuture.get(); 
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SupplyAsyncDemo supplyAsyncDemo = new SupplyAsyncDemo();
		List<Employee> employees = supplyAsyncDemo.getEmployees();
		employees.stream().forEach(System.out::println);
	}
}
