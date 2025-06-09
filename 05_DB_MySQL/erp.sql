/*
	DB Modeling
     1. 개념적 모델링
      - Entity(테이블) 추출
      - Entity 간의 관계설정
     2. 논리적 모델링
      - 속성(컬럼) 추출
      - 정규화 작업 (1, 2, 3) ---> 이 이상으로 가면 역정규화
     3. 물리적 모델링
      - 테이블 실질적으로 작성 (CREATE 문 작성)
     
     * Normalization(정규화)
      - 불필요한 데이터의 중복을 제거하여 데이터모델을 구조화하는 것alter
      - 효율적인 자료 저장 및 데이터 무결성을 보장하고 오류를 최소화하여 안정성을 보장하기 위해 적용함
      
      제 1 정규화 : 복수의 속성값을 갖는 속성을 분리
      제 2 정규화 : 주 식별자에 종속되지 않는 속성을 분리
      제 3 정규화 : 속성에 종속적인 속성을 제거
*/

/*
	외부 공용협업툴과 실시간 연동 (API사용)되는
    사내 ERP 시스템 만들기
    전사적 자원 관리 시스템
    
    공통 : 사용자 or 사원에 대한 테이블
    
     - 프로젝트 관리 : SlackAPI (선택)
     - 일정 관리 : Google Calendar API (선택)
     - 고객관계관리 : Notion  API (선택)
     - 인적자원관리 :
     - 재무관리 : Notion API (선택)
     - 품질보증관리 : 
*/

/*
	  
    MySQL
     - data type
       1. TEXT
			- CHAR / **VARCHAR** : 고정 및 가변 길이 문자, 반드시 크기 지정
            - **TEXT** : 매우 긴 문자열을 저장하는데 사용
	   2. INTEGER
			- **INT** : 정수값 저장하는데 사용
            - FLOAT / DOUBLE : 부동소수점 저장하는데 사용
            - DECIMAL : 고정소수점 저장하는데 사용
	   3. DATE & TIME
			- **DATE** : 날짜 저장하는데 사용
            - TIME : 시간 저장하는데 사용
            - **DATETIME** / TIMESTAMP : 날짜와 시간을 함께 저장
            - SYSDATE = DEFAULT NOW()
	   4. BOOLEAN
			- BOOLEAN / BOOL : TRUE OR FALSE VALUE 저장하는데 사용
	   5. BLOB (이진 자료형)
			- BLOB : 이진 데이터를 저장하는데 사용. 이미지나 동영상과 같은 이진 파일
            -> 실제로는 이미지나 동영상은 따로 관리 (URL만 문자형으로 저장)
            
*/
-- 사용자 or 사원 관련 정보 들어가는 테이블 하나 CREATE 문 작성해서 제출
-- PRIMARY KEY : AUTO_INCREMENT 추가!
CREATE TABLE `PERSONNEL`(
	`Key`	INT	NOT NULL,
	`SERIALNUM`	VARCHAR(255) DEFAULT	'25-79458479',
	`NAME`	VARCHAR(255)	DEFAULT '홍길동',
	`AGE`	INT	DEFAULT '21',
	`GENDER`	VARCHAR(255)	DEFAULT '남',
	`ADDRESS`	VARCHAR(255)	DEFAULT '서울',
	`RANK`	VARCHAR(255)	DEFAULT '이병',
	`ROLE`	INT	DEFAULT '1111',
	`SALARY`	INT	DEFAULT '250000',
	`BASE`	VARCHAR(255)	DEFAULT '철원'
);

DROP TABLE PERSONNEL;
SELECT * FROM PERSONNEL;

ALTER TABLE `PERSONNEL` ADD CONSTRAINT `PERSONNEL_ID` PRIMARY KEY (
	`Key`
);