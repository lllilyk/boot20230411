package com.example.demo.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.controller.domain.*;

@Mapper
public interface Mapper07 {
	// dynamicSQL을 사용하고 싶으면 꼭 script 태그로 감싸주기!
	@Select("""
			<script>
			<bind name="pattern" value="'%' + keyword + '%'" />
			
			SELECT 
				  customerId id,
				  customerName name,
				  contactName,
				  address
			FROM 
				  Customers
			WHERE 	
				  CustomerName LIKE #{pattern}
			ORDER BY id DESC
			</script>
			""")
	List<Customer> sql01(String keyword);

	//아래와 같이 작성해도 되고 아니면 아예 쿼리 안의 코드처럼 작성해도 됨
	//WHERE FirstName LIKE '%eve%' OR LastName LIKE '%eve%'
	@Select("""
			<script>
			<bind name="p" value="'%' + s + '%'" />

			SELECT
				EmployeeId id,
				FirstName,
				LastName
			FROM
				Employees
			WHERE
				FirstName LIKE #{p}
				OR LastName LIKE #{p}
			ORDER BY id DESC
			</script>
			""")
	List<Employee> sql02(String s);
	
	@Select("""
			<script>
			SELECT COUNT(*)
			FROM Customers
			
			<if test="false">
			WHERE CustomerID = 10
			</if>
			</script>
			""")
	Integer sql3();

	
	@Select("""
			<script>
			
			SELECT COUNT(*)
			FROM Customers
			
			<if test="keyword neq null">
				<bind name="pattern" value="'%' + keyword + '%'" />
				WHERE CustomerName LIKE #{pattern}
			</if> 
			
			</script>
			""")
	Integer sql4(String keyword);

	@Select("""
			<script>
			SELECT AVG(Price)
			FROM Products
			
			<if test="cid neq 0">
				WHERE CategoryId = #{cid}
			</if>
			</script>
			""")
	Double sql5(int cid);
}