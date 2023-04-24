-- normalization(정규화)
-- 세번째 정규화까지만 해도 good 
-- 책 358P / 위키백과 참고

-- 책 215P
-- ★★★ 1NF(first normal form) 첫번째 정규화 : 제 1 정규형 ★★★
-- 규칙1 : 각 행의 데이터들은 원자적 값을 가져야한다. (한 번에 하나의 데이터만 가질 수 있음)
-- EX) 명헌이가 가진 전화번호가 2개인 경우에는 두 개의 테이블로 작성해야 함
-- 규칙2 : 같은 데이터(EX. 전화번호)가 여러 열에 반복되지 말아야 한다. 
-- 규칙3 : 각 행은 유일무이한 식별자인 기본키를 가지고 있어야 한다. 

-- 책 216-217P
-- *기본키(Primary Key) : 각 레코드를 다른 레코드와 구분하는 열
-- 1) 기본키는 NULL이 될 수 없습니다.
-- 2) 기본키는 레코드가 삽입될 때 값이 있어야 합니다.
-- 3) 기본키는 간결해야 합니다. 
-- 4) 기본키의 값은 변경 불가입니다. 
-- 가장 좋은 기본키는 기본키를 위한 열을 새로 만드는 것!
-- natural key(이미 존재하는 열을 사용)보다는 synthetic key(기본키로 사용하기 위해 새로 만든 열)!

-- ex) 학생명, 전화번호
CREATE TABLE Student(
	Id INT PRIMARY KEY AUTO_INCREMENT, -- 인위적 키 컬럼 추가 
	Name VARCHAR(50)
);

CREATE TABLE StudentPhone(
	Id INT PRIMARY KEY AUTO_INCREMENT, -- synthetic key
	StudentId INT, -- natural key
    Phone VARCHAR(50)
	-- PRIMARY KEY(StudentId, Phone) -- 이렇게 해도 되지만 전화번호는 바뀔 수 있으니까 기본키를 위한 새로운 컬럼 생성하는 것이 더 좋음
);

-- ex) 교재 정보 저장할 테이블 작성
CREATE TABLE Book(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(50),
    Price INT
);

CREATE TABLE BookUpdate(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Date DATE
);

-- 책 369P
-- ★★★ 2NF (second normal form)두번째 정규화 ★★★
-- 규칙 1 : 1NF여야 한다. 
-- 규칙 2 : 부분적 함수 의존이 없다. 
-- AUTO_INCREMENT 추가하면 부분적 함수 의존(키의 일부분에 의존) X

-- 책 374P
-- ★★★ 3NF (third normal form) 세번째 정규화 ★★★
-- 규칙 1 : 2NF입니다. 
-- 규칙 2 : 이행적 종속(키가 아닌 컬럼끼리 의존)이 없다.

