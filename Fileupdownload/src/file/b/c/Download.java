package file.b.c;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Download.do")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String fileName = request.getParameter("file_name");
		// System.out.println(fileName);

		// 다운로드 할 경로를 지정한다.
		String savePath = "./file";
		ServletContext servletContext = getServletContext();
		String downloadPath = servletContext.getRealPath(savePath);
		// System.out.println(downloadPath);

		// 경로를 만들어주기
		String filePath = downloadPath + "//" + fileName;
		System.out.println(filePath);

		File file = new File(filePath);
		if (file.exists()) {

			String downType = getServletContext().getMimeType(filePath);
			System.out.println("다운로드 타입 확인 : " + downType);
			if (downType == null) {
				downType = "application/octet-stream";
				response.setContentType(downType);
			}

			// 인코딩
			boolean IE = (request.getHeader("user-agent").indexOf("MSIE") != -1)
					|| (request.getHeader("user-agent").indexOf("Trident") != -1);
			String encoding = null;
			if (IE) {
				encoding = new String(fileName.getBytes("EUC-KR"), "ISO-8859-1").replaceAll("\\+", "%20");
			} else {
				encoding = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}

			response.setHeader("Content-Disposition", "attachment;filename=\"" + encoding + "\"");
			ServletOutputStream servletOutputStream = response.getOutputStream();
			FileInputStream fileInputStream = new FileInputStream(filePath);
			int numRead;
			byte b[] = new byte[4096];
			while ((numRead = fileInputStream.read(b, 0, b.length)) != -1) {
				servletOutputStream.write(b, 0, numRead);
			}
			servletOutputStream.flush();
			servletOutputStream.close();
			fileInputStream.close();
		}
	}
}