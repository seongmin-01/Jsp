package controller.user2;

import java.io.IOException;

import dto.User2DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User2Service;

@WebServlet("/user2/register.do")
public class RegisterController extends HttpServlet{
	
	// 서비스 가져오기
	private User2Service service = User2Service.getInstance();
	
	private static final long serialVersionUID = 3989756952756485985L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user2/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 수신
		String uid = req.getParameter("uid");
		String name = req.getParameter("name");
		String birth = req.getParameter("birth");
		String addr = req.getParameter("addr");
		
		// DTO 생성
		User2DTO dto = new User2DTO();
		
		dto.setUid(uid);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setAddr(addr);
		
		// 서비스 호출
		service.registerUser2(dto);
		
		// 이동
		resp.sendRedirect("/ch10/user2/list.do");
		
		
	}
}
