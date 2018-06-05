package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TopicdiscussDAO;
import javabean.Topicdiscuss;

/**
 * Servlet implementation class Doputtopicbyid
 */
@WebServlet("/Doputtopicbyid")
public class Doputtopicbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doputtopicbyid() {
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
		PrintWriter out=response.getWriter();
		Date date=new Date();
		String content = request.getParameter("content");
		if(content==null||content.length()<=0){
			out.println("<h1>你的发言内容为空！请检查，3秒后跳回话题界面</h1>");
			response.setHeader("refresh", "3;url=Doquerytopic");
		}else{
			HttpSession session=request.getSession();
			String u_name=(String) session.getAttribute("u_name");
			int tpid=(int) session.getAttribute("topicid");
			Topicdiscuss tpd=new Topicdiscuss();
			tpd.setTpdContent(content);
			tpd.setTpdTime(date);
			tpd.setUserName(u_name);
			tpd.setTpcId(tpid);
			TopicdiscussDAO tpdao=new TopicdiscussDAO();
			tpdao.save(tpd);
			out.println("<h1>发言成功，3秒后跳回话题界面</h1>");
			response.setHeader("refresh", "3;url=Doquerytopic");
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
