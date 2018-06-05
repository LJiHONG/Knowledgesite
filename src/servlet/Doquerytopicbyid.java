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

import dao.TopicDAO;
import dao.TopicdiscussDAO;
import javabean.Topic;
import javabean.Topicdiscuss;

/**
 * Servlet implementation class Doquerytopicbyid
 */
@WebServlet("/Doquerytopicbyid")
public class Doquerytopicbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doquerytopicbyid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		int tpid=Integer.parseInt(request.getParameter("id"));
		HttpSession session=request.getSession();
		session.setAttribute("topicid", tpid);
		Topic tpc=new Topic();
		TopicDAO tpdao=new TopicDAO();
		tpc=tpdao.findById(tpid);
		List<Topic> ltp=new ArrayList<>();
		ltp.add(tpc);
		request.setAttribute("tpc", ltp);
		TopicdiscussDAO ddao=new TopicdiscussDAO();
		List<Topicdiscuss> ltpd=ddao.findByProperty("tpcId", tpid);
		request.setAttribute("ltpd", ltpd);
		request.getRequestDispatcher("puttopicbyid.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
