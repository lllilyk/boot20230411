USE w3schools;

SELECT lastName, firstName FROM Employees; -- 9 rows return

-- lastName이 'd'로 시작하는 직원 이름 조회
SELECT lastName, firstName
FROM Employees
WHERE lastName >= 'd' AND lastName < 'e'; 

-- emp : 서브 쿼리를 FROM절에서 쓰기 위해서는 별칭이 꼭 필요함
SELECT lastName, firstName
FROM (SELECT lastName, firstName FROM Employees) emp
WHERE lastName >= 'd' AND lastName < 'e';

-- JOIN을 사용한 쿼리 전체를 FROM절에서 서브쿼리로 이용
SELECT AVG(소비금액) 
FROM (SELECT C.CustomerName, SUM(OD.Quantity * P.Price) 소비금액
		FROM OrderDetails OD JOIN Orders O ON OD.OrderID = O.OrderID
							 JOIN Products P ON OD.ProductID = P.ProductID
							 JOIN Customers C ON C.CustomerID = O.CustomerID
GROUP BY C.CustomerID
ORDER BY 소비금액 DESC) t1; -- t1별칭 작성하는 것 까먹지 말기

-- (직원별 매출액)의 평균
SELECT AVG(매출) average
FROM (SELECT e.EmployeeID, SUM(p.Price * od.Quantity) 매출 
	  FROM Orders o JOIN Employees e ON o.EmployeeID = e.EmployeeID
					JOIN OrderDetails od ON o.OrderID = od.OrderID
					JOIN Products p ON od.ProductID = p.ProductID
GROUP BY e.EmployeeID) T1;

-- 카테고리별 평균상품가격 조회 (평균상품가격이 30.00 달러 이상인 것만)
SELECT CategoryID, AVG(Price)
FROM Products
GROUP BY CategoryID
HAVING AVG(Price) >= 30.00;

SELECT * FROM Products;

SELECT CategoryID, average
FROM
(SELECT CategoryID, AVG(Price) average
FROM Products
GROUP BY CategoryID) T1
WHERE average >= 30.00;

SELECT T1.CategoryID, c.CategoryName, T1.average
FROM
(SELECT CategoryID, AVG(Price) average
FROM Products
GROUP BY CategoryID) T1 JOIN Categories c ON T1.CategoryId = c.CategoryId
WHERE average >= 30.00;