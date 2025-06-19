package com.kh.step1;

import com.kh.step1.model.Tv;

public class Application { // 메인 실행 클래스 (객체 생성 및 테스트)
	/*
	 	Object (객체)
	 		- 현실 세계의 실제로 존재하는 사물이나 개념을 코드로 표현
	 	OOP (Objected-Oriented Programming, 객체 지향 프로그래밍)
	 		- 개발하는 방법을 여러 개의 "객체"로 나누어
	 		  각 객체마다 각자의 역할을 가지도록 구성
	 		- 코드의 재사용성이 높고, 유지보수가 용이하고, 확장성이 뛰어남
	 	OOP 특징
	 		1. Abstraction (추상화)
	 		2. Encapsulation (캡슐화)
	 		3. Inheritance (상속)
	 		4. Polymorphism (다형성)
	 	OOP 원칙
	 		S : Single Responsibility Principle (SRP) - 단일 책임 원칙
	 		O : Open/Closed Principle (OCP) - 개방 폐쇄 원칙
	 		L : Liskov Substitution Principle (LSP) - 리스코프 치환 원칙
	 		I : Interface Segregation Principle (ISP) - 인터페이스 분리 원칙
	 		D : Dependency Inversion Principle (DIP) - 의존 역전 원칙
	 	
	 	Class (클래스)
	 		- 객체를 만들기 위한 설계도
	 		- 속성(Variable) + 기능(Method)
	 */
	
	public static void main(String[] args) {
		/*
		 Object 생성
		 
		 class name = new classname();
		 
		 - new 연산자를 사용해서 생성
		 - new 연산자는 Heap 영역에 객체를 생성하고 객체의 주소값을 반환
		 - 객체의 주소값을 참조 타입의 변수에 저장해서 겍체 사용
		 */
		
		Tv tv = new Tv();
		// 객체 생성 => 메모리에 올란다 = 객체의 구성요소(field, method)가 다 올라간다
		System.out.println("TV status : " + tv.power); // false = TV off (default: !power)
		tv.power(); // TV on
		System.out.println("TV status : " + tv.power); // true = TV on
		
		System.out.println("TV channel " + tv.channel); // no default => 0
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		tv.channelDown();
		tv.channelDown();
		tv.channelUp();
		tv.channelUp();
		System.out.println("TV channel " + tv.channel); // channel = 3
		
	}

}
