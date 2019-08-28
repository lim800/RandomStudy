package lim.board.find;

import java.io.BufferedReader;
import java.io.IOException;

import lim.board.control.SJMAction;
import lim.board.dao.BoardDAO;

public class FindID implements SJMAction {
	public void execute(BufferedReader bufferedReader) throws IOException {
		System.out.println("검색할 아이디를 입력해라.");
		System.out.print("아이디: ");
		String id = bufferedReader.readLine();
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.IDfind(id);
	}

}
