package com.kh.step3.model;

public class Calculator {

	/*
	 method
	 
	 	- 어떤 기능을 수행하는 명령문의 집합
	 	- parameter(입력값)을 받아서, return(결과값)을 돌려줄 수 있음
	 	- 단, 입력받는 값이 없을 수도 있고, 결과를 돌려주지 않을 수도 있음
	 	- 하나의 메서드는 한 가지 기능만 수행하도록 작성하는 것이 좋음 (SRP 원칙)
	 	- return 반관값이 없는 경우 리턴타입이 void
	 
	 return type methodName(parameter, ..){
	 	line of code
	 	return value;
	 }
	 
	 */
	
	public int a;
	public int b;
	
	// 더하기 : add
	public int add() { //use public void : when there is no value to return
		return a + b;
	}
	
	// 빼기 : substract
	public int sub() {
		return a - b;
	}
	
	// 곱하기 : multiply
	public int multiply(int a, int b) {
		return a * b;
	}
	
	// 나누기 : divide
	public static int divide(int a, int b) {
		return a / b;
	}
	
	// 나머지 : remain
}
