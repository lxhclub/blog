package web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.BusinessServiceImpl;
import utils.WebUtils;

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	try{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String cellphone=request.getParameter("cellphone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		User user=new User();
		user.setAddress(address);
		user.setCellphone(cellphone);
		user.setEmail(email);
		user.setId(WebUtils.makeID());
		user.setPassword(password);
		user.setPhone(phone);
		user.setUsername(username);
		BusinessServiceImpl service=new BusinessServiceImpl();
		service.registerUser(user);
		request.setAttribute("message", "×¢²á³É¹¦");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
		
	}catch(Exception e){
		e.printStackTrace();
		request.setAttribute("message", "×¢²áÊ§°Ü");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
