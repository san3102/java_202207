package com.it.java.ssg;
import java.util.Scanner;

public class Sample {
	
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);
		int i = 1;
		while(true) {
			System.out.printf("명령어를 입력하세요) ");
			String command = sc.nextLine();
			command = command.trim();
			if(command.length()==0) {
				continue;
			}
			if(command.equals("system exit")) {
				break;
			}
			if(command.equals("article write")){
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				System.out.println(i + "번째 글이 생성되었습니다.");
				i++;
			}
			else if(command.equals("article list")) {
				System.out.println("게시글이 없습니다.");
			}else {
				System.out.println(command + "는 존재하지 않는 명령어 입니다.");
			}
		}
		
		sc.close();
		System.out.println("== 프로그램 끝 ==");
	}
}
