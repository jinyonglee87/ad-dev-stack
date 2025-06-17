package com.kh.operator;

import java.util.Scanner;

public class F_Triple {
	/*
	 triple calculation
	 
	 condition ? value1 : value2;
	 
	 	- 조건식에는 주로 비교, 논리 연산자가 사용된다.
	 	- 조건식의 결과가 true이면 값1을 반환한다.
	 	- 조건식의 결과가 false이면 값2를 반환한다.
	 */
	public static void main(String[] args) {
		F_Triple f = new F_Triple();
//		f.method1();
//		f.practice1();
//		f.practice2();
		f.practice3();
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		
		// 입력받은 정수가 양수인지 음수인지 판단
		System.out.println("정수값 >>");
		int number = sc.nextInt();
		
		String result = number > 0 ? "양수" : "음수";
		System.out.println(result);
		
		// +) 0인 경우는 0입니다
		String result2 = number > 0 
				? "양수" : 
				number == 0 ? "0" : "음수";
		System.out.println(result2);
		
	}
	// 문제 1
	/*
	 사용자한테 두 개의 정수값을 입력받아서 두 정수의 곱셈 결과 100보다
	 크거나 같은 경우 "결과가 100 이상입니다"
	 아닌 경우 "결과가 100보다 작습니다" 출력 
	 */
	public void practice1() {
		
		System.out.println("정수값 1 >>");
		int num1 = sc.nextInt();
		System.out.println("정수값 2 >>");
		int num2 = sc.nextInt();
		int multinum = num1 * num2;
		String result = multinum >= 100 ? "결과가 100보다 이상" : 
			multinum <= 100 ? "결과가 100보다 이하" : "결과가 100보다 이하";
		
		System.out.println(result);
	}
	// 문제 2
	/*
	 사용자한테 문자를 하나 입력받아서 입력한 문자가 대문자이면
	 "알파벳 대문자 입니다". 소문자이면 "알파벳 소문자 입니다"
	 둘다 아니라면 "알파벳이 아니네요.."
	 */
	public void practice2() {
		
		System.out.println("input character >");
		char ch = sc.nextLine().charAt(0);
		String result2 = 'A' <= ch && ch <= 'Z' ? "알파벳 대문자 입니다"
							   : 'a' <= ch && ch <= 'z'
							   ? "알파벳 소문자 입니다"
							   : "알파벳이 아니네요..";
		
		System.out.println(result2);
	}
	
	
	// 문제 3
	/*
	 사용자한테 숫자를 입력 받아서 해당 숫자가 알파벳 범위안에 들어 간다면
	 "알파벳 D입니다" 그게 아니면 "알파벳이 아닙니다"
	 */
	
	public void practice3() {
		
		System.out.println("input number >");
		int number = sc.nextInt();
		boolean result =
				'A' <= number && number <= 'a' ||
				'a' <= number && number <= 'z';
		System.out.println(result ? "알파벳 " + (char)number + "입니다" : "알파벳이 아닙니다");
	}
}
