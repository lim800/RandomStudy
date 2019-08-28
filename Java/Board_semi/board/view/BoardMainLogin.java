package lim.board.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lim.board.control.SJMAction;
import lim.board.dao.BoardDAO;
import lim.board.find.FindID;
import lim.service.board.BoardDelete;
import lim.service.board.BoardUpdate;
import lim.service.board.BoardWrite;

public class BoardMainLogin implements SJMAction {

	public static void boardlogin() throws IOException {
		boolean isStop = false;
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		BoardDAO boardDAO = new BoardDAO();

		do {
			System.out.println();
			System.out.println("==게시판 페이지==");
			System.out.print("1.등록");
			System.out.print("   2.검색(아이디)");
			System.out.print("   3.목록");
			System.out.print("   4.수정");
			System.out.print("   5.삭제");
			System.out.print("   6.회원관리");
			System.out.println("   7.종료");
			System.out.println("번호를 선택하세요.");
			System.out.print("번호 입력: ");
			String menu = null;
			menu = bufferedReader.readLine();

			switch (menu) {
			case "1":
				BoardWrite writeArticle = new BoardWrite();
				writeArticle.execute(bufferedReader);
				break;
			case "2":
				FindID findID = new FindID();
				findID.execute(bufferedReader);
				break;
			case "3":
				boardDAO.showListBoard();
				break;

			case "4":
				BoardUpdate updateArticle = new BoardUpdate();
				updateArticle.execute(bufferedReader);
				break;
			case "5":
				BoardDelete deleteArticle = new BoardDelete();
				deleteArticle.execute(bufferedReader);
				break;

			case "6":
				MemberMain.main(null);
				break;
			case "7":
				System.exit(0);
				break;
			}
		} while (!isStop);

	}

	@Override
	public void execute(BufferedReader bufferedReader) throws IOException {
		// TODO Auto-generated method stub

	}

}
