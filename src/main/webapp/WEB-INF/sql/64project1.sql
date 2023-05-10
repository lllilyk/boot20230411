USE Board;
SELECT * FROM Board;
SELECT * FROM Member;

-- 모든 게시물의 writer가 ppyong이 되는 것  
UPDATE Board
SET writer = 'ppyong';

ALTER TABLE Board
ADD FOREIGN KEY (writer) REFERENCES Member (id);