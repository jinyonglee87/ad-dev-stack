package com.kh.variable;

public class A_Variable {
	/*
	 Variable : 값을 저장하는 "공간"
	 	- 
	 	-
	 */
	public static void main(String[] args) {
		// 실행할 메서드가 있는 클래스 생성 (new)
		A_Variable variable = new A_Variable();
		
		// 생성한 클래스로 메서드 실행(호출)
//		variable.printValue();
//		variable.variableTest();
		variable.constant();
	}

	public void printValue() {
		// 원의 둘레와 원의 넓이를 출력
		// circumference of circle = r * 2 * 3.14
		// Area of circle = r * r * 3.14
		
		System.out.println(30 * 2 * 3.141592);
		System.out.println(30*30*3.141592);
		
		// 변수 사용해서
		int r = 30;
		double pi = 3.141592;
		System.out.println(r*r*pi);
	}
	
	public void variableTest() {
		/*
		Variable declare
		
			자료형 변수명;
				- 자료형 : 어떤 값을 저장할지, 어떤 크기의 메모르를 할당받을지
				  대한 정보
				- 변수명 : 변수의 이름으로 값을 읽고, 쓰고 지우는 작업을 할 때 사용
			
			변수의 초기화
			
			변수명 = 값;
				- 변수에 처음으로 값을 저장하는 것
				- '='는 오른쪽 값을 왼쪽 변수에 대입하는 연산자
		*/
		/*
		 Primitive type : 실제 값을 저장
		 	- stack memory 생성된 공간에 실제 변수값이 저장
		 	
		 */
		 	// 1. 논리형 : 1byte = 8bit
		boolean isTrue; //변수 선언
		isTrue = true; //변수 초기화

		boolean isFalse = false;
			// 2. 문자형 : 2byte = 16bit
		char ch = 'a';
			// ch = 'ab'; -> error
		
			// 3. 정수형
		byte bNum = 1; // 1byte(=8bit) -> 2^8 = 256 (-128 ~ 127)
		// bNum = 128; error due to overflow
		short sNum = 128; // 2byte(=16bit) 2^16
		int iNum = 922337283; // 4byte
		long lNum = 922337283458L; //need L in the end // 8byte
		
		System.out.println(lNum);
		
			// 4. 실수형
		float fNum = 1.2F; // 4byte - 숫자 뒤에 F를 입력
		double dNum = 1.2; // 8byte
		
		System.out.println(fNum);
			
			// 참조 자료형 (class) : 4byte, 기본형을 제외한 나머지
			// 주소값 저장
			// 대문자로 시작한 syntax는 class
			// 실제 데이터 값은 힙 메모리에 저장하고
			// 스택 메모리의 변수 공간에는 실제 변수값이 저장된 힘 메모리의
			// 위치값 저장
		String name = "이진용";
		String name2 = new String("이진용");
		
		System.out.println(name2);
			
			// 변수의 네이밍 규칙
			// 1. 대소문자 구분
		int number;
		int NUMBER;
		int Number;
			// String number; 자료형이 달라도 변수명이 같은 에러!
			// 2. 숫자로 시작하면 안된다.
			// int 1age; -- error
			// int a2g3e4;; -- acceptable
		
			// 3. 특수 문자는 '_', '$'만 사용 가능
		int _age;
		int $age;
		int _age$;
			// int #age; -- error
		
			// 4. Reserved word를 사용하면 안된다
			// int public;
			// int void2;
			
			// 5. (권장사항) 낙타표기법(카멜케이스)
			// 첫글자는 항상 소문자, 여러 단어가 오면 대문자
		int maxnumber;
		int max_number; // Java에서 x, pthon 에서 0 (스네이크 기법)
		int maxNumber; //in Java	
	}
	
	public void constant() {
		/*
		 상수
		 final 자료형 변수명;
		 
		 	- 변하지 않는 값으로 특정 변수의 값이 변경되는 걸 원하지 않을 때 사용
		 	- 초기화 이후에는 값을 변경할 수 없다.
		 	- 상수의 네이밍 규칭은 대문자로 표기, 여러 단어가 오면 _로 구분
		 */
		int age = 20;
		age = 25;
		System.out.println(age);
		
		final int MAX_AGE = 25;
		MAX_AGE = 20;
		System.out.println(MAX_AGE);
			}
}
