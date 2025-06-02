/*
    데이터베이스 : 데이터 (Data) + 베이스 (Base)
    - DBMS (Database Management System) : 데이터베이스 관리 시스템
    - RDBMS (Relational Database Management System) : 관계형 데이터베이스 관리 시스템
       1. 가장 대표적인 데이터베이스 시스템
       2. 데이터를 테이블 형태(행과 열)로 저장하고, 여러 테이블 간 관계를 설정하고 데이터의 관계를 표현 및 분석
       3. 데이터의 중복을 최소화하고 무결성, transaction 관리 등 뛰어난 데이터 관리 성능을 제공
    - SQL (Structured Query Language) : 관계형 데이터베이스를 관리하기 위한 표준 언어
    - SQL 종류
       1. DML (Data Manipulation Language) : 데이터 조작 언어
          - SELECT : 데이터 조회
          - INSERT : 데이터 삽입
          - UPDATE : 데이터 수정
          - DELETE : 데이터 삭제
       2. DQL (Data Query Language) : 데이터 질의 언어
          - SELECT : 데이터 조회
       3. DDL (Data Definition Language) : 데이터 정의 언어. DB의 구조를 정의하거나 변경, 삭제하기 위한 언어
          - 테이블 변경과 관련
          - CREATE : 객체 생성
          - ALTER : 객체 수정
          - DROP : 객체 삭제
       4. DCL (Data Control Language) : 데이터 제어 언어. DB의 보안, 권한 관리, 무결성 제어를 위한 언어
          - GRANT : 권한 부여
          - REVOKE : 권한 회수
       5. TCL (Transaction Control Language) : 트랜잭션 제어 언어
          - COMMIT : 트랜잭션 완료
          - ROLLBACK : 트랜잭션 취소
          - SAVEPOINT : 트랜잭션 중간 지점 설정
       6. CRUDE (Create, Read, Update, Delete, Execute) : 데이터베이스의 기본적인 작업
*/

/*
    SELECT COLUMN1, COLUMN2, ...
    FROM TABLE_NAME, TABLE_NAME, ...
     - 테이블에서 데이터를 조회할 때 사용하는 SQL문
     - SELECT 실행 결과를 Result Set이라고 한다.
     - 조회하고자 하는 컬럼은 반드시 FROM 절에 지정한 테이블에 존재해야 한다
     - 테이블의 모든 컬럼을 조회하려면 * 기호를 사용

     SELECT NAME, AGE, HOBBY FROM USER_INFO; --오라클 방식
     SELECT name, age, hobby FROM user_info; -- MySQL 방식
*/

-- USER_INFO 테이블 전체 조회
SELECT * FROM USER_INFO;

-- USER_INFO 이름(NAME), 나이(AGE), 취미(HOBBY) 컬럼 조회
SELECT NAME, AGE, HOBBY FROM USER_INFO;

-- EMPLOYEE 테이블의 직원명(EMP_NAME), 이메일(EMAIL) 조회
SELECT EMP_NAME, EMAIL FROM EMPLOYEE;

/*
    컬럼 산술 연산
     - SELECT 절에 컬럼명 입력 부분에 산술연산자를 사용하여 결과 조회

    컬럼 별칭
     - 산술연산을 하게 되면 컬럼명이 지저분해진다.
     - 이때 컬럼명에 별칭을 부여주면 깔끔하게 보일 수 있다.
    컬럼 AS 별칭 / 컬럼 AS '별칭' / 컬럼 별칭 / 컬럼 '별칭'
*/

-- USER_INFO에서 나이(AGE)에 10년 후를 계산
SELECT 
NAME 이름, 
AGE 나이,
AGE + 10 "10년 후" 
FROM USER_INFO;

-- EMPLOYYEE에서 직원명, 월급, 연봉 조회

SELECT EMP_NAME, SALARY, SALARY * 12 AS ANNUAL_SALARY FROM EMPLOYEE;

/*
    Literal (문자열)
     - SELECT 절에 리터럴을 사용하면 테이블에 존재하는 데이터 처럼 조회 가능
     - 즉, 리터럴을 RESULT SET의 모든 행에 반복적으로 출력
    연결 연산자 ||
     - SELECT 절에 여러 컬럼값들을 연결하여 하나의 컬럼처럼 조회 가능
     - 여러 컬럼값들을 마치 하나의 컬럼인것처럼 연결
     - 컬럼값과 리터럴도 연결할 수 있음

*/

-- USER_INFO에서 이름(NAME), 나이(AGE) 조회
SELECT NAME, AGE || '살' AS 나이 FROM USER_INFO;

--USER_INFO에서 이름(NAME)의 MBTI는 XXXX 입니다.
SELECT NAME || '의 MBTI는 입니다' || MBTI || '입니다' AS MBTI FROM USER_INFO;

/*
    Distinct (중복 제거)
     - 컬럼에 중복된 값들을 한번씩만 표시하고자 할 때
     - SELECT 절에 DISTINCT 키워드를 사용하면 중복된 데이터를 제거하고 조회
     - DISTINCT는 SELECT 절의 첫 번째 컬럼에만 적용됨
     - DISTINCT는 WHERE 절과 함께 사용 가능
     - DISTINCT는 ORDER BY 절과 함께 사용 가능
     - DISTINCT는 GROUP BY 절과 함께 사용 가능
*/

-- USER-INFO에서 나이(AGE)가 중복되지 않게 조회

SELECT DISTINCT MBTI FROM USER_INFO;

/*
    WHERE 절
     - SELECT 컬럼, 컬럼, ...
     FROM 테이블명
     WHERE 조건식;

     -조회하고자 하는 테이블로부터 "특정 조건"에 만족하는 데이터만 조회하고자 할때
     - 이때 WHERE절에 조건식 제시
     - 조건식에는 다양한 연산자 사용 가능
    
    비교 연산자
      =, <>, !=, >, <, >=, <=
      A. = : 같음
      B. !=, <> : 같지 않음
      C. >, <, >=, <= : 대소 비교
     - NULL 값은 비교 연산자로 비교할 수 없음
     - NULL 값은 IS NULL 또는 IS NOT NULL로 비교
*/

-- USER_INFO에서 나이가 30이상인 이름(NAME), 나이(AGE), 생년월일(BIRTHDATE) 조회
SELECT * FROM USER_INFO NAME WHERE AGE >= 30;

-- EMPLOYEE에서 부서코드(DEPT_CODE)가 'D9'인 사원들 (모든 컬럼) 조회
SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D9';