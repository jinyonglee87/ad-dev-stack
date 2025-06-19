package com.kh.step3;

import com.kh.step3.model.Calculator;

public class Application {

	public static void main(String[] args) {

		Calculator c = new Calculator();
		
		/*
		 변수와 메서드 호출 방법
		 
		 변수
		 참조변수.변수명;
		 클래스명.변수명; // static 변수 호출
		 
		 메서드
		 참조변수.메서드명(); // 파라미터(매개변수)가 없는 경우
		 참조변수.메서드(값1, 값2, ...); // 파라미터(매개변수)가 있는 경우
		 클래스명.메서드명();ㅣ // static메서드 호출
		 */
		c.a = 3;
		c.b = 4;
		
		System.out.println("더하기 : " + c.add());
		System.out.println("빼기 : " + c.sub());
		System.out.println("곱하기 : " + c.multiply(c.a, c.b));
		System.out.println("나누기 : " + (double)c.divide(c.a, c.b));
	}
	

}
