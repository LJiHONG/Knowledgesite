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

import dao.AskquestionsDAO;
import dao.FuquestionDAO;
import javabean.Askquestions;
import javabean.Fuquestion;

/**
 * Servlet implementation class Doqueryfocusquestion
 */
@WebServlet("/Doqueryfocusquestion")
public class Doqueryfocusquestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doqueryfocusquestion() {
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
		String u_name = (String) session.getAttribute("u_name");
		FuquestionDAO fdao=new FuquestionDAO();
		List<Fuquestion> ltfuq=fdao.findByProperty("userName", u_name);
		Askquestions aq=new Askquestions();
		AskquestionsDAO aqdao=new AskquestionsDAO();
		List<Askquestions> ltak=new ArrayList<>();
		for(Fuquestion f:ltfuq){
			aq=aqdao.findById(f.getAqnId());
			ltak.add(aq);
		}
		request.setAttribute("ltak", ltak);
		request.getRequestDispatcher("queryfocusquestion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
