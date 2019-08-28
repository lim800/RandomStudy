package hyeon.start.begin.board_bean_model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hyeon.start.begin.board_model.BoardCommand;

@Service
public class BoardBeanCommand {
	// 데이터 베이스 컬럼과 일치한다.
	@Autowired
	private BoardCommand boardCommand;

	public BoardCommand getBoardCommand() {
		return boardCommand;
	}

//	public void setBoardCommand(BoardCommand boardCommand) {
//		this.boardCommand = boardCommand;
//	}
//	

}
