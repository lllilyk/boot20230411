package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

import com.example.demo.controller.domain.*;

@Mapper
public interface Mapper05 {
	
	@Update("""
			UPDATE MyTable39
			SET Col2 = '수정된 값', 
				Col3 = 99999
			""")
	int sql01();
	
	@Update("""
			UPDATE MyTable39
			SET Col2 = #{val1},
				Col3 = #{val2}
			WHERE Col1 = #{key}
			""")
	int sql02(Integer key, String val1, Integer val2);

	@Update("""
			UPDATE Customers
			SET CustomerName = #{v1},
				Country = #{v2}
			WHERE CustomerID = #{id}
			""")
	int sql03(Integer id, String v1, String v2);

	@Update("""
			UPDATE Customers
			SET CustomerName = #{name},
				ContactName = #{contactName},
				Address = #{address},
				City = #{city},
				PostalCode = #{postalCode},
				Country = #{country}
			WHERE CustomerID = #{id}
			""")
	int sql04(Customer customer); 
	
	@Select("""
			SELECT CustomerId id,
				   CustomerName name,
				   ContactName,
				   Address,
				   City,
				   PostalCode,
				   Country
			FROM Customers
			WHERE CustomerId = #{id}
			""")
	Customer sql05(Integer id);

	//직원 조회
	@Select("""
			SELECT 
				EmployeeId AS id,
				LastName,
				FirstName,
				Notes,
				Photo,
				BirthDate birth
			FROM Employees
			WHERE EmployeeId = #{id}
			""")
	Employee sql06(Integer id);

	//직원 수정
	@Update("""
			UPDATE Employees
			SET 
				LastName = #{lastName},
				FirstName = #{firstName},
				Photo = #{photo},
				Notes = #{notes},
				BirthDate = #{birth}
			WHERE
				EmployeeId = #{id}
			""")
	int sql07(Employee employee);
	
}
