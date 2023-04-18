package com.example.demo.controller.domain;

import lombok.*;

@Data
public class Customer {
	private int id;
	private String name;
	private String address;
	private String contactName;
	private String city;
	private String postalCode;
	private String country;
}
