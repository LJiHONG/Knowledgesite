package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import javabean.User;

@WebServlet("/Dologin")
public class Dologin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Dologin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String u_name = request.getParameter("userName");
		String u_pwd = request.getParameter("pwd");
		
		HttpSession session=request.getSession();
		session.setAttribute("u_name",u_name);
		session.setAttribute("u_pwd", u_pwd);
		
		UserDAO ud = new UserDAO();
		List<User> u1= ud.findByProperty("userName", u_name);
		if(u1!=null&&!u1.isEmpty()){
			for(User user:u1){
				if(user.getUserPwd().equals(u_pwd)){
					session.setAttribute("u_id",user.getUserId());
					request.getRequestDispatcher("Dofindintegral").forward(request, response);
				}else{
					out.println("<h1>µ«¬Ω ß∞‹,«Î÷ÿ ‘</h1>");
					response.setHeader("refresh", "3;url=login.html");
				}
			}
		}else{
			out.println("<h1>µ«¬Ω ß∞‹,«Î÷ÿ ‘</h1>");
			response.setHeader("refresh", "3;url=login.html");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
