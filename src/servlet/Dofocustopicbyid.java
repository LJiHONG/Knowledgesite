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

import dao.FocustopicDAO;
import javabean.Focustopic;

/**
 * Servlet implementation class Dofocustopicbyid
 */
@WebServlet("/Dofocustopicbyid")
public class Dofocustopicbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dofocustopicbyid() {
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
		int tpcid=Integer.parseInt(request.getParameter("id"));
		String u_name=(String) session.getAttribute("u_name");
		Focustopic ftpc=new Focustopic();
		ftpc.setTpcId(tpcid);
		ftpc.setUserName(u_name);
		int a=0;
		FocustopicDAO fdao=new FocustopicDAO();
		List<Focustopic> lt=fdao.findByProperty("userName", u_name);
		for(Focustopic f:lt){
			if(f.getTpcId()==tpcid){
				a++;
			}
			fdao.getSession().evict(f);
		}
		if(a>0){
			out.print("<h1>关注失败，你已经关注了此话题，3秒后跳转到我关注的话题界面</h1>");
			response.setHeader("refresh", "3;url=Doqueryfocus");
		}else{
			fdao.save(ftpc);
			out.print("<h1>关注成功，3秒后跳转到我关注的话题界面</h1>");
			response.setHeader("refresh", "3;url=Doqueryfocus");
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
