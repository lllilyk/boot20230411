-- 내장 함수
-- COUNT : 레코드 수 리턴
SELECT * FROM Customers;
SELECT COUNT(CustomerID) FROM Customers;
SELECT COUNT(CustomerName) FROM Customers;

SELECT COUNT(CustomerID) FROM Customers
WHERE Country = 'Brazil';

-- DISTINCT : 중복 제거
SELECT Country FROM Customers;
SELECT DISTINCT Country FROM Customers;

-- COUNT & DISTINCT
SELECT COUNT(Country) FROM Customers;
SELECT COUNT(DISTINCT Country) FROM Customers;

-- 전체 직원수 
SELECT COUNT(EmployeeID) FROM Employees;

-- 상파울로에 사는 고객 수
SELECT COUNT(CustomerName) FROM Customers WHERE City = 'São Paulo';

-- 공급자(SUPPLIER)가 있는 나라 수(중복 제거)
SELECT COUNT(DISTINCT Country) FROM Suppliers; 
