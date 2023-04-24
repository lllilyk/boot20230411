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


