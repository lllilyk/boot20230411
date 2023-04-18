-- insert : 테이블에 새 record 입력
SELECT * FROM Customers;
INSERT INTO Customers
(CustomerID, CustomerName, ContactName,
Address, City, PostalCode, Country)
VALUES
(92, '박지성', '두개의심장',
'London', 'Seoul', '1234567', 'Korea');

-- 모든 컬럼에 값을 넣을 때 컬럼명 생략 가능
INSERT INTO Customers
VALUES (93, '차범근', '차붐', '프랑크푸르트', 'Seoul', '1234134', 'Korea');

-- 특정 칼럼에만 값을 넣을 때 컬러명 작성해야함
INSERT INTO Customers
(CustomerID, CustomerName, City, Country)
VALUES
(94, '송태섭', 'Tokyo', 'Japan');

SELECT * FROM Customers ORDER BY CustomerID DESC;
INSERT INTO Customers
(CustomerID, CustomerName, City, Country)
VALUES
(92, '이명헌', 'Akita', 'Japan');

-- supplier 테이블에 30번째 공급자 추가(모든 열)
-- supplier 테이블에 31번째 공급자 추가
-- supplierID, SupplierName, City, Country
SELECT * FROM Suppliers ORDER BY 1 DESC;
INSERT INTO Suppliers
VALUES
(30, 'myeonghunlee', 'ppyong', 'japan', 'akita', 11111, 'japan', 010101);

INSERT INTO Suppliers (SupplierID, SupplierName, City, Country)
VALUES (31, '채치수', 'Seoul', 'Korea');
SELECT * FROM Suppliers ORDER BY 1 DESC;
