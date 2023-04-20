package com.example.demo.controller.domain;

import java.time.*;

import lombok.*;

@Data
public class Ppong {
	private Integer number;
	private LocalDate sdate;
	private LocalDateTime trip;
	private String school;
	private Double scoreAvg;
}
