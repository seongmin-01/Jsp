package kr.co.jboard.controller.user;

import java.io.IOException;

import Service.TermsService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.dto.TermsDTO;

@WebServlet("/user/terms.do")
public class TermsController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private TermsService service = TermsService.instance;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 약관 조회
		TermsDTO dto = service.findTerms(1);
		
		// request 데이터 참조
		req.setAttribute("dto", dto);
		
		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/terms.jsp");
		dispatcher.forward(req, resp);
	}
}
