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

import dao.TopicDAO;
import javabean.Topic;

/**
 * Servlet implementation class Doputtopic
 */
@WebServlet("/Doputtopic")
public class Doputtopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doputtopic() {
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
		HttpSession session=request.getSession();
		String u_name=(String) session.getAttribute("u_name");
		Date date=new Date();
		String content=request.getParameter("content");
		if(content==null||content.length()<=0){
			out.println("<h1>你的话题内容为空！请检查，3秒后跳到发起话题界面");
			response.setHeader("refresh", "3;url=puttopic.jsp");
		}else{
			Topic tp=new Topic();
			tp.setTpcTime(date);
			tp.setUserName(u_name);
			tp.setTpcContent(content);
			TopicDAO tpdao=new TopicDAO();
			tpdao.save(tp);
			out.println("<h1>发起成功，3秒后跳转到话题界面</h1>");
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
