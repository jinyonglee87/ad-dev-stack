package com.kh.loop;

import java.util.Random;
import java.util.Scanner;

public class D_While {
	Scanner sc = new Scanner(System.in);

	
	/*
	 while
	 
	 while(condition) {
	 	when true, continue line
	 }
	 */
	
	// 1 ~ 5
	public void method1() {
		int i = 1;
		while(i <= 5) {
			System.out.println(i);
			i++;
		}
	}
	
	/*
	 infinite loop & break;
	 	- switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 	- 반복문이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나간다
	 	
	 	while(true) {
	 		
	 	}
	 	
	 */
	public void method2() {
		while(true) {
			System.out.println("숫자입력 > ");
			int num = sc.nextInt();
			System.out.println(num);
			if(num == 0) break;
		}
	}
	
	/*
	 do {
	 line is executed
	 } while (condition);
	 
	 	- 조건과 상관없이 무조건 한 번은 실행
	 
	 */
	public void method3() {
		int number = 1;
		
		while(number == 0) {
			System.out.println("while");
		}
		
		do {
			System.out.println("do-while");
		} while(number == 0);
	}
	
	/*
	 숫자 맞히기 게임
	 1과 100사이의 값을 정답을 저희가 정하고
	 컴퓨터(random)가 맞히도록! 몇 번만에 끝내는지 출력!
	 해당 숫자보다 정답이 높으면 Up! 낮으면 Down!
	 */
	public void method4() {
		System.out.println("숫자 입력해줘 >");
		int number = sc.nextInt();
		int min = 1;
		int max = 100;
		int count = 0;
		while(true) {
			++count;
			int random = (int)(Math.random() * (max - min + 1) + min);
			if (number > random) {
				System.out.println(random + ", up!");
				min = random + 1;
			} else if (number < random) {
				System.out.println(random + ", down!");
				max = random - 1;
			} else {
				System.out.println(random + ", bingo!" + count + "회 만에 맞췄습니다.");
				break;
			}
		}
	}
	
	/*
	 숫자 맞히기 게임 2
	 
	 컴퓨터(random) 1과 100사이의 값 중에
	 저희가 정답을 맞히도록! 몇 번만에 끝내는지 출력!
	 해당 숫자보다 정답이 높으면 up! 낮으면 Down!
	 */
	
	public void method5() {
		int random = (int)(Math.random() * 100 + 1);
		int count = 0;
		while(true) {
			count++;
			System.out.println("숫자를 입력해주세요 > ");
			int number = sc.nextInt();
			
			if (random > number) {
				System.out.println("Up!");
			} else if (random < number) {
				System.out.println("Down!");
			} else {
				System.out.println("bingo! " + count + "회 만에 맞혔습니다" );
				break;
			}
		}
	}
	
	/*
	 ----------------------------------
	 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 ----------------------------------
	 	선택 > 1. 예금
	 	예금액 > 10000
	 ----------------------------------
	 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 ----------------------------------
	 	선택 2.  출금
	 	출금액 > 5000
	 ----------------------------------
	 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 ----------------------------------
	 	선택 3. 잔고
	 	출금액 > 5000
	 ----------------------------------
	 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 ----------------------------------
	 	선택 4. 종료
	 	프로그램 종료
	 */
	public void method6() {
		int balance = 0;
		while(true) {
				System.out.println("---------------------------------");
				System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
				System.out.println("---------------------------------");
				System.out.println("원하는 서비스 번호를 입력 해주세요 >");
				int input = sc.nextInt();
				
				if(input == 1) {
					System.out.print("예금액 > ");
					int deposit = sc.nextInt();
					balance += deposit;
				} else if (input == 2) {
					System.out.print("출금액 > ");
					int withdrawal = sc.nextInt();
					balance -= withdrawal;
				} else if (input == 3) {
					System.out.print("예금액 > ");
					System.out.println(balance);
				} else if (input == 4) {
					System.out.print("프로그램 종료");
					break;
				}
			}
			
		}

	/*
	 사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요.
	 컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고
	 사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지
	 */
	public void method7() {
		String rock = "rock";
		String paper = "paper";
		String scissor = "scissor";
		
		System.out.println("가위바위보 게임 시작 > ");
		String input = sc.nextLine();
		String[] game = {rock, paper, scissor};
		int compute = (int)(Math.random() * game.length);
		String computer = game[compute];
		System.out.println("[user] " + input + " vs " + computer + " [ai]");
		
		if (input == computer) {
			System.out.println("draw");
		} else if (input == rock && computer == paper) {
			System.out.println("computer wins");
		} else if (input == paper && computer == scissor) {
			System.out.println("computer wins");
		} else if (input == scissor && computer == rock) {
			System.out.println("computer wins");
		} else {
			System.out.println("user wins");
		}
			
		System.out.println("test:" + computer);
	}
	
	public static void main(String[] args) {
		D_While d = new D_While();
//		d.method1();
//		d.method2();
//		d.method3();
//		d.method4();
//		d.method5();
//		d.method6();
		d.method7();
	}

}
