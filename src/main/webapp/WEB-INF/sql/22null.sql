-- null : 값이 없음
-- null vs '' : 데이터베이스마다 다름

-- IS NULL : 값이 null인가?
SELECT * FROM Suppliers
WHERE ContactName = '';

SELECT COUNT(ContactName) FROM Suppliers;
SELECT * FROM Suppliers ORDER BY SupplierID DESC;
INSERT INTO Suppliers
(SupplierID, SupplierName, Address, City)
VALUES
(31, 'woosungjung', 'japan', 'akita');

SELECT * FROM Suppliers
WHERE ContactName IS NULL;

-- IS NOT NULL : 값이 NULL 아닌 컬럼 조회
SELECT * FROM Suppliers
WHERE ContactName IS NOT NULL
ORDER BY 1 DESC;

-- Customer 테이블에서 Address 컬럼이 null인 레코드 조회
SELECT * FROM Customers
WHERE Address IS NULL;

-- Customer 테이블에서 Address 컬럼이 null이 아닌 레코드 조회
SELECT * FROM Customers
WHERE Address IS NOT NULL
ORDER BY 1 DESC;

-- 집계함수에서 NULL 제외
SELECT * FROM Customers ORDER BY 1 DESC;

SELECT COUNT(CustomerID) FROM Customers;
SELECT COUNT(Address) FROM Customers;
SELECT COUNT(*) FROM Customers;


-- 공급자 테이블에서 SupplierID 컬럼의 값 수 구하기
-- 공급자 테이블에서 ContactName 칼럼의 값 수 구하기
SELECT COUNT(SupplierID) FROM Suppliers;
SELECT COUNT(ContactName) FROM Suppliers;

SELECT * FROM Products ORDER BY 1 DESC;                                                                                                                                                                                                                                                                          
INSERT INTO Products
VALUES (78, 'Cake', 12, 2, '조각', NULL);

INSERT INTO Products
(ProductID, ProductName, SupplierID, CategoryID, Unit)
VALUES(79, 'Pizza', 12, 2, '조각');

SELECT COUNT(CategoryID) FROM Products WHERE CategoryID = 2;
SELECT * FROM Products WHERE CategoryID = 2 ORDER BY 1 DESC;
-- 14 

SELECT * FROM Employees ORDER BY 1 DESC;
SELECT COUNT(EmployeeID) FROM Employees WHERE FirstName = '뿅뿅';

SELECT SUM(Price) FROM Products WHERE CategoryID = 2;
-- 276.75
SELECT 276.75 / 14; -- 19.767857
SELECT 276.75 / 12; -- 23.062500

-- NULL은 제외하므로 14가 아닌 12로 나눈다는 점!
SELECT AVG(Price) FROM Products WHERE CategoryID = 2;
