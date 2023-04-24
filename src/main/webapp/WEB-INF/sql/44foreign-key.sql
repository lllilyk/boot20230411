-- 학생명, 전화번호(여러개 가능)
CREATE TABLE Student (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	Name VARCHAR(50)
);

CREATE TABLE StudentPhone (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	StudentId INT NOT NULL,
	Phone VARCHAR(50),
    -- foreign key (외래키 참조키)
    FOREIGN KEY (StudentId) REFERENCES Student(Id)
);

DESC Student;
DESC StudentPhone;

CREATE TABLE StudentPhone(
	StudentId INT,
    Phone VARCHAR(50),
    PRIMARY KEY (StudentId, Phone)
);
-- 이렇게 합성키를 만드는 것도 가능하지만 
-- StudentId나 Phone이 변경될 가능성이 있으므로 좋은 방법은 아님
-- 새로 synthetic key를 만들어서 기본키로 설정해주는게 best

-- 데이터 입력
INSERT INTO Student (Name) VALUES ('손흥민');
INSERT INTO Student (Name) VALUES ('박지성');

SELECT * FROM Student;

INSERT INTO StudentPhone (StudentId, Phone)
VALUES (1, '010-9999-8888');
INSERT INTO StudentPhone (StudentId, Phone)
VALUES (2, '010-8888-9999');
SELECT * FROM StudentPhone;

INSERT INTO StudentPhone (StudentId, Phone)
VALUES (3, '010-7777-7777'); -- fail 
-- FAIL : StudentId가 student를 참조하고 있기 때문에 
-- Student테이블에 id3번 값이 있는 상태에서만 studentphone의 3번 아이디 값을 추가할 수 있음.
INSERT INTO StudentPhone (StudentId, Phone)
VALUES (NULL, '010-5555-5555'); -- ok
INSERT INTO StudentPhone (StudentId, Phone)
VALUES (NULL, '010-3333-3333'); 
SELECT * FROM StudentPhone;

DELETE FROM StudentPhone
WHERE StudentId IS NULL;
ALTER TABLE StudentPhone
MODIFY COLUMN StudentId INT NOT NULL;

INSERT INTO StudentPhone (StudentId, Phone)
VALUES (1, '010-7777-7777');

SELECT * FROM Student;
SELECT * FROM StudentPhone;
DESC StudentPhone;

DELETE FROM Student
WHERE ID = 2; -- fail
-- > 외래키 제약사항이 있는 테이블의 데이터를 먼저 지워야 함
DELETE FROM StudentPhone
WHERE StudentId = 2;

DELETE FROM Student
WHERE Id = 2;
SELECT * FROM Student;
SELECT * FROM StudentPhone WHERE StudentId = 1;