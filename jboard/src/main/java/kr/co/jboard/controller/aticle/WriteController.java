package kr.co.jboard.controller.aticle;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Service.ArticleService;
import Service.FileService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.dto.FileDTO;

@WebServlet("/article/write.do")
public class WriteController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private ArticleService service = ArticleService.instance;
	private FileService fileService = FileService.instance;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/article/write.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 수신
		String title = req.getParameter("title");	
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String regip = req.getRemoteAddr();
		
		// 파일 업로드 서비스 호출
		List<FileDTO> files = fileService.uploadFile(req);
		
		// DTO 생성
		ArticleDTO dto = new ArticleDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setFile(files.size());
		dto.setWriter(writer);
		dto.setRegip(regip);
		logger.debug(dto.toString());
		
		// 글 등록 서비스 호출
		int no = service.registerArticle(dto);
		
		// 파일 등록 서비스 호출
		for(FileDTO filedDTO : files) {
			filedDTO.setAno(no);
			fileService.registerFile(filedDTO);
			
		}
		
		// 글목록 이동
		resp.sendRedirect("/jboard/article/list.do");
	}
}
