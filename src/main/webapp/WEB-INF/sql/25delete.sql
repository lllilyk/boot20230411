-- DELETE : 테이블의 RECORD 지우기
-- 매우 주의!!!!!!!!!!!!!!

-- 검증방법
-- 지우기 전에 같은 테이블, 같은 조건으로 
-- SELECT 먼저 확인하고
SELECT * FROM Customers WHERE CustomerID = 94;

SELECT * FROM Employees ORDER BY 1 DESC;
SELECT * FROM Employees WHERE EmployeeID = 13;
DELETE FROM Employees WHERE EmployeeID = 13;

-- 맞는지 확인되면 DELETE 실행
DELETE FROM Customers -- 지울 테이블 명
WHERE CustomerID = 94; -- 지울 레코드의 조건

-- 잘 지워졌는지 확인
SELECT * FROM Customers WHERE CustomerID = 94;
-- 안 나오면 잘 된 것

-- 93번 고객 지우기
SELECT * FROM Customers WHERE CustomerID = 93;

DELETE FROM Customers
WHERE CustomerID = 93;

SELECT * FROM Customers WHERE CustomerID = 93;

-- 78번 상품 지우기
SELECT * FROM Products WHERE ProductID = 78;

DELETE FROM Products WHERE ProductID = 78;
SELECT * FROM Products WHERE ProductID = 78;

-- 79번 상품 지우기
SELECT * FROM Products WHERE ProductID = 79;

DELETE FROM Products WHERE ProductID = 79;
SELECT * FROM Products WHERE ProductID = 79;

SELECT * FROM Products WHERE CategoryID = 1;
DELETE FROM Products WHERE CategoryID = 1;

SELECT COUNT(*) FROM Products;

SELECT * FROM Products;
DELETE FROM Products;

SELECT * FROM Products;

-- 고객 테이블에서 USA에 사는 고객들 지우기
SELECT * FROM Customers WHERE Country = 'USA';
DELETE FROM Customers WHERE Country = 'USA';

-- 모든 직원 지우기
SELECT * FROM Employees;
DELETE FROM Employees; 