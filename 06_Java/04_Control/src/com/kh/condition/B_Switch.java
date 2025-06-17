package com.kh.condition;

import java.util.Scanner;

public class B_Switch {

	Scanner sc = new Scanner(System.in);
	
	/*
	 Switch
	 
	 Switch(condition) {
	 	case value1 :
	 		when result meets value1, execute line1
	 		break;
 		case value2 :
 			when result meets value2, execute line2
 			break;
 		default :
 			when result doesn't meet any of above, execute line3
	 }
	 
	 	- case 문의 수는 제한이 없다
	 	- 조건식 결과는 정수, 문자, 문자열이어야 한다
	 	- 조건문을 빠져나가려면 break가 필요하다
	 	- default문은 생략 가능하다
	 */
	
	// 문제 1
	// 숫자를 입력받아
	// 1일 경우 "빨간색입니다"
	// 2일 경우 "파란색입니다"
	// 3일 경우 "초록색입니다"
	// 잘못입력했을 경우 "잘못입력했습니다"
	public void method1() {
		System.out.println("숫자를 입력하시오");
		int number = sc.nextInt();
	
		switch (number) {
		case 1:
			System.out.println("빨간색");
			break;
		case 2:
			System.out.println("파란색");
			break;
		case 3:
			System.out.println("초록색");
			break;
		case 4:
			System.out.println("노란색");
			break;
		case 5:
			System.out.println("보라색");
			break;
		default:
			System.out.println("잘못입력하셨습니다. 1~5 숫자를 입력하시오");
			}
		
	}
	
	// 주민번호를 입력받아 "남자"인지 "여자"인지 출력 (그 외에는 "사람이 아닙니다")
	// 주민번호 입력 : 000000 - 0000000
	// 남자
	public void method2() {
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
	
	public static void main(String[] args) {
		B_Switch b = new B_Switch();
//		b.method1();
		b.method2();
	}

}
