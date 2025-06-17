package com.kh.operator;

import java.util.Scanner;

public class E_Logical {

	/*
	 Logic calculation
	 	- 두 개의 논리값을 연산해주는 연산자
	 	- 논리연산한 결과마저 논리값
	 	
	 논리값 && 논리값 (and) : 왼쪽, 오른쪽 둘다 true일 경우만 결과값이 true
	 논리값 || 논리값 (or) : 왼쪽, 오른쪽 둘 중 하나라도 true일 경우 결과값이 true
	 */
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		E_Logical e = new E_Logical();
//		e.method1();
//		e.method2();
		e.practice();
				
	}
	public void method1() {
		// 사용자가 입력한 정수값이 1 부터 100 사이의 값인지 확인
		System.out.print("정수값 입력 > ");
		int number = sc.nextInt();
		System.out.print(1 <= number && number <= 100); // &&
	}
	public void method2() {
		int number = 10;
		boolean result = false;
		
		//  &&
		// short Cut Evaluation
		// true && true = true
		// true && false = false
		// false && true = false
		// false && false = false
		// && 연산자를 기준으로 앞에서 이미 false이면
		// 굳이 뒤쪽 연산 수행하지 않는다
		result = (number < 5) && (++number > 0);
		
		System.out.println(result);
		System.out.println(number);
		
		// ||
		// true || true = true
		// true || false = true
		// false || true = true
		// false || false = false
		// || 연산자를 기준으로 앞에서 이미 true이면
		// 굳이 뒤쪽 연산 수행하지 않는다
		result = (number < 20) || (++number > 0);
		System.out.println(result);
		System.out.println(number);
	}
		/*
		 문제
		 
		 사용자가 입력한 문자 값이 알파벳인지 확인하기
		 A ~ Z : 65 ~ 90
		 a ~ z : 97 ~ 122
		 
		*/
		 public void practice(){
				System.out.print("input > ");
				char input = sc.nextLine().charAt(0);
				boolean result =
					(65 <= input && input <= 90) ||
					(97 <= input && input <= 122);
				result = ('A' <= input && input <= 'Z') ||
						('a' <= input && input <= 'z');
				System.out.print(result); // &&
		 }
}
