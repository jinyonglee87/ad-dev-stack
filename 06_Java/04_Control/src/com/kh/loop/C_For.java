package com.kh.loop;

import java.util.Random;
import java.util.Scanner;

public class C_For {
	
	Scanner sc = new Scanner(System.in);
	private char[] arr;
	
	/*
	 for
	 
	 for(초기식; 조건식; 증감식) {
	 execute line
	 }
	 
	 	- 주어진 횟수만큼 코드를 반복 실행하는 구문
	 	- 초기식 : 반복문이 수행될 때 단 한 번만 실행,
	 	         반복문 안에서 사용할 변수를 선언하고 초기값 대입
	 	- 조건식 : 결과가 true이면 실행 코드를 실행
	 			 결과가 false이면 실행하지 않고 반복문을 빠져나감
	 */
	
	// 1 ~ 5 출력
	public void method1() {
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
			
		}
		
	}
	
	// 반대로
	public void method2() {
		for(int i = 1; i >= -5; i--) {
			System.out.println(i);
		}
	}
	
	// 1 ~ 10 홀수만 출력
	public void method3() {
		System.out.println("/////// v.1");
		for(int i = 1; i <= 10; i+=2) {
			System.out.println(i);
		}
		
		System.out.println("/////// v.2");
		for(int i = 1; i <= 10; i++) {
			if(i % 2 != 0) System.out.println(i);
		}
		
		/* 
		 Continue
			- continue 반복문 안에서 사용
			- 반복문 안에서 continue를 만나면 "현재 구문" 종료
			- 반복문을 빠져나가는 건 아님! 다음 반복 계속 수행
		*/
		System.out.println("/////// v.3");
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) continue;
			System.out.println(i);
		}
	}
	
	// 1 ~ 10까지의 합계
	public void method4() {
		for(int i = 1; i <= 10; i++) {
			
			System.out.println( (i * ( i + 1 ) ) / 2 );
		}
	}
	
	// 1부터 사용자가 입력한 수까지의 합계
	public void method5() {
		System.out.println("숫자를 입력하시오");
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.println((i * ( i + 1 ) ) / 2 );
		}
	}
	
	// 1부터 랜덥값까지의 합계
	public void method6() {
		int sum = 0;
		int x = (int)((Math.random() * 9) +2) ;
		for(int i = 1; i <= x; i++) {
			sum += i;
//			System.out.println((i * ( i + 1 ) ) / 2 );
//			
			System.out.println(sum + "합계");
		}
		
	}
	
	public void method7() {
		int sum = 0;
		Random random2 = new Random();
		int random3 = random2.nextInt(9) + 2;
		random2.nextInt(2,11);
		for(int i = 1; i <= random3; i++) {
			sum += i;		
			System.out.println(sum);
		}
	}
	
	/*
	 사용자한테 입력받은 문자열을 세로로 출력
	 사용자 입력 > hello
	 h
	 e
	 l
	 l
	 o
	 */
	public void method8() {
		System.out.println("아무 단어를 입력하세요 : ");
		String word = sc.nextLine();
		int x = word.length();
		for(int i = 0; i < x; i++) {
			System.out.println(word.charAt(i));
		}
		
		/*
		 for (simplified)
		 
		 for(datatype var : array){
		 	변수 : 배열의 값을 하나씩 가지고 옴
		 }
		 
		 toCharArray : 문자의 배열
		 	여러 개의 문자가 배열을 이룬 것이 문자열
		 		- toCharArray : 모든 문자가 들어 있는 char[] 형식의 데이터 반환
		 		- charAt(int index) : 인덱스에 있는 문자를 char형식으로 반환
		 */
		char[] arr = word.toCharArray();
		for(char ch : arr) {
			System.out.println(ch);
		}
	}

	// 중첩 for문
	/*
	 
	 *****
	 *****
	 *****
	 *****
	 
	 */
	
	public void method9() {
		for(int j = 0; j < 4; j++) {
		for(int i = 0; i < 5; i++) {
		System.out.print("*");
		}
		System.out.println();
		}
		System.out.println();
	}
	
	
	/*
		 
	 1****
	 *2***
	 **3**
	 ***4*
	 
	 */
	public void method10() {
		for(int i = 0; i <= 5; i++) {
			for(int j = 0; j <= 5; j++) {
//				System.out.print("(" + i + "," + j + ")");
				if(i == j) System.out.print(i+1);
				else System.out.print("*");
			
			}
			System.out.println();
		}

	}
	
	/*
	 
	 *
	 **
	 ***
	 ****
	 *****
	 
	 */
	public void method11() {
		for(int j = 0; j <= 4; j++) {
			for(int i = 0; i < 5; i++) {
//			System.out.print(i+j);
//			if((i+j) == 0)
//				System.out.print("*");
//			else if((i+j) == 1)
//				System.out.print("**");
//			else if((i+j) == 2)
//				System.out.print("***");
//			else if((i+j) == 3)
//				System.out.print("****");
//			else if((i+j) == 4)
//				System.out.print("*****");
			if(j>=i) System.out.print("*");
			}
			System.out.println();
			}
		
	}
	
	/*
	 
    * j=0, i=4
   ** j=0, i=3, i=4
  *** j=0, i=2, i=3, i=4
 **** j=0, i=1, i=2, i=3, i=4
***** j=0, i=0, i=1, i=2, i=3, i=4

*/

public void method12() {
	for(int i = 0; i <= 4; i++) {
		for(int j = 4; j >= 0; j--) {
			if(i < j) System.out.print(" ");
			else System.out.print("*");
			}
			System.out.println();
			}
		
	}
	public static void main(String[] args) {
		C_For c = new C_For();
//		c.method1();
//		c.method2();
//		c.method3();
//		c.method4();
//		c.method5();
//		c.method6();
//		c.method7();
//		c.method8();
//		c.method9();
//		c.method10();
//		c.method11();
		c.method12();
	}

}
