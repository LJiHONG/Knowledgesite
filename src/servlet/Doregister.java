package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import javabean.User;

/**
 * Servlet implementation class Doregister
 */
@WebServlet("/Doregister")
public class Doregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Doregister() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String u_name = request.getParameter("userName");
		String pwd1 = request.getParameter("pwd1");
		String pwd2 = request.getParameter("pwd2");
		User u = new User();
		u.setUserName(u_name);
		u.setUserPwd(pwd1);
		if(pwd1.equals(pwd2)&&pwd1!=null&&u_name!=null){
			UserDAO ud = new UserDAO();
			List<User> lu = ud.findByProperty("userName", u_name);
			if(lu!=null&&!lu.isEmpty()){
				out.print("<h1>用户名已经被占用,请更换用户名</h1>");
				response.setHeader("refresh", "3;url=login.html");
			}else{
				ud.save(u);
				out.print("<h1>注册成功，3秒后跳转到登陆界面</h1>");
				response.setHeader("refresh", "3;url=login.html");
			}
		}else{
			out.print("<h1>注册失败,请重试</h1>");
			response.setHeader("refresh", "3;url=login.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
