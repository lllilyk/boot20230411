SELECT * FROM Products ORDER BY 1 DESC;
-- IFNULL : null이면 다른 값으로 변경
SELECT IFNULL(0, 100); -- 0
SELECT IFNULL('kim', 'lee'); -- kim
SELECT IFNULL(NULL, 100); -- 100
SELECT IFNULL(NULL, 'park'); -- park

SELECT ProductID, ProductName, SupplierID, CategoryID
,Unit, Price FROM Products ORDER BY 1 DESC;
SELECT ProductID, ProductName, SupplierID, CategoryID
,Unit, IFNULL(Price, 0) FROM Products ORDER BY 1 DESC;
SELECT ProductID, 
		ProductName, 
        SupplierID, 
        CategoryID,
        Unit, 
        IFNULL(Price, 0) Price
FROM Products ORDER BY 1 DESC;

SELECT AVG(IFNULL(Price, 0)) AS Average 
FROM Products
WHERE CategoryID = 2; -- 21.28

SELECT AVG(Price) AS Average FROM Products
WHERE CategoryID = 2; -- 23.06

SELECT * FROM Customers ORDER BY 1 DESC;

-- 고객 테이블에서 CustomerId, CustomerName, ContactName, Address 조회
-- ContactName이 Null이면 'Anonymous'로
-- Address가 Null이면 'Homeless'로 조회
SELECT CustomerID, CustomerName, IFNULL(ContactName, 'Anonymous') name, IFNULL(Address, 'Homeless') address 
FROM Customers
ORDER BY 1 DESC; -- 이건 조회할 때만 해당되는 것이고 실제 데이터는 변하지 않음