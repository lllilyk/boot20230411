DESC Orders;
USE w3schools;
SELECT * FROM Orders; -- CustomerID
SELECT * FROM Customers; -- CustomerID

SELECT * 
FROM Orders o JOIN Customers c 
ON o.CustomerID = c.CustomerID; -- 830 rows return

-- 주문한적이 없는 고객 2명
SELECT * FROM Orders o RIGHT JOIN Customers c
ON o.CustomerID = c.CustomerID
WHERE o.OrderID IS NULL;

-- 주문을 처리한 적 없는 직원 조회 (없음)
DESC Orders;
SELECT * FROM Orders; -- OrderID, EmployeeID, OrderDate
SELECT * FROM Employees; -- EmployeeID

SELECT * 
FROM Orders o RIGHT JOIN Employees e ON o.EmployeeID = e.EmployeeID
WHERE o.EmployeeID IS NULL;

SELECT * FROM Orders;