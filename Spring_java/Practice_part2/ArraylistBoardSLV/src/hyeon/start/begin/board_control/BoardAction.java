package hyeon.start.begin.board_control;

import java.util.ArrayList;
import java.util.Scanner;

import hyeon.start.begin.board_model.BoardCommand;

public interface BoardAction {

	// 게시판 게시물 정보 담을 공간
	ArrayList<BoardCommand> arraylist = new ArrayList<BoardCommand>();

	// 입력 받은 값으로 동작을 실행할 추상메소드
	public void execute(Scanner scanner);
}
