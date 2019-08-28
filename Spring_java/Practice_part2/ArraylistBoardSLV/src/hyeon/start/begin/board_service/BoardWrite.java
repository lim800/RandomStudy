package hyeon.start.begin.board_service;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import hyeon.start.begin.board_bean_model.BoardBeanCommand;
import hyeon.start.begin.board_control.BoardAction;
import hyeon.start.begin.board_model.BoardCommand;

@Service
public class BoardWrite implements BoardAction {

	@Override
	public void execute(Scanner scanner) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("bean/bean.xml");
		BoardBeanCommand boardBeanCommand = (BoardBeanCommand) context.getBean("boardBeanCommand");

		System.out.println("게시판 글을 작성하세요.");

		System.out.print("작성자 : ");
		String author = scanner.next();
		System.out.print("이 메일 : ");
		String email = scanner.next();
		System.out.print("제목 : ");
		String subject = scanner.next();
		System.out.print("글 내용 : ");
		String content = scanner.next();
		System.out.print("비밀번호 : ");
		String passwd = scanner.next();
		BoardCommand boardCommand;
		boardCommand = boardBeanCommand.getBoardCommand();
		boardCommand.setAuthor(author);
		boardCommand.setSubject(subject);
		boardCommand.setEmail(email);
		boardCommand.setContent(content);
		boardCommand.setPasswd(passwd);

		// System.out.println(boardCommand);

		// 글을 추가한다.
		addArticle(boardCommand);
		System.out.println("게시글을 등록하였습니다.");
	}

	public void addArticle(BoardCommand boardCommand) {
		// 게시판의 글을 등록한다.
		arraylist.add(boardCommand);
	}
}
