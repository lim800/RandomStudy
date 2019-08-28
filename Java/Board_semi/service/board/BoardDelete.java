package lim.service.board;

import java.io.BufferedReader;
import java.io.IOException;

import lim.board.dao.BoardDAO;

public class BoardDelete {

	public void execute(BufferedReader bufferedReader) throws IOException {
		BoardDAO boardDAO = new BoardDAO();
		System.out.print("������ �� ��ȣ�� �Է��ϼ��� .: ");
		int num = Integer.parseInt(bufferedReader.readLine());
		System.out.print("������ ���� ��й�ȣ�� �Է��ϼ��� .: ");
		String passwd = bufferedReader.readLine();
		boardDAO.deleteBoard(num, passwd);

	}
}
