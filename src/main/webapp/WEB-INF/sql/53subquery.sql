-- 서브쿼리 (쿼리 안의 쿼리)
-- 책 430p
-- 1) SELECT 문이다. 
-- 2) 괄호 안에 있다. 
-- 3) 세미콜론이 없다.

-- 작성 가능한 위치
-- : WHERE, SELECT, FROM, HAVING

USE w3schools;
-- 1번 상품의 카테고리 명
SELECT CategoryId FROM Products
WHERE ProductId = 1;

SELECT CategoryName FROM Categories
WHERE CategoryId = 1;

-- 1 대신 내부 쿼리 작성
SELECT CategoryName FROM Categories
WHERE CategoryId = (SELECT CategoryId FROM Products
					WHERE ProductId = 1);

SELECT Country FROM Suppliers
WHERE SupplierId = 2; -- USA
SELECT CustomerName FROM Customers
WHERE Country = 'USA';
-- 2 대신 내부 쿼리 작성
SELECT CustomerName FROM Customers
WHERE Country = (SELECT Country FROM Suppliers
				 WHERE SupplierId = 2);

-- 문제) 평균가격보다 높은 가격의 상품들 조회
SELECT * FROM Products;
SELECT AVG(Price) FROM Products;
SELECT ProductName FROM Products
WHERE Price > (SELECT AVG(Price) FROM Products);
