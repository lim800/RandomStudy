package lim.board.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import hong.service.member.MemberDelete;
import hong.service.member.MemberJoin;
import hong.service.member.MemberList;
import hong.service.member.MemberUpdate;

public class MemberMain {
	public static void main(String[] args) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		boolean isStop = true;
		while (isStop) {
			System.out.println();
			System.out.println("==회원가입==");
			System.out.print("1. 회원가입");
			System.out.print("\t2. 회원정보 확인");
			System.out.print("\t3. 회원정보 수정");
			System.out.print("\t4. 회원정보 삭제");
			System.out.println(" " + "5. 종료");
			System.out.println("번호를 선택하십쇼");
			System.out.print("번호 입력 : ");
			String menu = null;
			menu = bufferedReader.readLine();
			switch (menu) {
			case "1":
				MemberJoin.join(bufferedReader);
				break;
			case "2":
				MemberList memberList = new MemberList();
				memberList.execute(bufferedReader);
				break;
			case "3":
				MemberUpdate memberUpdate = new MemberUpdate();
				memberUpdate.execute(bufferedReader);
				break;
			case "4":
				MemberDelete memberDelete = new MemberDelete();
				memberDelete.execute(bufferedReader);
				break;
			case "5":
				System.exit(0);
				isStop = false;
				break;
			default:
				break;
			}
		}
	}
}
