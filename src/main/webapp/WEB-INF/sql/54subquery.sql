SELECT DISTINCT Country FROM Suppliers; -- 16 rows return
SELECT * FROM Customers
WHERE Country = (SELECT DISTINCT Country FROM Suppliers); -- 같다(=)부등호를 이용할 때 여러행은 성립불가이므로 실행X

SELECT * FROM Customers
WHERE Country IN (SELECT DISTINCT Country FROM Suppliers); -- IN 키워드를 사용하면 실행O

-- 
-- '1996-07-04'에 주문한 상품명 조회
SELECT * FROM Orders;
SELECT * FROM OrderDetails;
SELECT * FROM Products;

SELECT P.ProductName, O.OrderDate
FROM Products P JOIN OrderDetails OD ON OD.ProductID = P.ProductID
				JOIN Orders O ON O.OrderID = OD.OrderID
WHERE O.OrderDate = '1996-07-04';

-- 조인을 먼저 고려하고 정 안되면 서브쿼리 이용
SELECT OrderID FROM Orders
WHERE OrderDate = '1996-07-04';
SELECT ProductId FROM OrderDetails
WHERE OrderID IN (10248);
SELECT ProductName FROM Products
WHERE ProductID IN (11, 42, 72);
SELECT ProductName FROM Products
WHERE ProductID IN (SELECT ProductId FROM OrderDetails
					WHERE OrderID IN (SELECT OrderID FROM Orders
										WHERE OrderDate = '1996-07-04'));



