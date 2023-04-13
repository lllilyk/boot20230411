-- select
-- 데이터 읽기(가져오기)

-- table(행, 열)
-- 행(row, record)
-- 열(column, field, attribute)

-- SELECT 열 목록
-- FROM 테이블
-- 쿼리 끝에 ;(세미콜론) 작성

-- Customers 테이블에서 모든 행(record)과 모든 열(field)을 가져와라(읽어라) 
SELECT * FROM Customers; -- 실행 ctrl + enter

-- 문제1) Employess 테이블에서 모든 행과 모든 열을 읽기
SELECT * FROM Employees;
SELECT * FROM Orders;
SELECT * FROM Products;

-- 작성 관습이긴 한데
-- sql(mariadb)은 대소문자 구분 안함(테이블명은 구분)
-- 일단은
-- 키워드는 대문자 
-- 테이블명, 컬럼명은 소문자