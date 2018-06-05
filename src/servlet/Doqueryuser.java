package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FuserDAO;
import dao.UserDAO;
import javabean.Fuser;
import javabean.User;

/**
 * Servlet implementation class Doqueryuser
 */
@WebServlet("/Doqueryuser")
public class Doqueryuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doqueryuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		UserDAO udao=new UserDAO();
		List<User> ltu=udao.findAll();
	
		FuserDAO fdao=new FuserDAO();
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("u_name");
		List<Fuser> ltf=fdao.findByProperty("userName", name);
		List<User> ltur=new ArrayList<>();
		User ur=new User();
		for(Fuser u:ltf){
			ur=udao.findById(u.getUserId());
			ltur.add(ur);
		}
		request.setAttribute("ltu", ltu);
		request.setAttribute("ltur", ltur);
		request.getRequestDispatcher("queryuser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
