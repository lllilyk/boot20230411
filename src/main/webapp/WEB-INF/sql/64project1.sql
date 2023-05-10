USE Board;
SELECT * FROM Board;
SELECT * FROM Member;

-- 모든 게시물의 writer가 ppyong이 되는 것  
UPDATE Board
SET writer = 'ppyong';

-- board writer에 member의 id와 맞는 row가 없으므로 불가했음 그래서 writer를 전부 ppyong으로 바꿔줌
ALTER TABLE Board
ADD FOREIGN KEY (writer) REFERENCES Member (id);

SELECT * FROM Member;

-- 권한 테이블
CREATE TABLE MemberAuthority (
	memberId VARCHAR(20) NOT NULL,
	authority VARCHAR(30) NOT NULL,
    FOREIGN KEY (memberId) REFERENCES Member(id),
	PRIMARY KEY(memberId, authority)
);

SELECT * FROM MemberAuthority;

SELECT * FROM Member m LEFT JOIN MemberAuthority ma ON m.id = ma.memberId
WHERE m.id = 'ppyong';

INSERT INTO MemberAuthority
VALUE ('admin0', 'admin');

-- 검증방법
-- 지우기 전에 같은 테이블, 같은 조건으로 
-- SELECT 먼저 확인하고
SELECT * FROM Customers WHERE CustomerID = 94;

SELECT * FROM Employees ORDER BY 1 DESC;
SELECT * FROM Employees WHERE EmployeeID = 13;
DELETE FROM Employees WHERE EmployeeID = 13;

-- 맞는지 확인되면 DELETE 실행
DELETE FROM Customers -- 지울 테이블 명
WHERE CustomerID = 94; -- 지울 레코드의 조건

DELETE FROM Member WHERE password = '$2a$10$TUvIhr.p4QmhEv39Qt90veBYHuxdj5MSVFJIaVIuYnxBti.uNs56.';
DELETE FROM Member WHERE id = 'ㅁ';
SELECT * FROM Member;