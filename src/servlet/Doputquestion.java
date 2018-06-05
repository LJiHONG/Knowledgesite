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

import dao.AskquestionsDAO;
import javabean.Askquestions;

/**
 * Servlet implementation class Doputquestion
 */
@WebServlet("/Doputquestion")
public class Doputquestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doputquestion() {
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
		PrintWriter out = response.getWriter();
		int integral=Integer.parseInt(request.getParameter("integral"));
		String content=request.getParameter("content");
		if(content==null||content.length()<=0){
			out.println("<h1>你提问的内容为空！请检查，3秒后跳转到回答问题界面</h1>");
			response.setHeader("refresh", "3;url=putquestion.jsp");
		}else{
			HttpSession session=request.getSession();
			String u_name=(String) session.getAttribute("u_name");
			Date date=new Date();
			Askquestions asq=new Askquestions();
			asq.setAqnContent(content);
			asq.setAqnTime(date);
			asq.setUserName(u_name);
			asq.setAqnIgl(integral);
			AskquestionsDAO askdao=new AskquestionsDAO();
			askdao.save(asq);
			out.println("<h1>提问成功，3秒后跳转到问题界面</h1>");
			response.setHeader("refresh", "3;url=Doqueryquestion");
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
