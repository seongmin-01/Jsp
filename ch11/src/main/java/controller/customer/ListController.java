package controller.customer;

import java.io.IOException;
import java.util.List;

import dto.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CustomerService;

public class ListController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private CustomerService service = CustomerService.instance;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<CustomerDTO> dtos = service.findAllCustomer();
		
		req.setAttribute("dtos", dtos);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/shop/customer.list.jsp");
		dispatcher.forward(req, resp);
	}
	
}
