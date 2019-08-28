package hyeon.start.begin.board_service;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import hyeon.start.begin.board_bean_model.BoardBeanCommand;
import hyeon.start.begin.board_control.BoardAction;
import hyeon.start.begin.board_model.BoardCommand;

@Service
public class BoardUpdate implements BoardAction {

	@Override
	public void execute(Scanner scanner) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean/bean.xml");
		BoardBeanCommand boardBeanCommand = (BoardBeanCommand) context.getBean("boardBeanCommand");

		System.out.println("작성자와 비밀번호를 입력하세요.");
		System.out.print("작성자 : ");
		String author = scanner.next();
		System.out.print("비밀번호 : ");
		String passwd = scanner.next();
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
			} else {
				System.out.print("이 메일 : ");
				String email = scanner.next();
				System.out.print("글 제목 : ");
				String subject = scanner.next();
				System.out.print("글 내용 : ");
				String content = scanner.next();

				BoardCommand boardCommand;
				boardCommand = boardBeanCommand.getBoardCommand();
				boardCommand.setAuthor(author);
				boardCommand.setSubject(subject);
				boardCommand.setEmail(email);
				boardCommand.setContent(content);
				boardCommand.setPasswd(passwd);
				addArticle(boardCommand);
				System.out.println("수정하였습니다.");
			}
		}
	}

	private void addArticle(BoardCommand boardcommand) {
		arraylist.add(boardcommand);
	}

}
