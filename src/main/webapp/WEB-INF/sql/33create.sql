DESC MyTable10;

-- SHOW CREATE TABLE 테이블 생성 명령 보기
SHOW CREATE TABLE MyTable10;
CREATE TABLE `MyTable11` (
   `java` varchar(100) DEFAULT NULL,
   `spring` varchar(50) DEFAULT NULL,
   `jsp` varchar(20) DEFAULT NULL
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
 
 DESC MyTable10;
 DESC MyTable11;
 
 -- 같은 컬럼명 타입으로 새로운 테이블 만들기
 CREATE TABLE MyTable12 AS SELECT * FROM MyTable11;
 DESC MyTable12;
 SELECT * FROM MyTable12;