package hyeon.start.begin.board_view;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hyeon.start.begin.board_service.BoardDelete;
import hyeon.start.begin.board_service.BoardList;
import hyeon.start.begin.board_service.BoardUpdate;
import hyeon.start.begin.board_service.BoardWrite;

public class BoardMain {
	public static void main(String[] args) {
		boolean isStop = false;
		ApplicationContext context = new ClassPathXmlApplicationContext("bean/bean.xml");
		Scanner scanner;
		scanner = (Scanner) context.getBean("scanner");

		do {

			System.out.println();
			System.out.println("메뉴를 입력하세요.");
			System.out.print("1.게시판 글 목록 보기" + "\t");
			System.out.print("2.게시판 글 등록" + "\t");
			System.out.print("3.게시판 글 수정" + "\t");
			System.out.print("4.게시판 글 삭제" + "\t");
			System.out.println("5.게시판 종료");
			System.out.print("메뉴 번호 입력 : ");
			String menu = scanner.next();

			switch (menu) {
			case "1":
				BoardList boardList;
				boardList = (BoardList) context.getBean("boardList");
				boardList.execute(scanner);
				break;
			case "2":
				BoardWrite boardWrite;
				boardWrite = (BoardWrite) context.getBean("boardWrite");
				boardWrite.execute(scanner);
				break;
			case "3":
				BoardUpdate boardUpdate;
				boardUpdate = (BoardUpdate) context.getBean("boardUpdate");
				boardUpdate.execute(scanner);
				break;
			case "4":
				BoardDelete boardDelete;
				boardDelete = (BoardDelete) context.getBean("boardDelete");
				boardDelete.execute(scanner);
				break;
			case "5":
				System.out.println("프로그램을 종료했습니다.");
				System.exit(0);
			}
		} while (!isStop);
	}
}
