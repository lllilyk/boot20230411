package com.example.demo.controller.domain;

import java.time.*;

import lombok.*;

@Data
public class Dto06 {
	public String title;
	public LocalDate published;
	public int price;
	public LocalDateTime updated;
	public Double weight;
}
