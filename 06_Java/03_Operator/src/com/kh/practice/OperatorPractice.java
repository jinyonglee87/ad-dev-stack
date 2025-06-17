package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
	
	Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {

		OperatorPractice o = new OperatorPractice();
		o.method1();
		o.method2();
		o.method3();
		o.method4();
		o.method5();
		o.method6();
		o.method7();
		o.method8();
		
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		int pencil = 10;
		int people = 8;
		System.out.println("문제 1.");
		System.out.println("연필 개수는 " + pencil
						   + "개이고, 인원수는 " + people + "명 이다, 그리고 남은 연필 개수는 "
					       + pencil % people + "개다.");
	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.println("문제 2.");
		System.out.println("숫자를 100 ~ 500 사이로 입력하세요 > ");
		int number = sc.nextInt();
//		short deduce = (short) number;
		
		if (number < 100 || number > 500) {
			System.out.println("다시 숫자를 100 ~ 사이로 입력하세요 > ");
			return;
			}
		
		else {
			System.out.println((number/100) * 100);
			return;
			}
		
	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.println("문제 3.");
		System.out.println("3개 수가 맞는지 아닌지 확인하겠습니다. 첫번째 수를 입력해주세요");
		System.out.println("첫번째 수를 입력해주세요 >");
		int num1 = sc.nextInt();
		System.out.println("두번째 수를 입력해주세요 >");
		int num2 = sc.nextInt();
		System.out.println("세번째 수를 입력해주세요 >");
		int num3 = sc.nextInt();
		
		if (num1 == num2 || num1 == num3) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.println("문제 4.");
		System.out.println("입력할 숫자가 짝수인지 아닌지 알아볼게요 > ");
		int num1 = sc.nextInt();
		
		if (num1 % 2 == 0) {
			System.out.println("짝수 입니다.");
		} else {
			System.out.println("짝수가 아닙니다.");
		}
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	public void method5() {
		System.out.println("문제 5.");
		System.out.println("주민번호를 입력하시오(000000-0000000) >");
		String social = sc.nextLine();
		char gender = social.charAt(7);
		
		switch (gender) {
		case '1':
		case '3':
			System.out.println("남자");
			break;
		case '2':
		case '4':
			System.out.println("여자");
			break;
		default: System.out.println("사람이 아닙니다");
		}
	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 
	//성인(19세 초과)인지 출력하세요.
	public void method6() {
		
	}

	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		
	}
	
	//초 단위 시간을 입력받아 1시간 1분 1초 형식으로 출력
	public void method8() {
		
	}
	
}