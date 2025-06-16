package com.kh.variable;

import java.util.Scanner;

public class D_Scanner {
	/*
	 	Scanner
	 		- Console에서 데이터를 "입력"받는 클래스
 		1. import java.util.Scanner; 추가
 		2. Scanner 객체 생성
 		   Scanner sc = new Scanner(System.in);
 		3. Scanner method 사용
 		   입력값이
 		   	- 문자열일 때 : sc.next() - 공백 있을 경우 공백 이전까지
 		   	            : sc.nextLine() - 공백 포함 엔터 전까지
            -> 권장하기는 sc.nextLine()만 사용하는 것을 권장!
               nextLine만 enter 처리
            - 정수일 때 : sc.nextInt()
            - 실수일 때 : sc.nextFloat(), sc.nextDouble()
            
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 이름
		System.out.printf("당신의 이름을 무엇입니까? > ");
		String name = sc.next();
		
		// 나이
		System.out.printf("당신의 나이는 몇살입니까? >");
//		int age = sc.nextInt(); //no enter
//		sc.nextLine(); //yes enter
		
		// String -> int
		int age = Integer.parseInt(sc.next());
		
		// 주소
		System.out.printf("당신의 집은 어디십니까? >");
		String addr = sc.next();
		
		// 키
		System.out.printf("당신의 키는 몇입니까? >");
		float height = sc.nextFloat();
//		double height = Double.parseDouble(sc.nextLine());
		// 성별
		System.out.printf("당신은 수컷입니까 암컷입니까?");
		char gender = sc.next().charAt(0);
		
		System.out.println(age + "년간 " + addr + "에 서식하는 " + gender + "컷" + height + "cm " + name + "은 오늘도 자바칩 쿠키 먹는다");
		System.out.printf("이름은 %s이고, 나이는 %d살이고, 사는 곳은 %s이고, 키는 %.1fcm이고, 성별은 %s", name, age, addr, height, gender);
	
	}
		
	}


