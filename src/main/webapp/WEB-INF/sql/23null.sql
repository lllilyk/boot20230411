SELECT * FROM Products ORDER BY 1 DESC;
-- IFNULL : null이면 다른 값으로 변경
SELECT IFNULL(0, 100); -- 0
SELECT IFNULL('kim', 'lee'); -- kim

SELECT IFNULL('PPYONG', 'PPINYONG') AS PP;
SELECT IFNULL(NULL, 'PPINYOT') AS NULLRESULT;

SELECT IFNULL(NULL, 100); -- 100
SELECT IFNULL(NULL, 'park'); -- park

SELECT ProductID, ProductName, SupplierID, CategoryID
,Unit, Price FROM Products ORDER BY 1 DESC;

SELECT ProductID, ProductName, SupplierID, CategoryID
,Unit, IFNULL(Price, 0) FROM Products ORDER BY 1 DESC;

SELECT * FROM Employees ORDER BY 1 DESC;
SELECT EmployeeID,
		LastName,
        FirstName,
        BirthDate,
        Photo,
        IFNULL(Notes, '산왕')
FROM Employees
ORDER BY 1 DESC;

SELECT ProductID, 
		ProductName, 
        SupplierID, 
        CategoryID,
        Unit, 
        IFNULL(Price, 0) Price
FROM Products ORDER BY 1 DESC;

SELECT AVG(IFNULL(Price, 0)) AS Average 
FROM Products
WHERE CategoryID = 2; -- 23.06 

-- 윗 코드에서 null값을 0으로 모두 변경해주었으므로
SELECT AVG(Price) AS Average 
FROM Products
WHERE CategoryID = 2; -- 21.28

SELECT * FROM Customers ORDER BY 1 DESC;

SELECT * FROM Customers ORDER BY 1 DESC;
SELECT CustomerID, 
		CustomerName,
        ContactName,
        IFNULL(Address, '우리집으로 가자'),
        City,
        PostalCode,
        Country
FROM Customers
ORDER BY 1 DESC;
-- 고객 테이블에서 CustomerId, CustomerName, ContactName, Address 조회
-- ContactName이 Null이면 'Anonymous'로
-- Address가 Null이면 'Homeless'로 조회
SELECT CustomerID, CustomerName, IFNULL(ContactName, 'Anonymous') name, IFNULL(Address, 'Homeless') address 
FROM Customers
ORDER BY 1 DESC; -- 이건 조회할 때만 해당되는 것이고 실제 데이터는 변하지 않음