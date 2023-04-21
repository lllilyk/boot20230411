package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface Mapper04 {
	
	@Delete("""
			DELETE FROM MyTable40
			""")
	int sql01();
	
	@Delete("""
			DELETE FROM MyTable39
			WHERE Col1 = #{id}
			""")
	int sql02(Integer id);

	@Delete("""
			DELETE FROM Customers
			WHERE CustomerID = #{key}
			""")
	int sql03(Integer key);
	
	
}
