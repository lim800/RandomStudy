package lim.board.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import hong.service.member.MemberLogin;

public class LoginMain {
	public static void main(String[] args) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		boolean isStop = false;
		do {
			System.out.println();
			System.out.println("=====어깨동무 게시판=====");
			System.out.print("1.로그인");
			System.out.print("\t2.회원가입");
			System.out.print("\t3.게시판");
			System.out.println("\t4.종료");
			System.out.println("번호를 선택하세요.");
			System.out.print("번호 입력: ");
			String menu = null;
			menu = bufferedReader.readLine();
			switch (menu) {
			case "1":
				MemberLogin memberLogin = new MemberLogin();
				memberLogin.execute(bufferedReader);
				break;
			case "2":
				MemberMain.main(null);
				break;
			case "3":
				BoardMain.boardmain();
				break;
			case "4":
				System.exit(0);
				break;
			}
		} while (!isStop);
	}
}