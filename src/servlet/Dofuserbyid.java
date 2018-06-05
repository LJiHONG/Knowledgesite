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

import dao.FuserDAO;
import javabean.Fuser;

/**
 * Servlet implementation class Dofuserbyid
 */
@WebServlet("/Dofuserbyid")
public class Dofuserbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dofuserbyid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String u_name=(String) session.getAttribute("u_name");
		int uid=Integer.parseInt(request.getParameter("id"));
		FuserDAO fdao=new FuserDAO();
		Fuser fu=new Fuser();
		fu.setUserId(uid);
		fu.setUserName(u_name);
		int a=0;
		List<Fuser> lf=fdao.findByProperty("userName", u_name);
		for(Fuser f:lf){
			if(f.getUserId()==uid){
				a++;
			}
		}
		if(a>0){
			out.println("<h1>关注失败，你已经关注了此用户，3秒后跳转到我关注的用户界面</h1>");
			response.setHeader("refresh", "3;url=Doqueryuser");
		}else{
			fdao.save(fu);
			out.println("<h1>关注成功，3秒后跳转到我关注的用户界面</h1>");
			response.setHeader("refresh", "3;url=Doqueryuser");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
