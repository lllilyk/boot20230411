package com.example.demo.controller.domain;

import java.time.*;

import lombok.*;

@Data
public class Dto05 {
	private String name;
	private int age;
	private Double price;
	private LocalDate birth;
	private LocalDateTime inserted;
}
