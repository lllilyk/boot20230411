package com.example.demo.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.controller.*;
import com.example.demo.controller.domain.*;

@Mapper
public interface Mapper06 {

	//MySQL필드명과 자바빈이름이 다르기 때문에 
	//*로는 값이 제대로 들어가지 않음
	//별칭 잘 작성해주기
	@Select("""
			SELECT CustomerId id,
				   CustomerName name,
				   ContactName,
				   Address
			FROM Customers
			ORDER BY CustomerId DESC
			LIMIT #{startIndex}, 20
			""")
	List<Customer> listCustomer(Integer startIndex);

	@Select("""
			SELECT COUNT(*) FROM Customers
			""")
	Integer countAll();
	
}
