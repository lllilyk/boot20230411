package com.example.demo.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.controller.domain.*;

@Mapper
public interface Mapper02 {
	
//  여러 레코드에 하나의 컬럼	
	@Select("""
			SELECT CustomerName FROM Customers
			""")
	List<String> sql01();
	
	@Select("""
			SELECT LastName FROM Employees
			""")
	List<String> sql02(); 
	
// 여러 레코드에 여러 컬럼		
	@Select("""
			SELECT LastName, FirstName
			FROM Employees
			""")
	List<Dto07> sql03(); 

	@Select("""
			SELECT ProductName, Price
			FROM Products
			""")
	List<Dto08> sql04();

	@Select("""
			SELECT ProductName
			FROM Products
			WHERE CategoryID = #{cid}
			""")
	List<String> sql05(Integer cid);
	
	@Select("""
			SELECT CustomerName
			FROM Customers
			WHERE Country = #{cty}
			""")
	List<String> sql06(String cty);
	
	@Select("""
			SELECT ProductName, Price
			FROM Products
			WHERE CategoryID = #{cid}
			""")
	List<Dto08> sql07(Integer cid);
	
}
