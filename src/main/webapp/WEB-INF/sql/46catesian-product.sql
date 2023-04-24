-- CATESIAN PRODUCT(곱집합) : 카테시안 곱
SELECT COUNT(*) FROM Products; -- 77
SELECT COUNT(*) FROM Categories; -- 8

SELECT COUNT(*)
FROM Products JOIN Categories; -- 616

SELECT * FROM Products JOIN Categories;

-- ON : 조인 조건
SELECT * FROM Products JOIN Categories; -- 616
SELECT * FROM Products JOIN Categories ON Products.CategoryID = Categories.CategoryID; -- 77

-- 조인 후 컬럼 수 : 왼쪽 테이블 컬럼 수 + 오른쪽 테이블 컬럼 수
DESC Products; -- 6개의 컬럼
DESC Categories; -- 3개의 컬럼
SELECT * FROM Products JOIN Categories; -- 9개의 컬럼
SELECT * FROM Products JOIN Categories ON Products.CategoryID = Categories.CategoryID; -- 9개의 컬럼

SELECT ProductName, CategoryName
FROM Products JOIN Categories
ON Products.CategoryID = Categories.CategoryID;

-- 
SELECT * FROM Products;
SELECT * FROM Suppliers;
-- 상품명, 그 상품을 공급하는 공급자명

SELECT ProductName, SupplierName
FROM Products JOIN Suppliers
ON Products.SupplierID = Suppliers.SupplierID
ORDER BY 2;

-- ALIAS 사용으로 코드 줄이기
SELECT CustomerName AS Name FROM Customers;

-- ALIAS 사용으로 풀네임을 쓸 필요가 없어짐
SELECT ProductName, SupplierName
FROM Products AS P JOIN Suppliers AS S
ON P.SupplierID = S.SupplierID;

-- AS 생략가능
SELECT ProductName, SupplierName
FROM Products P JOIN Suppliers S
ON P.SupplierID = S.SupplierID;

SELECT P.SupplierID, S.SupplierID FROM Products P JOIN Suppliers S
ON P.SupplierID = S.SupplierID;