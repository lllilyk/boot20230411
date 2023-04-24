-- 학생명, 전화번호(여러개 가능)
CREATE TABLE Student (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	Name VARCHAR(50),
    Phone VARCHAR(50)
);

-- 테이블을 더 만듦으로써 한 학생이 여러 전화번호를 가질 수 있게 됨
CREATE TABLE StudentPhone(
	Id INT PRIMARY KEY AUTO_INCREMENT,
	StudentId INT,
	Phone VARCHAR(50),
	-- foreign key(외래키 참조키) 11번째 코드가 3번 코드를 참조하고 있다. 
	FOREIGN KEY(StudentId) REFERENCES Student(Id)
);

DESC Student;
DESC StudentPhone;

-- phone번호는 바뀔 수 있으므로 좋은 쿼리가 아님
CREATE TABLE StudentPhone(
	StudentId INT, 
    Phone VARCHAR(50),
    PRIMARY KEY(StudentId, Phone)
);

-- 데이터 입력
INSERT INTO Student(Name) VALUES('손흥민');
INSERT INTO Student(Name) VALUES('박지성');

SELECT * FROM Student;

INSERT INTO StudentPhone(StudentId, Phone)
VALUES (1, '010-0000-0000');
INSERT INTO StudentPhone(StudentId, Phone)
VALUES (2, '010-1111-1111');

SELECT * FROM StudentPhone;

INSERT INTO StudentPhone(StudentId, Phone)
VALUES(3, '010-7777-7777'); -- FAIL : StudentId가 student를 참조하고 있기 때문에 
-- Student테이블에 id3번 값이 있는 상태에서만 studentphone의 3번 아이디 값을 추가할 수 있음.

INSERT INTO StudentPhone(StudentId, Phone)
VALUES (NULL, '010-2222-2222'); -- OK

SELECT * FROM StudentPhone;

DELETE FROM StudentPhone
WHERE StudentId IS NULL;

ALTER TABLE StudentPhone
MODIFY COLUMN StudentId INT NOT NULL;

SELECT * FROM StudentPhone;
SELECT * FROM Student;
INSERT INTO StudentPhone(StudentId, Phone)
VALUES (1, '010-3333-3333');

DELETE FROM StudentPhone
WHERE StudentId = 2; -- FAIL
-- 외래키 제약사항이 있는 테이블(Student)의 데이터를 먼저 지워야함.

DELETE FROM Student
WHERE Id = 2;

SELECT * FROM Student;
SELECT * FROM StudentPhone;
