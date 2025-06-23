package com.kh.inheritance;

import com.kh.inheritance.model.NoteBook;
import com.kh.inheritance.model.SmartPhone;

public class Application {

	public static void main(String[] args) {
		NoteBook notebook = new NoteBook("애플", "app-01", "맥북 프로", 2390000, "M4");
		SmartPhone phone = new SmartPhone("삼성", "sam-01", "갤럭시 S25 울트라", 1841400, "KT");
	}

}
