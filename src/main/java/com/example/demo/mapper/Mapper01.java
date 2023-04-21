package com.example.demo.mapper;

import java.time.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.controller.domain.*;

@Mapper
public interface Mapper01 {
	
	@Select("""
			SELECT EmployeeID
			FROM Employees
			WHERE LastName = 'LEE'
			""")
	Integer method00();
	
	// 인터페이스에서 만드는 메소드는 모두 추상메소드이므로 public 생략 가능
	@Select("""
			SELECT CustomerName
			FROM Customers
			WHERE CustomerID = 1
			""")
	//rs.getString(" ") 이런식으로 가져올거니까 void가 아니라 리턴타입을 String 으로 명시해주기
	String method01();
	
	
	@Select("""
			SELECT FirstName
			FROM Employees
			WHERE EmployeeID = 1
			""")
	
	String method02();
	
	@Select("""
			SELECT SupplierName
			FROM Suppliers
			WHERE SupplierId = 1		
			""")
	String method03();
	
	
	@Select("""
			SELECT CustomerName
			FROM Customers
			WHERE CustomerID = #{id}
			""")
	String method04(Integer id);
	
	
	@Select("""
			SELECT CustomerID
			FROM Customers
			WHERE  CustomerName = #{name}
			""")
	int method44(String name);
	
	@Select("""
			SELECT LastName
			FROM Employees
			WHERE EmployeeID = #{id}
			""")
	String method05(Integer id);
	
	@Select("""
			SELECT Price
			FROM MyTable33
			LIMIT 1
			""")
	Integer method06();
	
	@Select("""
			SELECT Weight
			FROM MyTable33
			LIMIT 1
			""")
	Double method07();
	
	@Select("""
			SELECT Published
			FROM MyTable33
			LIMIT 1
			""")
	LocalDate method08();

	@Select("""
			SELECT Updated
			FROM MyTable33
			LIMIT 1
			""")
	LocalDateTime method09();
	
	@Select("""
			SELECT Title,
				   Published,
				   Price,
				   Updated,
				   Weight
			FROM MyTable33
			LIMIT 1
			""")
	// 컬럼명과 (대소문자 구분없이) 매치되는 빈의 프로퍼티명
	Dto06 method10();
	
	@Select("""
			SELECT Name,
				   Age,
				   Price,
				   Birth,
				   Inserted
			FROM MyTable32
			LIMIT 1
			""")
	Dto05 method11();
	//bean에 해당하는 property(ex.inserted)가 없어도 괜찮음 
	//값을 넣어주지 않는 것 뿐
	
	@Select("""
			SELECT CustomerId AS id,
				   CustomerName AS name,
				   ContactName,
				   Address,
				   City,
				   PostalCode,
				   Country
			FROM Customers
			WHERE CustomerID = 7
			""")
	Customer method12();
	
	@Select("""
			SELECT SupplierID id,
				   SupplierName name,
				   ContactName,
				   Address,
				   City,
				   PostalCode,
				   Country,
				   Phone
			FROM Suppliers
			WHERE SupplierID = 2
			""")
	Supplier method13();
	
	@Select("""
			SELECT EmployeeID id,
				   LastName,
				   FirstName,
				   BirthDate birth,
				   Photo,
				   Notes
			FROM Employees
			WHERE EmployeeID = 5
			""")
	Employee method14();
}

