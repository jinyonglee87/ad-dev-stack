package com.kh.operator;

public class C_Arithmetic {
	/*
	 산술 연산자
	 
	 	+ : plus
	 	- : minus
	 	* : multiply
	 	/ : divide
	 	% : remaining
	 	
	 */
	public static void main(String[] args) {
		C_Arithmetic c = new C_Arithmetic();
//		c.method1();
		c.method2();
	}
	
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("+ : " + (num1 + num2)); // 10 + 3 = 13
		System.out.println("- : " + (num1 - num2)); // 10 - 7 = 7
		System.out.println("* : " + (num1 * num2)); // 10 * 3 = 30
		System.out.println("/ : " + (num1 / num2)); // 10 / 3 = 3 (실수가 아니라서 3, double로 했을시 3.333...)
		System.out.println("% : " + (num1 % num2));
		
	}
	
	public void method2() {
		int a = 5;
		int b = 10;
		int c = (++a) + b++; // a = 6, b = 10 = 16 = c
		System.out.println(c); // c = 16
		int d = c / a; // 16/5 = 2 = d
		int e = c % a; // 16 % 5 = 4 = e
		int f = e++; //  = 4 = f
		int g = (--b) + (d--); // 10 - 2 = g
		int h = c-- * b; // 15 * 10 = 150 = h
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h);
		
		// i = (5++) + (10) / (--(15) / (0) * ((13)-- - (3) % (++(0) + 150);
		// i = 16/
		System.out.println(c); // c = 14 ** the placement of print matters if final is not declared?
	}
	
		
		
}
