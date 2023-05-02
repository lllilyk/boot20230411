package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

import com.example.demo.controller.domain.*;

@Mapper
public interface Mapper11 {
	
	@Select("""
			SELECT c.CategoryId,
				   c.CategoryName,
				   c.Description,
				   p.ProductName
			FROM Categories c JOIN Products p
				 ON c.CategoryId = p.CategoryId
			WHERE c.CategoryId = #{id}
			""")
	@ResultMap("categoryResult") //xml에 작성한 <resultMap id="">와 동일하면 ok
	Category sql01(int id);
	
	@Select("""
			SELECT c.CategoryId,
				   c.CategoryName,
				   c.Description,
				   p.ProductName,
				   p.Price
			FROM Categories c JOIN Products p
				 ON c.CategoryId = p.CategoryId
			WHERE c.CategoryId = #{id}
			""")
	@ResultMap("categoryResultMap") //이미 사용한 "categoryResult"와 다르기만 하면 ok
	Category sql02(int id);

	
	@Select("""
			SELECT s.SupplierId,
				   s.SupplierName,
				   s.ContactName,
				   s.Address,
				   s.City,
				   s.PostalCode,
				   s.Country,
				   s.Phone,
				   p.ProductName,
				   p.Price
			FROM Suppliers s JOIN Products p
				 ON s.SupplierId = p.SupplierId
			WHERE s.SupplierId = #{id};
			""")
	@ResultMap("supplierResultMap") 
	Supplier sql03(int id);
	
	
	
	
	
	
	
	
	
	
}
