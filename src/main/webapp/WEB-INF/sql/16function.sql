-- 집계함수(Aggregate Function)
-- : AVG, SUM, MAX, MIN, COUNT

-- AVG(평균), SUM(합계)
SELECT SUM(Price) FROM Products;
SELECT AVG(Price) FROM Products;

-- 5번 카테고리 상품값의 합계
SELECT SUM(Price) FROM Products WHERE CategoryID = 5;

-- 1번 카테고리 상품값의 평균
SELECT AVG(Price) FROM Products WHERE CategoryID = 1;