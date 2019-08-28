package hyeon.start.begin.board_service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import hyeon.start.begin.board_control.BoardAction;

@Service
public class BoardList implements BoardAction {

	@Override
	public void execute(Scanner scanner) {
		// TODO Auto-generated method stub
//		BoardCommand boardCommand = new BoardCommand();
//		System.out.println(boardCommand);

		if (arraylist.size() > 0) {
			// 배열의 크기로 글 목록을 반복한다.
			for (int i = 0; i < arraylist.size(); i++) {
				System.out.print("작성자: " + arraylist.get(i).getAuthor() + ", ");
				System.out.print("이 메일: " + arraylist.get(i).getEmail() + ", ");
				System.out.print("제목: " + arraylist.get(i).getSubject() + ", ");
				System.out.print("내용: " + arraylist.get(i).getContent());
				System.out.println();
			}

		} else {
			System.out.println("작성 된 게시물이 없습니다.");
		}

	}

}
