package com.zero.to.hero.java8_additional.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentSapient {
	 private int id;
     private String name;
	 private int score;
}
