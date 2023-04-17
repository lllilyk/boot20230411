-- HAVING : 집계함수의 조건 설정
SELECT Country, COUNT(CustomerID) FROM Customers
GROUP BY Country;

-- 5명 이상의 고객이 있는 나라 조회
SELECT Country, COUNT(CustomerID) numOfCustomer
FROM Customers
WHERE numOfCustomer >= 5 -- WHERE 절은 특정 레코드를 거르는 조건이므로 이렇게는 쓸 수 없음
-- 개별 행 조건
GROUP BY Country;

SELECT Country, COUNT(CustomerID) numOfCustomer
FROM Customers
GROUP BY Country
-- having은 그룹에 대한 조건
HAVING COUNT(numOfCustomer) >= 5;

-- 상품의 평균 가격이 30 달러 이상인 카테고리 조회
SELECT CategoryID ID, AVG(Price) FROM Products
GROUP BY CategoryID
HAVING AVG(Price) >= 30;

-- 카테고리별 상품의 최고 가격이 100달러 이상인 카테고리 
SELECT CategoryID CI, MAX(Price) FROM Products
GROUP BY CategoryID
HAVING MAX(Price) >= 100;
