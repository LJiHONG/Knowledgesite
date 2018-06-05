package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDAO;
import javabean.Article;

/**
 * Servlet implementation class Doqueryarticlebyid
 */
@WebServlet("/Doqueryarticlebyid")
public class Doqueryarticlebyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doqueryarticlebyid() {
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
		int aid=Integer.parseInt(request.getParameter("id"));
		Article art=new Article();
		ArticleDAO adao=new ArticleDAO();
		art=adao.findById(aid);
		request.setAttribute("title", art.getArtTitle());
		request.setAttribute("content", art.getArtContent());
		request.setAttribute("name", art.getUserName());
		request.getRequestDispatcher("queryarticlebyid.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
