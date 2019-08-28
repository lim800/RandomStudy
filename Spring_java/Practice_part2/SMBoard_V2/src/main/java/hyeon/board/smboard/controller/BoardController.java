package hyeon.board.smboard.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import hyeon.board.smboard.model.BoardVO;
import hyeon.board.smboard.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	private int currentPage = 1;
	private int showArticleLimit = 10; // 한줄에 페이지에 나오는 데이터 수
	private int showPageLimit = 10; // 한줄에 나오는 데이터수

	private int startArticleNum = 0;
	private int endArticleNum = 0;
	private int totalNum = 0;

	// 맨처음 게시판 조회 화면
	@RequestMapping(value ="/BoardList.do")
	public ModelAndView BoardList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("aaaa");
		// 검색 키워드랑 타입 변수
		String type = null;
		String keyword = null;

		// 현재 페이지 설정
		if (request.getParameter("page") == null || request.getParameter("page").trim().isEmpty()
				|| request.getParameter("page").equals("0")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		// 타입변수 받기
		if (request.getParameter("type") != null) {
			type = request.getParameter("type").trim();
		}

		// 검색 키워드 받아오기
		if (request.getParameter("keyword") != null) {
			keyword = request.getParameter("keyword").trim();
		}

		System.out.println(type + "   " + keyword);

		
		
		//여기까지 오케이
		
		
		
		
		// 시작 게시글 번호
		startArticleNum = (currentPage - 1) * showArticleLimit + 1;
		// 마지막 게시글 번호
		endArticleNum = startArticleNum + showArticleLimit - 1;

		List<BoardVO> boardList;
		if (type != null && keyword != null) {
			boardList = boardService.searchArticle(type, keyword, startArticleNum, endArticleNum);
			totalNum = boardService.getSearchTotalNum(type, keyword);
		} else {
			boardList = boardService.getBoardList(startArticleNum, endArticleNum);
			totalNum = boardService.getTotalNum();
		}
		StringBuffer pageHtml = getPageHtml(currentPage, totalNum, showArticleLimit, showPageLimit, type, keyword);
		//

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("boardList", boardList);
		modelAndView.addObject("totalNum", totalNum);
		modelAndView.addObject("pageHtml", pageHtml);
		modelAndView.setViewName("/board/board_list");

		return modelAndView;
	}

	// 하단 페이징 부분 처리 코드
	private StringBuffer getPageHtml(int currentPage, int totalNum, int showArticleLimit, int showPageLimit,
			String type, String keyword) {
		StringBuffer pageHtml = new StringBuffer();
		int startPage = 0;
		int lastPage = 0;

		// expression page variables
		startPage = ((currentPage - 1) / showPageLimit) * showPageLimit + 1;
		lastPage = startPage + showPageLimit - 1;

		if (lastPage > totalNum / showArticleLimit) {
			lastPage = (totalNum / showArticleLimit) + 1;
		}

		if (type == null && keyword == null) {
			if (currentPage == 1) {
				pageHtml.append("<span>");
			} else {
				pageHtml.append("<span><a href=\"/BoardList.do?page=" + (currentPage - 1) + "\"><이전></a>&nbsp;&nbsp;");
			}

			for (int i = startPage; i <= lastPage; i++) {
				if (i == currentPage) {
					pageHtml.append(".&nbsp;<strong>");
					pageHtml.append("<a href=\"BoardList.do?page=" + i + "\" class=\"page\">" + i + "</a>");
					pageHtml.append("&nbsp;</strong>");
				} else {
					pageHtml.append(
							".&nbsp;<a href=\"BoardList.do?page=" + i + "\" class=\"page\">" + i + "</a>&nbsp;");
				}

			}
			if (currentPage == lastPage) {
				pageHtml.append(".</span>");
			} else {
				pageHtml.append(".&nbsp;&nbsp;<a href=\"BoardList.do?page=" + (currentPage + 1) + "\"><다음></a></span>");
			}

		} else {
			if (currentPage == 1) {
				pageHtml.append("<span>");
			} else {
				pageHtml.append("<span><a href=\"BoardList.do?page=" + (currentPage - 1) + "&type=" + type + "&keyword="
						+ keyword + "\"><이전></a>&nbsp;&nbsp;");
			}

			for (int i = startPage; i <= lastPage; i++) {
				if (i == currentPage) {
					pageHtml.append(".&nbsp;<strong>");
					pageHtml.append("<a href=\"BoardList.do?page=" + i + "&type=" + type + "&keyword=" + keyword
							+ "\" class=\"page\">" + i + "</a>&nbsp;");
					pageHtml.append("&nbsp;</strong>");
				} else {
					pageHtml.append(".&nbsp;<a href=\"BoardList.do?page=" + i + "&type=" + type + "&keyword=" + keyword
							+ "\" class=\"page\">" + i + "</a>&nbsp;");
				}

			}
			if (currentPage == lastPage) {
				pageHtml.append("</span>");
			} else {
				pageHtml.append(".&nbsp;&nbsp;<a href=\"BoardList.do?page=" + (currentPage + 1) + "&type=" + type
						+ "&keyword=" + keyword + "\"><다음></a></span>");
			}
		}
		//
		return pageHtml;
	}

	@RequestMapping(value = "/Boardwrite.do", method = RequestMethod.POST)
	public String boardWriteProc(@ModelAttribute BoardVO boardVO, MultipartHttpServletRequest request) {

		// 파일 업로드
		String origName = boardVO.getFilename().getOriginalFilename();
		String fileName = new Date().getTime() + boardVO.getFilename().getOriginalFilename();
		String uploadPath = request.getSession().getServletContext().getRealPath(".\\files") + "\\";
		System.out.println(uploadPath);
		CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) boardVO.getFilename();
		File uploadFile = new File(uploadPath + fileName);

		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		// 같은 파일이 존재 할 때
		if (uploadFile.exists()) {
			fileName = new Date().getTime() + origName;
			uploadFile = new File(uploadPath + fileName);
		}
		// 업로드 경로에 파일 업로드
		try {
			commonsMultipartFile.transferTo(uploadFile);
		} catch (Exception e) {

		}

		//
		// 게시글 데이터 가져오기 줄바꿈 구분자 변경하기
		String content = boardVO.getContent().replaceAll("\r\n", "<br />");

		// 게시글 데이타 줄바꿈 변경 된 데이터 셋팅
		boardVO.setContent(content);
		boardVO.setAttached_file(fileName);

		boardService.writeArticle(boardVO);

		return "redirect:BoardList.do";
	}

	// 게시판 글쓰기
	@RequestMapping(value = "/Boardwrite.do")
	public String boardWrite(@ModelAttribute("BoardVO") BoardVO boardVO) {
		return "/board/board_write";
	}

}
