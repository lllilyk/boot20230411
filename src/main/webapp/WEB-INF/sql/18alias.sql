-- alias : 별칭

SELECT * FROM Customers;
SELECT CustomerID, CustomerName FROM Customers;
-- AS : CustomerID는 너무 길어서 id라고 쓰고 싶다
SELECT CustomerID AS id, CustomerName AS name 
FROM Customers;
-- AS는 생략 가능
SELECT CustomerID id, CustomerName name
FROM Customers;

SELECT CustomerID id, CustomerName name
FROM Customers
ORDER BY id DESC;

-- column index 사용!
SELECT CustomerID id, CustomerName name
FROM Customers
ORDER BY 1;

SELECT Country C, COUNT(CustomerID) AS NumOfCustomer
FROM Customers
GROUP BY Country;

-- AS 생략 가능
SELECT Country C, COUNT(CustomerID) NumOfCustomer
FROM Customers
GROUP BY C
ORDER BY NumOfCustomer;

-- column index 사용 가능
SELECT Country C, COUNT(CustomerID) NumOfCustomer
FROM Customers
GROUP BY C
ORDER BY 2;

-- keyword 사용시 필요한 경우에는 `backtick` 사용 BUT 되도록 지양
SELECT Country AS `FROM` , CustomerName FROM Customers;
-- 아래와 같이 작성하는 경우도 있음..
SELECT `Country` AS `FROM`, `CustomerName` FROM `Customers`;