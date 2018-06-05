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

import dao.FuquestionDAO;
import javabean.Fuquestion;

/**
 * Servlet implementation class Dofocusquestionbyid
 */
@WebServlet("/Dofocusquestionbyid")
public class Dofocusquestionbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dofocusquestionbyid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int quid=Integer.parseInt(request.getParameter("id"));
		HttpSession session=request.getSession();
		String u_name=(String) session.getAttribute("u_name");
		Fuquestion fu=new Fuquestion();
		fu.setAqnId(quid);
		fu.setUserName(u_name);
		FuquestionDAO fudao=new FuquestionDAO();
		int a=0;
		List<Fuquestion> lt=fudao.findByProperty("userName", u_name);
		for(Fuquestion f:lt){
			if(f.getAqnId()==quid){
				a++;
			}
		}
		if(a>0){
			out.println("<h1>关注失败，你已经关注了这个话题，3秒后跳转到我关注的问题界面</h1>");
			response.setHeader("refresh", "3;url=Doqueryfocusquestion");
		}else{
			fudao.save(fu);
			out.println("<h1>关注成功，3秒后跳转到我关注的问题界面</h1>");
			response.setHeader("refresh", "3;url=Doqueryfocusquestion");
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
