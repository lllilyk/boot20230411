-- 두 개 이상의 테이블 조인
SELECT COUNT(*) FROM Products; -- 77 rows return
SELECT COUNT(*) FROM Categories; -- 8 rows return
SELECT COUNT(*) FROM Suppliers; -- 29 rows return

DESC Products; -- 6개 열
DESC Categories; -- 3개 열
DESC Suppliers; -- 8개 열

SELECT * FROM Products JOIN Categories JOIN Suppliers; -- 17개의 열
SELECT COUNT(*) 
FROM Products JOIN Categories JOIN Suppliers; -- 17864개 행, 총 17개의 열

SELECT * FROM 
Products p JOIN Categories c ON p.CategoryID = c.CategoryID
		   JOIN Suppliers s ON p.SupplierID = s.SupplierID; -- 77개 행

-- ex) 1번 상품의 상품명, 카테고리명, 공급자명
SELECT p.ProductName, c.CategoryName, s.SupplierName
FROM Products p JOIN Categories c ON p.CategoryID = c.CategoryID
				JOIN Suppliers s ON p.SupplierID = s.SupplierID
WHERE p.ProductID = 1;

-- 예제) 1996-07-04에 주문한 상품명 조회
SELECT * FROM Orders;
SELECT * FROM OrderDetails;

SELECT p.ProductName, o.OrderDate
FROM OrderDetails d JOIN Orders o ON o.OrderID = d.OrderID
					 JOIN Products p ON d.ProductID = p.ProductID
WHERE o.OrderDate = '1996-07-04';

-- '1996-07-04'의 매출 조회
SELECT SUM(od.Quantity * p.Price)
FROM OrderDetails od JOIN Orders o ON od.OrderID = o.OrderID
					 JOIN Products p ON od.ProductID = p.ProductID
WHERE o.OrderDate = '1996-07-04';

-- 일별 매출 조회(날짜 순으로 결과 조회)
SELECT SUM(od.Quantity * p.Price), o.OrderDate
FROM OrderDetails od JOIN Orders o ON od.OrderID = o.OrderID
					 JOIN Products p ON od.ProductID = p.ProductID
GROUP BY o.OrderDate
ORDER BY o.OrderDate ASC;

SELECT * FROM Orders;
SELECT * FROM OrderDetails;
SELECT * FROM Products;
SELECT * FROM Employees;

-- 직원별 처리금액
SELECT
 e.EmployeeID,
 e.LastName,
 e.FirstName,
 SUM(p.Price * od.Quantity) 매출 
FROM Orders o JOIN Employees e ON o.EmployeeID = e.EmployeeID
              JOIN OrderDetails od ON o.OrderID = od.OrderID
              JOIN Products p ON od.ProductID = p.ProductID
WHERE o.OrderDate BETWEEN '1997-01-01' AND '1997-01-31'
GROUP BY e.EmployeeID
ORDER BY 매출 DESC;

-- 상품별 판매금액
SELECT p.ProductID, p.ProductName, SUM(od.Quantity * p.Price) 판매금액 
FROM 
	Orders o JOIN OrderDetails od ON o.OrderID = od.OrderID
             JOIN Products p ON od.ProductID = p.ProductID
GROUP BY p.ProductID
ORDER BY 판매금액 DESC;

-- 고객별 소비금액
SELECT c.CustomerID, c.CustomerName, SUM(p.Price * od.Quantity) 구매금액 
FROM
	Orders o JOIN OrderDetails od ON o.OrderID = od.OrderID
		     JOIN Customers c ON o.CustomerID = c.CustomerID
             JOIN Products p ON od.ProductID = p.ProductID
GROUP BY c.CustomerID
ORDER BY 구매금액 DESC;