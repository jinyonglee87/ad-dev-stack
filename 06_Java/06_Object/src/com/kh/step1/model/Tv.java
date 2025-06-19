package com.kh.step1.model;

public class Tv {
	
	/*
	 1. Abstraction :
	 		- 공통적인 특성만 뽑아내어 단순화
	 		- 개발하는데 중요한 것만 뽑고 불필요한 정보는 숨긴다
	 */
	
	// TV라는 객체의 설계도 클래스
	// properties (속성)
	// 	- member variable, field, attribute
	public boolean power; // 전원상태(on/off)
	public int channel; // 채널
	
	// function (기능)
	// 	- method, function
	public void power() { // TV를 끄거나 키는 기능
		power = !power;
	}
	
	public void channelUp() { // 채널 번호를 올리는 기능
		channel++;
	}
	
	public void channelDown() { // 채널 번호를 내리는 기능
		channel--;
	}
}
