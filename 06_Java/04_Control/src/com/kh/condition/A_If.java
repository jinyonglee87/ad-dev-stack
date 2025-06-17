package com.kh.condition;

import java.util.Scanner;

public class A_If {
	
	
	/*
	 if
	 
	 if( condition ) {
	 	condition is true then execute line
	 }
	 
	 - 보통 조건식에는 비교연산자, 논리연산자를 주로 사용
	 
	 if - else if - else
	 
	 if ( condition1 ) {
	 	condition1 is true
	 	then execute line
	 } else if ( condition2 ) {
	 	condition1 is false but condition2 is true
	 	then execute line
	 } else {
	 	condtion1 and condition2 is false
	 	then execute line
	 }
	 
	 */
	Scanner sc = new Scanner(System.in);
	public void method1() {
		// 입력받은 성적이 60점 이상이면 "합격입니다" 출력
		System.out.println("성적 점수 입력");
		int grade = sc.nextInt();
		
		
		System.out.println(grade >= 60 ? "yes" : "no");
			
//		if (grade >= 60) { 
//			System.out.println("합격입니다." + grade + "점 입니다");
//			
//		} else {
//			System.out.println("불합격입니다." + grade + "점 입니다");
//		}

		// 한줄일때만 {} 생략 가능
		// if (grade >= 60) System.out.println("합격입니다.")
		// else System.out.println("불합격입니다.")
	}
	
	
	public void method2() {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다",
		// 아니면 "본인이 아니다" 출력
		
		String name = "이진용";
		System.out.println("너의 이름은?");
		String nameInput = sc.nextLine();
		
		if (nameInput.equals(name)) System.out.println("지뇽쿤?!");
		else System.out.println("아니네..");
		
	}
	
	// 사용자에게 점수 0 ~ 100를 입력받아서 점수별로 등급 출력
	//	90+ = A
	//	80+ = B
	//	70+ = C
	//	60+ = D
	//	else = F
	public void method3() {
		System.out.println("너의 성적은?");
		int score = sc.nextInt();
		//char grade = '\u0000'; -- is reset
		//string grade = ""; -- blank is reset
		
		if(score < 0 || score > 100) {
			System.out.println("잘못 입력하셨습니다");
			return;
			}
		else if (score >= 90) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70 ) {
			System.out.println("C");
		} else if (score >= 60) {
			System.out.println("D");
		} else System.out.println("F");
	}
	// 세 정수를 입력했을 때 짝수만 출력
	//
	// num1 입력 : 3
	// num2 입력 : 4
	// num3 입력 : 8
	// 4
	// 8

	public void method4() {
		System.out.println("첫번째 정수를 입력하시오");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수를 입력하시오");
		int num2 = sc.nextInt();
		System.out.println("세번째 정수를 입력하시오");
		int num3 = sc.nextInt();
	
	
	if (num1 % 2 == 0) {System.out.println(num1);}
	if (num2 % 2 == 0) {System.out.println(num2);}
	if (num3 % 2 == 0) {System.out.println(num3);}
	
	}
	
	public static void main(String[] args) {
		A_If a = new A_If();
//		a.method1();
//		a.method2();
//		a.method3();
		a.method4();
		
	}

}
