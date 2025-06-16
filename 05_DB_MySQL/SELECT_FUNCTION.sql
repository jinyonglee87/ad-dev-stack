/*
	LIMIT
    - ORDER BY 절보다 뒤에 조건을 걸고 싶을 때 사용
    - 출력되는 행 수를 제한하는 MySQL 전용 비표준 구문
    - 데이터 양을 제한하고자 할 때 유용 (페이징 처리)
*/

SELECT * FROM ACTOR
LIMIT 10;