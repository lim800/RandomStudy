package hyeon.start.begin.board_service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import hyeon.start.begin.board_control.BoardAction;

@Service
public class BoardDelete implements BoardAction {

	@Override
	public void execute(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("제거할 글의 작성자와 비밀번호를 입력하세요.");
		System.out.print("작성자 : ");
		String author = scanner.next();
		System.out.print("비밀번호 : ");
		String passwd = scanner.next();
		removeArticle(author, passwd);

	}

	public void removeArticle(String author, String passwd) {
		if (arraylist.size() > 0) {
			int index = -1;
			for (int i = 0; i < arraylist.size(); i++) {
				if (arraylist.get(i).getAuthor().equals(author)) {
					if (arraylist.get(i).getPasswd().equals(passwd)) {
						arraylist.remove(arraylist.get(i));
						index = i;
					}
				}
			}
			if (index == -1) {
				System.out.println("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.");
				return;
			}
		}
		System.out.println("삭제하였습니다.");
	}

}
