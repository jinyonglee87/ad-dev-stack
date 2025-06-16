/*
    PL/SQL (PROCEDURE LANGUAGE EXTENSION TO SQL)
     - ORACLE에서 제공하는 절차적인 프로그래밍 언어
     - SQL 문장 내에서 변수의 정의, IF(조건처리), LOOP, FOR, WHILE(반복처리) 등을
       지원하는 SQL의 단점을 보완
     - 다수의 SQL 문을 한번에 실행 가능 (BLOCK 구조)

    * BLOCK : 명령어를 모아 둔 PL/SQL 프로그램의 기본 단위

    * PL/SQL 구조
     - [(DECALRE SECTION)] : 선언부
     -> DECLARE 시작, 변수나 상수를 선언 및 초기화
     
     - (EXECUTABLE SECTION) : 실행부
     -> BEGIN 시작, SQL문 또는 제어문 (조건문, 반복문)
     
     - [(EXCEPTION SECTION)] : 예외처리부
     -> EXCEPTION 시작, 예외 발생 시 해결하기 위한 구문을 미리 기술
*/
 SET SERVEROUTPUT ON;
 //ORACLE SQL DEVELOPER 먼저 입력
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE');
END;
/
-- / <--무조건 명시

/*
    DECLARE 선언부
     - 변수 및 상수를 선언하는 공간 (선언과 동시에 초기화도 가능)
*/
-- ORACLE SQL DEVELOPER
DECLARE
EID NUMBER;
BEGIN
    EID := &번호;
    DBMS_OUTPUT.PUT_LINE('EID :' || EID);
END;

--
DECLARE 
EID NUMBER;
ENAME VARCHAR2(20);
PI CONSTANT NUMBER := 3.14; -- 상수값 지정
BEGIN
EID := &번호;
Ename := '&이름';
DBMS_OUTPUT.PUT_LINE('EID :' || EID);
DBMS_OUTPUT.PUT_LINE('ENAME :' || ENAME);
DBMS_OUTPUT.PUT_LINE('PI :' || PI);
END;
/

-- 박나라 사원의 사번, 사원명, 급여 정보를 조회해서 출력
DECLARE
EID EMPLOYEE.EMP_ID%TYPE;
ENAME EMPLOYEE.EMP_NAME%TYPE;
SAL EMPLOYEE.SALARY%TYPE;
BEGIN
SELECT EMP_ID, EMP_NAME, SALARY 
INTO EID, ENAME, SAL
FROM EMPLOYEE
WHERE EMP_NAME = '&이름';

DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);
END;
/

/*
    EMPLOYEE, DEPARTMENT 테이블
    컬럼 : EMP_ID, EMP_NAME, DEPT_TITLE
    조회 : EMP_ID로 해당 부서가 어디인지
    
    -- 레퍼런스 타입 변수 : 변수명 테이블명.컬럼명%TYPE
*/
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
INTO EID, ENAME, DTITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE EMP_ID = '&번호';

DBMS_OUTPUT.PUT_LINE('EID :' || EID);
DBMS_OUTPUT.PUT_LINE('ENAME :' || ENAME);
DBMS_OUTPUT.PUT_LINE('DTITLE :' || DTITLE);
END;
/

SELECT EMP_ID, EMP_NAME, DEPT_TITLE
INTO EID, ENAME, DTITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE);

SELECT * FROM DEPARTMENT;


/*
    IF 조건식 THEN 실행내용
    ELSE 실행내용
    END IF;
*/

-- 보너스가 있는 경우만 보너스 출력, 없으면 해당 문구 출력
DECLARE
EMP EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';

    DBMS_OUTPUT.PUT_LINE('DLFMADMS ' || EMP.EMP_NAME);

    IF EMP.BONUS IS NULL
    THEN DBMS_OUTPUT.PUT_LINE('NO BONUS');
    END IF;

    DBMS_OUTPUT.PUT_LINE('보너스는 ' || EMP.BONUS);
END;
/

/*
    IF ~ ELSIF ~ ELSE
    IF 조건식1 THEN 실행 내용2
    ELSIF 조건식2 THEN 실행내용2
    ...
    ELSE 실행내용 N
    END IF;
*/

-- 사용자에게 점수를 입력받아 SCORE 변서 변수(데이터타입 : NUMBER)에 저장훈 후
-- 학점은 입력된 점수에 따라 GRADE 변수(데이터타입 : CHAR(1)에 저장
-- 출력은 '당신의 점수는 95점이고, 학점은 A학점입니다.'
-- 90 A, 80 B, 70 C, 60 D, ELSE F

DECLARE
SCORE NUMBER;
GRADE CHAR(1);
BEGIN
SCORE := '&점수';

IF SCORE >= 90 THEN GRADE := 'A';
ELSIF SCORE >= 80 THEN GRADE := 'B';
ELSIF SCORE >= 70 THEN GRADE := 'C';
ELSIF SCORE >= 60 THEN GRADE := 'D';
ELSE GRADE := 'F';
END IF;
DBMS_OUTPUT.PUT_LINE('당신의 점수는 ' || SCORE || '학점은' || GRADE || '학점입니다.');
END;
/

/*
    테이블은 EMPLOYEE, 컬럼은 SALARY
    500만원 이상이면 '고급', 300만원 이상이면 '중급', 300만원 미만이면 '초급'
    사원의 사번을 입력받아서 '해당 사원의 급여 등급은 S1입니다.'
*/

DECLARE
EMP EMPLOYEE%ROWTYPE;
SAL_GRADE VARCHAR2(30); 
BEGIN
SELECT *
INTO EMP
FROM EMPLOYEE
WHERE EMP_ID = '&사원번호';
IF EMP.SALARY >= 5000000 THEN SAL_GRADE := '고급';
ELSIF EMP.SALARY >= 3000000 THEN SAL_GRADE := '중급';
ELSE SAL_GRADE := '초급';
END IF;
DBMS_OUTPUT.PUT_LINE('해당 사원의 급여 등급은 ' || SAL_GRADE || '등급 입니다.');
END;
/

/*
    CASE 비교대상자
        WHEN 비교값1 THEN 결과값1
        WHEN 비교값2 THEN 결과값2
        ...
        ELSE 결과값N
    END CASE;
*/

-- >사번<을 입력받은 후 >부서코드<에 따라
-- D1인 경우 개발팀, D2인 경우는 디자인팀, D3인 경우는 기획팀
-- 그 외에는 서비스팀
-- 출력: 해당 사원 이름 '000는 개발팀 입니다'
DECLARE
EMP EMPLOYEE%ROWTYPE;
DNAME VARCHAR2(30);
BEGIN
SELECT *
INTO EMP
FROM EMPLOYEE
WHERE EMP_ID = '&사원번호';

DNAME := CASE EMP.DEPT_CODE 
    WHEN 'D1' THEN '개발팀'
    WHEN 'D2' THEN '디자인팀'
    WHEN 'D3' THEN '기획팀'
    ELSE '서비스팀'
END;
DBMS_OUTPUT.PUT_LINE('해당 사원 이름'|| EMP.EMP_NAME || '은 ' || DNAME || '입니다');
END;
/

/*
    반복문
    
    LOOP
        반복적으로 실행할 구문;
        
        * 반복문을 빠져나갈 수 있는 구문
            1. IF 조건식 THEN EXIT; END IF;
            2. EXIT WHEN 조건식;
    END LOOP;
*/

-- 1 ~ 5까지 1씩 증가하는 값을 출력
DECLARE
    NUM NUMBER := 1;
    BEGIN
        LOOP
            DBMS_OUTPUT.PUT_LINE(NUM);
            NUM := NUM + 1;
            EXIT WHEN NUM > 5;
        END LOOP;
    END;
/

/*
    FOR LOOP
    
    FOR 변수 IN 초기값..최종값
    LOOP
        반복적으로 실행할 구문;
    END LOOP;
*/

-- 1 ~ 5까지 1씩 증가하는 값을 출력
    BEGIN
        FOR NUM IN REVERSE 1..5 -- 역순 하고싶으면 REVERSE
        LOOP
            DBMS_OUTPUT.PUT_LINE(NUM);
        END LOOP;
    END;
/

/*
    WHILE LOOP
    WHILE 반복문이 수행될 조건
    LOOP
        반복적으로 실행할 구문;
    END LOOP;
*/

-- 1 ~ 5까지 1씩 증가하는 값을 출력
DECLARE
    NUM NUMBER := 1;
    BEGIN
        WHILE NUM <= 5
        LOOP
            DBMS_OUTPUT.PUT_LINE(NUM);
            NUM := NUM + 1;
        END LOOP;
    END;
/

/*
    구구단 출력(2~9단)
*/

DECLARE
    NUM NUMBER := 1;
    DAN NUMBER := 2;
BEGIN
    WHILE DAN <= 9
    LOOP
        WHILE NUM <= 9
        LOOP 
            DBMS_OUTPUT.PUT_LINE(DAN || 'X' || NUM || '='|| DAN * NUM);
            NUM := NUM + 1;
        END LOOP;
    DAN := DAN + 1;
    NUM := 1;
    END LOOP;    
END;
/

/*
 구구단 FOR
*/
BEGIN
    FOR DAN IN 2..9
    LOOP
        FOR NUM IN 1..9
        LOOP 
            DBMS_OUTPUT.PUT_LINE(DAN || 'X' || NUM || '='|| DAN * NUM);
        END LOOP;
    END LOOP;    
END;
/

/*
    예외처리부
    EXCEPTION(예외) : 실행 중 발생하는 오류
    
    EXCEPTION
        WHEN 예외명1 THEN 예외처리구문;
        WHEN 예외명2 THEN 예외처리구문2;
        ...
    
    * 오라클에서 미리 정의되어 있는 시스템 예외
    - NO_DATA_FOUND : SELECT한 결과가 한 행도 없는 겨우
    - TOO_MANY_ROWS : SELECT한 결과가 한 행이 리턴되어야 하는데 여러 행인 경우
    - ZERO_DIVIDE : 숫자를 0으로 나눌 때
    - DUP_VAL_ON_INDEX : UNIQUE 제약조건에 위배되었을 경우
    ...
*/

BEGIN
    DBMS_OUTPUT.PUT_LINE(10/ &숫자);
    EXCEPTION
        WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('나누기 연산시 0으로 나눌 수 없습니다');
END;
/

-- EMPLOYEE에서 부서코드(DEPT_CODE)를 입력받아서
-- 사원을 조회려고 할 때


DECLARE
    EMP EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE DEPT_CODE = '&부서코드';
EXCEPTION
    WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('조회 결과가 없습니다');
    WHEN TOO_MANY_ROWS THEN DBMS_OUTPUT.PUT_LINE('너무 많은 행이 조회되었습니다');
END;
/

/*
    CURSOR(커서)
     - SQL 쿼리의 결과가 여러 행일 때 처리 결과를 한행씩 처리하는 객체
     
     1. IMPLICIT(묵시적) 커서
        오라클에서 자동으로 생성되어 사용하는 커서
        
        PL/SQL에서 SQL문 실행시 자동으로 만들어져서 사용
     
     2. EXPLICIT(명시적) 커서
        사용자가 직접 선언해서 사용할 수 있는 커서
        
        CURSOR CURSORNAME IS SELECT 문
        
        OPEN CURSORNAME
        FETCH CURSORNAME INTO 변수, ...
        ...
        CLOSE CURSORNAME;
*/
DROP TABLE EMP_COPY;
CREATE TABLE EMP_COPY
AS SELECT * FROM EMPLOYEE;

SELECT * FROM EMP_COPY;

-- 1. 묵시적 커서
-- PL/SQL에서 EMP_COPY 테이블에 BONUS가 NULL인 사원의 BONUS를 0으로 수정
BEGIN
    UPDATE EMP_COPY
    SET BONUS = 0
    WHERE BONUS IS NULL;
    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || '행 수정됨');
END;
/

-- 2. 명시적 커서
-- PL/SQL에서 급여가 300만원 이상인 사원들 출력 (사번, 사원, 급여)
DECLARE
    EID EMP_COPY.EMP_ID%TYPE;
    ENAME EMP_COPY.EMP_NAME%TYPE;
    SAL EMP_COPY.SALARY%TYPE;
    
    CURSOR C1 IS SELECT EMP_ID, EMP_NAME, SALARY FROM EMP_COPY WHERE SALARY >= 3000000; 
BEGIN
    OPEN C1;
        LOOP
            FETCH C1 INTO EID, ENAME, SAL;
            EXIT WHEN C1%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE(EID || '' || ENAME || '' || SAL);
        END LOOP;
    CLOSE C1;
END;
/

-- FOR LOOP를 이용한 커서 사용
-- 1. LOOP 시작시 자동으로 커서 OPEN (즉 OPEN 필요 X)
-- 2. 반복할 때마다 FETCH도 자동
-- 3. LOOP 종료시 자동으로 커서 CLOSE
DECLARE
    EMP EMP_COPY%ROWTYPE;
    
BEGIN
    FOR EMP IN (SELECT * FROM EMP_COPY WHERE SALARY >= 3000000)
        LOOP
            DBMS_OUTPUT.PUT_LINE(EMP.EMP_ID || '' || EMP.EMP_NAME || '' || EMP.SALARY);
        END LOOP;
END;
/

/*
    PROCEDURE(프로시저)
     - PL/SQL 문을 저장하여 필요할 때마다
       복잡한 구문을 다시 입력할 필요 없이 간단하게 호출
    
    CREATE OR REPLACE PROCEDURE 프로시저명(
    매개변수 IN  OR OUT 데이터타입, ...
     - IN : 사용자로부터 값을 입력받아 PROCEDURE로 전달해주는 역할
     - OUT : PROCEDURE에서 호출 환경으로 값을 전달하는 역할
    )
    IS 선언부
    BEGIN 실행부
    EXCEPTION 예외처리부
    END 프로시저명;
    /
    
    호출시
    EXECUT(또는 EXEC) 프로시저명(매개값, ..);
    
    삭제
    DROP PROCEDURE 프로시저명;
*/

-- EMP_COPY 테이블의 모든 데이터를 삭제하는 프로시저 생성
CREATE OR REPLACE PROCEDURE DEL_ALL_EMP
IS
BEGIN
    DELETE FROM EMP_COPY;
END;
/

-- EXECUTE PROCEDURE
EXEC DEL_ALL_EMP;

SELECT * FROM EMP_COPY;
ROLLBACK;

-- 매개변수가 있는 프로시저
-- 사번을 입력받아서 해당하는 사원을 삭제하는 프로시저 생성
-- 프로시저명 : DEL_EMP_ID

CREATE OR REPLACE PROCEDURE DEL_EMP_ID(
EID EMP_COPY.EMP_ID%TYPE
)
IS
BEGIN
    DELETE FROM EMP_COPY
    WHERE EMP_ID = EID;
    COMMIT;
END DEL_EMP_ID;
/

EXEC DEL_EMP_ID('&사번');

ROLLBACK;
-- IN/OUT 매개변수가 있는 프로시저
-- 사번을 입력받아서 해당하는 사원의 이름, 급여를 전달하는 프로시저 생성
-- 프로시저명 : SEL_EMP_ID
-- 변수명 : EID - IN, ENAME - OUT, SAL - OUT

CREATE OR REPLACE PROCEDURE SEL_EMP_ID(
    EID IN EMPLOYEE.EMP_ID%TYPE,
    ENAME OUT EMPLOYEE.EMP_NAME%TYPE,
    SAL OUT EMPLOYEE.SALARY%TYPE
)
IS
BEGIN
    SELECT EMP_NAME, SALARY 
    INTO ENAME, SAL
    FROM EMP_COPY
    WHERE EMP_ID = EID;
END SEL_EMP_ID;
/

-- 바인드 변수 : VAR 변수명 데이터타입;
VAR VAR_EMP_NAME VARCHAR2(30);
VAR VAR_SALARY NUMBER;

EXEC SEL_EMP_ID('&사번', :VAR_EMP_NAME, :VAR_SALARY);

-- 바인드 변수에 담긴 값 출력
PRINT VAR_EMP_NAME;
PRINT VAR_SALARY;

/*
    FUNCTION (함수)
    
    - PROCEDURE와 거의 유사한 용도로 사용하지만 실행 결과를 되돌려 받을 수 있다.
    
    CREATE OR REPLACE FUNCTION 함수명(
    매개변수 데이터타입, ...
    )
    RETURN 데이터타입
    IS 선언부
    BEGIN 
        실행부
        RETURN 반환값;
    EXCEPTION 예외처리부
    END 함수명;
    /
    
    호출시
    EXECUTE 함수명(매개값, ..);
    
    삭제
    
    DROP PROCEDURE 함수명;
*/

-- 사번(EID)을 입력받아서 해당 사원의 연봉을 계산하여 리턴하는 함수 생성
-- 함수명 : SAL_CALC

CREATE OR REPLACE FUNCTION SAL_CALC (
    EID EMP_COPY.EMP_ID%TYPE
)
RETURN NUMBER
IS
    SAL EMP_COPY.SALARY%TYPE;
BEGIN
    SELECT SALARY
    INTO SAL
    FROM EMPLOYEE
    WHERE EMP_ID = EID;

    RETURN SAL * 12;
END SAL_CALC;
/

SELECT EMP_NAME, SALARY, SAL_CALC(EMP_ID)
FROM EMPLOYEE;

/*
    TRIGGER(트리거)
     - 테이블이나 뷰가 DML(INSERT, UPDATE, DELETE)문에 의해 변경될 경우
       자동으로 실행될 내용을 정의하여 저장
       
     CREATE OR REPLACE TRIGGER 트리거명
     BEFORE/AFTER INSERT/UPDATE/DELETE ON 테이블명
     FOR EACH ROW
     DECLARE 변수 선언
     BEGIN 실행내용 (지정된 이벤트 발생시 자동으로 실행할 구문)
     EXCEPTION 예외처리
     END;
     /
     
     - BEFORE : 이벤트가 발생되기 전에 트리거 실행
     - AFTER : 이벤트가 발생된 후에 트리거 실행
     
*/

-- EMPLOYEE 테이블에 새로운 행이 INSERT 될 때 '신입사원이 입사했습니다' 출력
-- 트리거명 : ADD_EMP

CREATE OR REPLACE TRIGGER ADD_EMP
AFTER INSERT ON EMP_COPY
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입사원이 입사했습니다');
END;
/

INSERT INTO EMP_COPY(EMP_ID, EMP_NAME) VALUES (400, '강성몬');

SELECT * FROM EMP_COPY;

-- :OLD : 수정, 삭제 전 데이터에 접근 가능
-- :NEW : 추가, 수정 후 데이터에 접근 가능
-- EMP_COPY 테이블에 UPDATE 수행 후 '변경 전 : 값, 변경 후 : 값' 출력
-- 트리거명 : PUT EMP

CREATE OR REPLACE TRIGGER PUT_EMP
AFTER UPDATE ON EMP_COPY
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('변경전 :' || :OLD.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('변경전 :' || :NEW.EMP_NAME);
END;
/

UPDATE EMP_COPY
SET EMP_NAME = '강성훈'
WHERE EMP_ID = 400;

SELECT * FROM EMP_COPY;

CREATE TABLE TB_PRODUCT(
    PCODE NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    PNAME VARCHAR2(30) NOT NULL, -- 상품명
    PRICE NUMBER, -- 상품 가격
    STOCK NUMBER DEFAULT 0 -- 재고 수량
);
INSERT INTO TB_PRODUCT(PNAME, PRICE, STOCK) VALUES('TV', 10000, DEFAULT);
INSERT INTO TB_PRODUCT(PNAME, PRICE, STOCK) VALUES('PHONE', 20000, 10);
INSERT INTO TB_PRODUCT(PNAME, PRICE, STOCK) VALUES('NOTEBOOK',15000, 20);

DROP TABLE TB_PRODETAIL;
CREATE TABLE TB_PRODETAIL(
    DCODE NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    PCODE NUMBER REFERENCES TB_PRODUCT,
    PDATE DATE DEFAULT SYSDATE, -- 상품입출고일
    AMOUNT NUMBER, -- 입출고수량
    STATUS CHAR(10) CHECK(STATUS IN ('입고', '출고')) -- 상태
);

-- 1번 TV 상품 오늘날짜로 10개 입고
INSERT INTO TB_PRODETAIL(PCODE, AMOUNT, STATUS) VALUES(1, 10, '입고');
--> 1번 TV 상품의 재고수량이 10개 증가
UPDATE TB_PRODUCT SET STOCK = STOCK + 10
WHERE PCODE = 1;
-- 2번 PHONE 상품 오늘날짜로 5개 출고
INSERT INTO TB_PRODETAIL(PCODE, AMOUNT, STATUS) VALUES(2, 5, '출고');
--> 2번 PHONE 상품의 재고수량이 5개 감소
UPDATE TB_PRODUCT SET STOCK = STOCK - 5
WHERE PCODE = 2;

-- TB_PRODETAIL 테이블에 INSERT 발생시
-- TB_PRODUCT 테이블에 매번 자동으로 재고수량 UPDATE 되게끔 트리거 정의
-- 트리거 명 : TRG_PRO


CREATE OR REPLACE TRIGGER TRG_PRO
AFTER INSERT ON TB_PRODETAIL
FOR EACH ROW
BEGIN
--입고
IF :NEW.STATUS = '입고'
THEN UPDATE TB_PRODUCT
     SET STOCK = STOCK + :NEW.AMOUNT
     WHERE PCODE = :NEW.PCODE;
END IF;
--출고
IF :NEW.STATUS = '출고'
THEN UPDATE TB_PRODUCT
     SET STOCK = STOCK - :NEW.AMOUNT
     WHERE PCODE = :NEW.PCODE;
END IF;
END;
/

INSERT INTO TB_PRODETAIL(PCODE, AMOUNT, STATUS) VALUES(3, 4, '출고');

SELECT * FROM TB_PRODETAIL;
SELECT * FROM TB_PRODUCT;