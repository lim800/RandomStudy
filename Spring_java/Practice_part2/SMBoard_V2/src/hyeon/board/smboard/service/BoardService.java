package hyeon.board.smboard.service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hyeon.board.smboard.dao.BoardDAO;
import hyeon.board.smboard.model.BoardVO;

@Service
public class BoardService implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private HashMap<String, Object> valueMap = new HashMap<String, Object>();

	@Override
	public List<BoardVO> getBoardList(int startArticleNum, int endArticleNum) {

		valueMap.put("startArticleNum", startArticleNum);
		valueMap.put("endArticleNum", endArticleNum);

		return sqlSessionTemplate.selectList("getBoardList", valueMap);
	}

	@Override
	public int getTotalNum() {

		return sqlSessionTemplate.selectOne("getTotalNum");
	}

	@Override
	public int getSearchTotalNum(String type, String keyword) {

		valueMap.put("type", type);
		valueMap.put("keyword", keyword);

		return sqlSessionTemplate.selectOne("getSearchTotalNum", valueMap);
	}

	@Override
	public List<BoardVO> searchArticle(String type, String keyword, int startArticleNum, int endArticleNum) {
		System.out.println(startArticleNum + "    " + endArticleNum);
		valueMap.put("type", type);
		valueMap.put("keyword", keyword);
		valueMap.put("startArticleNum", startArticleNum);
		valueMap.put("endArticleNum", endArticleNum);

		return sqlSessionTemplate.selectList("searchArticle", valueMap);
	}

	@Override
	public boolean writeArticle(BoardVO boardVO) {
		int num = getMaxNum();
		if (num == 0) {
			num = 1;
		} else {
			num = num + 1;
		}

		boardVO.setNum(num);

		sqlSessionTemplate.update("getBoardInsert", boardVO);
		return true;
	}

	@Override
	public int getMaxNum() {

		return sqlSessionTemplate.selectOne("getMaxNum");
	}

}
