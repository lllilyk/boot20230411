-- 특정 테이블의 모든 필드
SELECT * FROM Customers;
-- 특정 테이블(Customers)의 CustomerName 필드만 
SELECT CustomerName FROM Customers;

SELECT ContactName FROM Customers;
SELECT Country FROM Customers;

-- ,(컴마)로 구분
SELECT CustomerName, ContactName FROM Customers;
SELECT CustomerName, ContactName, Country FROM Customers;

-- 결과 테이블의 필드 순서 결정
-- SELECT 다음에 작성하는 순서대로 출력되므로 원하는 순서대로 작성 
SELECT Country, ContactName, CustomerName FROM Customers;

-- 문제 1) Employees 테이블에서 BirthDate, FirstName, LastName을 조회하는 쿼리 작성
SELECT BirthDate, FirstName, LastName FROM Employees;

-- 테이블명만 대소문자 잘 구별해주고 다른 것들은 상관 없음!
SELECT birthdate, firstname, lastname FROM Employees;
