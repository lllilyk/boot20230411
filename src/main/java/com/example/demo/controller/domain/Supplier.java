package com.example.demo.controller.domain;

import java.util.*;

import lombok.*;

@Data
public class Supplier {
	private int id;
	private String name;
	private String contactName;
	private String address;
	private String city;
	private String country;
	private String postalCode;
	private String phone;
	
	private List<Product> products;
}
