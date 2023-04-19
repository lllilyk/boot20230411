package com.example.demo.controller.domain;

import lombok.*;

@Data
public class Employee {
	private int id;
	private String lastName;
	private String firstName;
	private String birthDate;
	private String photo;
	private String notes;
}
