package com.zero.to.hero.java8_additional.important;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateNumberInGivenList {
	public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,4,3,4,3,5,6);
        //way 1
        Set<Integer> reql1 = list.stream().filter(ele->Collections.frequency(list, ele)>1)
        								.collect(Collectors.toSet());
        System.out.println(reql1);
        
        //way 2
        Set<Integer> set=new HashSet<Integer>();
        list.stream().filter(p->!set.add(p)).collect(Collectors.toSet())
        			.forEach(System.out::println);
	}
}
