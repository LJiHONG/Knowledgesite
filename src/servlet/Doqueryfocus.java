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

import dao.FocustopicDAO;
import dao.TopicDAO;
import javabean.Focustopic;
import javabean.Topic;

/**
 * Servlet implementation class Doqueryfocus
 */
@WebServlet("/Doqueryfocus")
public class Doqueryfocus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doqueryfocus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String u_name=(String) session.getAttribute("u_name");
		FocustopicDAO fdao=new FocustopicDAO();
		List<Focustopic> lftp = fdao.findByProperty("userName", u_name);
		List<Topic> ltpc=new ArrayList<>();
		TopicDAO tdao=new TopicDAO();
		Topic tp=new Topic();
		for(Focustopic f:lftp){
			tp=tdao.findById(f.getTpcId());
			ltpc.add(tp);
		}
		request.setAttribute("ltpc", ltpc);
		request.getRequestDispatcher("queryfocus.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
