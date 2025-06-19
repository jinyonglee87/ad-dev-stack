package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class A_Array {
	
	/*
	 변서 : 하나의 공간에 하나의 값을 담음
	 배열 : 하나의 공간에 "여러개의 값"(같은 자료형의 값)을 담음
	 
	 배열의 선언
	 자료형[] 배열명;
	 자료형 배열명[];
	 - 배열을 선언한다고 해서 값을 저장할 공간이 생선되는 것이 아니라
	 	배열을 다루는데 필요한 변수가 생성
	 
	 배열의 초기화
	 배열명 = new 자료형[배열크기];
	 - 생성된 배열에 처음으로 값을 저장
	 
	 배열의 선언과 초기화 동시 진행
	 자료형[] 배열명 = new 자료형[배열크기];
	 */
	
	public void method1() {
		int[] nums = new int[5]; // 배열크기 지정하지 않으면 에러!
		System.out.println(nums);
		// 배열 생성하고 해당 값들은 초기화하지 않는 상태 -> 기본값이 들어감!
		// 정수형 : 0, 실수형 : 0.0, 문자형 : \u0000, 논리형 : false, 참조형 : null
		nums[0] = 100;
		nums[1] = 50;
		nums[2] = 43;
		nums[3] = 76;
		nums[4] = 89;
		
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);		
	}
	
	public void method2() {
		int[] nums = {100, 50, 43, 76, 89};
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		for(int value : nums) {
			System.out.println(value);
		}
	}
	
	/*
	 3 명의 키를 입력 받아 배열에 저장하고 3명의 키의 평균값을 구하시오
	 키 입력 > 100.0
	 키 입력 > 100.0
	 키 입력 > 100.0
	 100.0
	 */
	
	public void method3() {
		Scanner sc = new Scanner(System.in);
		double[] height = new double[3];
		double sum = 0;
		for(int i = 0; i < height.length; i++) {
			System.out.println("키 입력 > ");
			height[i] = sc.nextDouble();
			sum += height[i];
		}
		double avg = (sum)/ height.length;
		
		
		System.out.println("person 1 " + height[0] + "cm");
		System.out.println("person 2 " + height[1] + "cm");
		System.out.println("person 3 " + height[2] + "cm");
		System.out.println("평균 " + avg + "cm");
	}

	/*
	 배열의 복사
	 1. 얕은 복사 : 배열의 주소만 복사
	 2.
	 */
	public void method4() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = number;
		
		copy[1] = 7;
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
	}
	
	// 2. 깊은 복사 : 동일한 새로운 배열을 하나 생성해서 내부 값들도 함께 복사
	// 		- for문 사용
	public void method5() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = new int[number.length];
		
		for(int i = 0; i < number.length; i++) {
			copy[i] = number[i];
		}
		
		copy[1] = 7;
		System.out.println(Arrays.toString(number)); 
		System.out.println(Arrays.toString(copy)); 
	}
	// 2) System 클래스에서 제공하는 array copy() method
	// System.arraycopy(원본배열, 복사시작인덱스, 복사본배열, 복사시작인덱스, 복사할길이);
	public void method6() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = new int[number.length];
		
		System.arraycopy(number, 0, copy, 0, number.length);	
		copy[1] = 7;
		System.out.println(Arrays.toString(number)); 
		System.out.println(Arrays.toString(copy)); 
	}
	
	// 3) Arrays 클래스에서 제공하는 copyOf() 메서드
	// Arrays.copyOf (원본배열, 복사본배열길이);
	public void method7() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = Arrays.copyOf(number, number.length);
		
		copy[1] = 7;
		System.out.println(Arrays.toString(number)); 
		System.out.println(Arrays.toString(copy)); 
	}
	
	// 4) 배열의 clone() 메서드
	public void method8() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = number.clone();
		
		copy[1] = 7;
		System.out.println(Arrays.toString(number)); 
		System.out.println(Arrays.toString(copy)); 
	}
	public static void main(String[] args) {
		A_Array a = new A_Array();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
//		a.method5();
//		a.method6();
//		a.method7();
		a.method8();
	}

}
