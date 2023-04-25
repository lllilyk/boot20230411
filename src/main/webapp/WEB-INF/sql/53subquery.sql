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
select * from Products; -- productId
select * from Categories; -- categoryId

-- Procducts table에서 CategoryId는 기본키가 아니므로 중복값이 있지만 ProductId는 기본키이므로 중복값이 없음
-- 때문에 각 ProductID-CategoryID쌍은 각각 다른 값의 쌍을 가지게 됨

SELECT CategoryName FROM Categories WHERE CategoryId = (SELECT CategoryId FROM Products WHERE ProductID = 1); 

SELECT categoryName FROM Categories
WHERE CategoryId = (SELECT categoryId FROM Products
					WHERE ProductId = 1);

SELECT Country FROM Suppliers
WHERE SupplierId = 2; -- USA
SELECT CustomerName FROM Customers
WHERE Country = 'USA';
-- 2 대신 내부 쿼리 작성

SELECT * FROM Suppliers; -- supplierid, country
SELECT * FROM Customers; -- customerName, country
-- 2번 공급자가 사는 나라의 고객들 조회
-- 1) 2번 공급자가 사는 나라 조회
SELECT Country FROM Suppliers WHERE SupplierId = 2;

-- 2) 그곳의 고객이름들을 조회
SELECT CustomerName FROM Customers WHERE Country = (SELECT Country FROM Suppliers WHERE SupplierId = 2);

SELECT CustomerName FROM Customers
WHERE Country = (SELECT Country FROM Suppliers
				 WHERE SupplierId = 2);

-- 문제) 평균가격보다 높은 가격의 상품들 조회
-- 1) 평균가격 구하기
SELECT AVG(Price) FROM Products;
-- 2) 평균 가격보다 높은 가격의 상품 이름 구하기
SELECT ProductName FROM Products WHERE Price > (SELECT AVG(Price) FROM Products);

SELECT * FROM Products;
SELECT AVG(Price) FROM Products;
SELECT ProductName FROM Products
WHERE Price > (SELECT AVG(Price) FROM Products);
