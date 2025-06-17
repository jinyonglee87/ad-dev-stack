package com.kh.variable;

public class C_Printf {

	public static void main(String[] args) {
		System.out.println("Hello"); //println = ln = 줄바꿈
		System.out.print("Hello\n"); //print = 줄바꿈 x
		// ln = 줄바꿈
		// \n = 줄바꿈
		
		// printf(출력하고자하는 형식 포맷, 출력하고자하는 값, 값, ..)
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10% 20%
		System.out.println(iNum1 + "%" + " " + iNum2 + "%");
		// 출력하고자 하는 값들이 제시한 형식에 맞춰서 출력만 진행
		System.out.printf("%d%% %d%%", iNum1, iNum2);
		
		/*
		 format에 쓰이는 키워드
		 	1. %d : 정수
		 	2. %f : 실수
		 	3. %c : 문자
		 	4. %s : 문자열 (문자도 가능)
		 */
		System.out.println();
		System.out.printf("%5d\n", iNum1); // 5칸 확보 후 오른쪽 정렬
		System.out.printf("%-5d\n", iNum2); // 왼쪽 정렬
		
		double dNum1 = 1.23456789;
		double dNum2 = 4.53;
		System.out.printf("%f \t %f \n", dNum1, dNum2);
		// 무조건 소수점 아래 6번째 자리까지
		
		 
		System.out.printf("%.3f \t %.1f \n", dNum1, dNum2);
		// 소수점 .000, 소수점 .0
		
		char ch = 'a';
		String str = "Hello";
		System.out.printf("%C \t %S \t %s", ch, str, ch);
		// %c = lower case
		// %C = upper case
		// %s = lower case
		// %S = upper case
		
		
	}
	
}
