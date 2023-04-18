package com.example.demo.controller.domain;

import lombok.*;

@Data
public class Supplier {
	private String name;
	private String contactName;
	private String address;
	private String city;
	private int postalCode;
	private String country;
	private int phone;
}
