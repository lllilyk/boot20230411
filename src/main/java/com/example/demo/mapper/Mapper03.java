package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

import com.example.demo.controller.domain.*;

@Mapper
public interface Mapper03 {
	@Insert( """
			INSERT INTO MyTable34 (Col1, Col2)
			VALUES (#{val1}, #{val2})
			""")
	int sql01(Integer val1, String val2);
	
	@Insert("""
			INSERT INTO MyTable35 (Col1, Col2)
			VALUES (#{v1}, #{v2})
			""")
	int sql02(Double v1, String v2);
	
	//  파라미터가 1개일 때는 
	// 프로퍼티명만 작성하면 ok
	@Insert("""
			INSERT INTO MyTable36(Col1, Col2, Col3)
			VALUES (#{prop1}, #{prop2}, #{prop3})
			""")
	int sql03(Dto09 dto);
	
	@Insert("""
			INSERT INTO MyTable37 (Age, Name, Score)
			VALUES (#{age}, #{name}, #{score})
			""")
	int sql04(Dto10 dto);
	
	// 파라미터가 2개 이상일 때는
	// 파라미터명.프로퍼티명 형식으로 작성해야 ok
	@Insert("""
			INSERT INTO MyTable37 (Age, Name, Score)
			VALUES (#{dto09.prop1}, #{dto10.name}, #{dto09.prop3}) 
			""")
	int sql05(Dto09 dto09, Dto10 dto10);
	
	
	// dto01.prop1 -> col1
	// dto02.age -> col2
	// dto01.prop2 -> col3
	// dto02.name -> col4
	// dto01.prop3 -> col5
	// dto02.score -> col6
	
	@Insert("""
			INSERT INTO MyTable38(Col1, Col2, Col3, Col4, Col5, Col6)
			VALUES (#{dto01.prop1}, #{dto02.age}, #{dto01.prop2},#{dto02.name}, #{dto01.prop3}, #{dto02.score})
			""")
	int sql06(Dto09 dto01, Dto10 dto02);
	
	@Insert("""
			INSERT INTO MyTable39(Col2, Col3)
			VALUES(#{prop2}, #{prop3})
			""")
	// useGeneratedKeys를 쓰지 않아도 db에서는 자동으로 증가하지만
	// 나는 지금 prop1에 자동증가한 key값을 담아서 보고 싶으니까!
	// 기본값이 false인 애를 true로 변경! 자동 증가하는 애를 쓰겠다! true
	@Options(useGeneratedKeys = true, keyProperty="prop1")
	int sql07(Dto11 dto);
	
	@Insert("""
			INSERT INTO MyTable40(Age, Name, Score)
			VALUES(#{age}, #{name}, #{score})
			""")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int sql08(Dto12 dto);
	
	
	
}
