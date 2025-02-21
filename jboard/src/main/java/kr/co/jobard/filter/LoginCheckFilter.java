package kr.co.jobard.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jboard.dto.UserDTO;

@WebFilter("/*")
public class LoginCheckFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		logger.debug("LoginCheckFilter...1");
		
		// 로그인 여부 검사
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		
		UserDTO userDTO = (UserDTO) session.getAttribute("sessUser");
		
		// 로그인 /user/* 요청일 때
		
		// 요청 URL 확인 URL- 전체  URI - URL에서 도메인이 빠진것
		String uri = request.getRequestURI(); // /jboard/article/list.do
		logger.debug("LoginCheckFilter...2 : " + uri);
		
		String ctxPath = request.getContextPath(); // /jboard
		logger.debug("LoginCheckFilter...3 : " + ctxPath);
		
		String path = uri.substring(ctxPath.length()); //article/*, /user/*
		logger.debug("LoginCheckFilter...4 : " + path);

		// path에서 user가 포함되고 login.do가 아닐경우에
		if(path.startsWith("/user") && !path.contains("logout.do")) {
			// 로그인 /user/* 요청일 때
			if(userDTO != null) {
				// 비로그인일 경우 로그인 페이지 이동
				HttpServletResponse response = (HttpServletResponse) resp;
				response.sendRedirect("/jboard/article/list.do");
				return;
			}
			
		}else if(path.startsWith("/article")) {
			// 비로그인 /article/* 요청일 경우
			if(userDTO == null) {
				// 비로그인일 경우 로그인 페이지 이동
				HttpServletResponse response = (HttpServletResponse) resp;
				response.sendRedirect("/jboard/user/login.do?result=102");
				return;
				
			}
		}
		
		// 다음 필터(Controller) 이동
		chain.doFilter(req, resp);
		
		
	}
}
