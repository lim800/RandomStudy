package file.b.c;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/Upload.do")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadPath = request.getSession().getServletContext().getRealPath("./file");
		int size = 10 * 1024 * 1024; // 10MB
		// null로 초기화 하지 않음
		String name = "";
		String subject = "";
		String filename = "";
		String orginfilename = "";

		MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath, size, "UTF-8",
				new DefaultFileRenamePolicy());
		// request 객체로 파라미터를 가져오면 안된다.
		name = multipartRequest.getParameter("name");
		subject = multipartRequest.getParameter("subject");
		Enumeration<?> enumeration = multipartRequest.getFileNames();
		String file = (String) enumeration.nextElement();
		filename = multipartRequest.getFilesystemName(file);
//		System.out.println(filename);
		orginfilename = multipartRequest.getOriginalFileName(file);
//		System.out.println(orginfilename);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("이름: " + name + "<br/>");
		out.print("제목: " + subject + "<br/>");
		String file_name = filename;
//		file_name = URLEncoder.encode(file_name, "UTF-8");

		out.println("파일명: " + "<a href='./Download.do?file_name=" + file_name + "' >" + orginfilename + "</a>");

	}

}
