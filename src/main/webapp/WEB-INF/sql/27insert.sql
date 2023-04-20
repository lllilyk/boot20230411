SELECT * FROM Employees ORDER BY 1 DESC;
INSERT INTO Employees (EmployeeID, LastName, FirstName)
VALUES (11, '박지성', '두개의 심장');

SELECT * FROM Employees ORDER BY 1 DESC;

INSERT INTO Employees
VALUES (19, 'HAN', 'GYODONG', '1985-03-14', 'GYODONG.pic', 'B');

INSERT INTO Employees(LastName, FirstName, Notes)
VALUES ('ZZANG', 'SAYURI', 'Octopus');

DESC Employees;

-- EmployeeID는 작성하지 않아도 자동으로 +
INSERT INTO Employees (LastName, FirstName)
VALUES ('박지성', '두개의 심장');

-- 테이블 정보 보기
DESC Employees;

DESC Customers;

SELECT * FROM Customers ORDER BY 1 DESC;
INSERT INTO Customers
(CustomerName, ContactName)
VALUES ('정대만', 'daeman');

-- 새 공급자 데이터 추가(SupplierID, SupplierName, City)
-- 자동 증가 컬럼은 직접 값을 넣지 않고
DESC Suppliers;
INSERT INTO Suppliers
(SupplierName, City)
VALUES ('이명헌', 'AKITA');

INSERT INTO Employees(LastName, FirstName, BirthDate, Photo, Notes)
VALUES('이', '명헌', '2000-02-02', 'EmpID10.pic', 'ppyong');


SELECT * FROM Suppliers ORDER BY 1 DESC; 

SELECT * FROM Customers ORDER BY 1 DESC;

SELECT * FROM Employees ORDER BY 1 DESC; 
