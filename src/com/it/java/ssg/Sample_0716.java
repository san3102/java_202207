package com.it.java.ssg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sample_0716 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 0;

		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("명령어) ");
			String command = sc.nextLine();
			command = command.trim();
			if (command.length() == 0) {
				continue;
			}
			if (command.equals("system exit")) {
				break;
			}
			if (command.equals("article write")) {
				int id = i + 1;
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				Article article = new Article(id, title, body);
				articles.add(article);
				System.out.println(id + "번 글이 생성되었습니다.");
				i++;
			} else if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;
				}
//				1번 게시물부터 2,3,4 순으로 정렬
				System.out.println("번호  |   제목");
				for (int j = 0; j < articles.size(); j++) {
					Article article = articles.get(j);
					System.out.printf("%d   |  %s\n", article.id, article.title);
				}
//				최신 게시물부터 출력
//				for(int j = articles.size()-1; j>=0; j--) {
//					Article article = articles.get(j);
//					System.out.printf("%d  |  %s\n", article.id, article.title);
//				}
			} else if (command.startsWith("article detail")) {
				String[] commandbits = command.split(" ");
//				commandbits[0]; > article
//				commandbits[1]; > detail
//				commandbits[2]; > numbers
				int id = Integer.parseInt(commandbits[2]);
//				boolean found = false;
				Article foundArticle = null;

				for (int j = 0; j < articles.size(); j++) {
					Article article = articles.get(j);
					if (article.id == id) {
//						found = true;
						foundArticle = article;
						break;
					}
				}
//				if (found == false) {
//					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
//					continue;
//				}
				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				System.out.printf("번호 : %d\n", foundArticle.id);
				System.out.printf("날짜 : 2022-07-16 12:41:15\n");
				System.out.printf("제목 : %s\n", foundArticle.title);
				System.out.printf("내용 : %s\n", foundArticle.body);

			} else {
				System.out.println(command + "는 존재하지 않는 명령어 입니다.");
			}
		}

		sc.close();
		System.out.println("== 프로그램 끝 ==");
	}
}

class Article {
	int id;
	String title;
	String body;

	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}