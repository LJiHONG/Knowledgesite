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

import dao.ArticleDAO;
import javabean.Article;


@WebServlet("/Dowritearticle")
public class Dowritearticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dowritearticle() {
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
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		if(title==null||title.length()<=0||content==null||content.length()<=0){
			out.print("<h1>标题和内容都不能为空！请检查，3秒后跳转到写文章界面</h1>");
			response.setHeader("refresh", "3;url=writearticle.jsp");
		}else{
			HttpSession session=request.getSession();
			String u_name=(String) session.getAttribute("u_name");
			Article art = new Article();
			Date date = new Date();
			art.setArtTitle(title);
			art.setUserName(u_name);
			art.setArtContent(content);
			art.setArtTime(date);
			ArticleDAO adao=new ArticleDAO();
			adao.save(art);
			
			out.print("<h1>提交成功，3秒后跳转到查看文章界面</h1>");
			response.setHeader("refresh", "3;url=Doqueryarticle");
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
