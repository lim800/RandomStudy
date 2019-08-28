package hyeon.board.smboard.dao;

import java.util.List;


import hyeon.board.smboard.model.BoardVO;

public interface BoardDAO {

	List<BoardVO> getBoardList(int startArticleNum, int endArticleNum);

	int getTotalNum();

	int getSearchTotalNum(String type, String keyword);

	List<BoardVO> searchArticle(String type, String keyword, int startArticleNum, int endArticleNum);

	boolean writeArticle(BoardVO boardVO);

	int getMaxNum();
}