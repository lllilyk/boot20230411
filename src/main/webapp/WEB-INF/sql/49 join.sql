-- 두 개 이상의 테이블 조인
SELECT COUNT(*) FROM Products; -- 77 rows return
SELECT COUNT(*) FROM Categories; -- 8 rows return
SELECT COUNT(*) FROM Suppliers; -- 29 rows return

DESC Products; -- 6개 열 categoryid / supplierid
DESC Categories; -- 3개 열 categoryid 
DESC Suppliers; -- 8개 열 supplierid

SELECT * FROM Products JOIN Categories JOIN Suppliers; -- 17개의 열
SELECT COUNT(*) 
FROM Products JOIN Categories JOIN Suppliers; -- 17864개 행, 총 17개의 열

DESC Products; -- 6개 열 categoryid / supplierid
DESC Categories; -- 3개 열 categoryid 
DESC Suppliers; -- 8개 열 supplierid

SELECT * FROM 
Products p JOIN Categories c ON p.CategoryID = c.CategoryID
		   JOIN Suppliers s ON p.SupplierID = s.SupplierID; -- 77개 행

-- ex) 1번 상품의 상품명, 카테고리명, 공급자명
SELECT ProductName, CategoryName, SupplierName
FROM Products P JOIN Categories C ON P.CategoryID = C.CategoryID
				JOIN Suppliers S ON P.SupplierID = S.SupplierID
WHERE P.ProductID = 1;

SELECT p.ProductName, c.CategoryName, s.SupplierName
FROM Products p JOIN Categories c ON p.CategoryID = c.CategoryID
				JOIN Suppliers s ON p.SupplierID = s.SupplierID
WHERE p.ProductID = 1;

-- 예제) 1996-07-04에 주문한 상품명 조회

SELECT ProductName
FROM OrderDetails OD JOIN Orders O ON OD.OrderID = O.OrderID
					 JOIN Products P ON OD.ProductID = P.ProductID
WHERE O.OrderDate = '1996-07-04';

-- '1996-07-04'의 매출 조회
SELECT SUM(od.Quantity * p.Price)
FROM OrderDetails OD JOIN Orders O ON OD.OrderID = O.OrderID
					 JOIN Products P ON OD.ProductID = P.ProductID
WHERE O.OrderDate = '1996-07-04';

-- 일별 매출 조회(날짜 순으로 결과 조회)
SELECT * FROM Orders; -- OrderID
SELECT * FROM OrderDetails; -- OrderID / ProductID / Quantity
SELECT * FROM Products; -- ProductID / Price

SELECT SUM(OD.Quantity * P.Price), O.OrderDate
FROM OrderDetails OD JOIN Orders O ON O.OrderID = OD.OrderID
					 JOIN Products P ON P.ProductID = OD.ProductID
GROUP BY O.OrderDate -- 일별 매출이니까 일별로 묶어주고
ORDER BY O.OrderDate ASC;  -- 정렬

-- 직원별 처리금액
SELECT E.EmployeeID, E.LastName, E.FirstName, SUM(P.Price * OD.Quantity) 매출
FROM OrderDetails OD JOIN Orders O ON OD.OrderID = O.OrderID
					 JOIN Products P ON P.ProductID = OD.ProductID
                     JOIN Employees E ON O.EmployeeID = E.EmployeeID
WHERE O.OrderDate BETWEEN '1997-01-01' AND '1997-01-31'
GROUP BY E.EmployeeID
ORDER BY 매출 DESC;

-- 상품별 판매금액
SELECT P.ProductName, SUM(OD.Quantity * P.Price) 판매금액
FROM OrderDetails OD JOIN Orders O ON O.OrderID = OD.OrderID
					 JOIN Products P ON P.ProductID = OD.ProductID
GROUP BY P.ProductName
ORDER BY 판매금액 DESC;

-- 고객별 소비금액
SELECT * FROM Orders; -- OrderID, CustomerID
SELECT * FROM OrderDetails; -- OrderID, ProductID, Quantity
SELECT * FROM Products; -- ProductID, Price
SELECT * FROM Customers; -- CustomerID

SELECT C.CustomerName, SUM(OD.Quantity * P.Price) 소비금액
FROM OrderDetails OD JOIN Orders O ON OD.OrderID = O.OrderID
					 JOIN Products P ON OD.ProductID = P.ProductID
                     JOIN Customers C ON C.CustomerID = O.CustomerID
GROUP BY C.CustomerID
ORDER BY 소비금액 DESC;