CREATE TABLE TableA (
	Num1 INT
);

CREATE TABLE TableB (
	Num2 INT
);

DESC TableA;
DESC TableB;

INSERT INTO TableA(Num1)
VALUES (1);
INSERT INTO TableA(Num1)
VALUES (2);
INSERT INTO TableA(Num1)
VALUES (3);
INSERT INTO TableA(Num1)
VALUES (4);
INSERT INTO TableA(Num1)
VALUES (5);

-- 여러 레코드를 한번에 넣는 것도 가능
INSERT INTO TableB(Num2)
VALUES(3), (4), (5), (6), (7);

SELECT * FROM TableA; -- 1, 2, 3, 4, 5
SELECT * FROM TableB; -- 3, 4, 5, 6, 7

SELECT * FROM TableA JOIN TableB; -- 25개의 컬럼 return(Cartesian product)

-- 같은 값 (3, 4, 5)만 뽑아내면 Inner Join
SELECT * FROM TableA a JOIN TableB b 
ON a.Num1 = b.Num2; -- 3개의 컬럼 return

SELECT * FROM TableA a LEFT JOIN TableB b
ON a.Num1 = b.Num2; -- Left (Outer) Join

SELECT * FROM TableA a RIGHT JOIN TableB b
ON a.Num1 = b.Num2; -- Right (Outer) Join


