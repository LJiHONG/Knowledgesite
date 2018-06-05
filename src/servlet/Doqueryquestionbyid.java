package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnswerquestionsDAO;
import dao.AskquestionsDAO;
import javabean.Answerquestions;
import javabean.Askquestions;

/**
 * Servlet implementation class Doqueryquestionbyid
 */
@WebServlet("/Doqueryquestionbyid")
public class Doqueryquestionbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doqueryquestionbyid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		int aqnid=Integer.parseInt(request.getParameter("id"));
		HttpSession session=request.getSession();
		session.setAttribute("questionid", aqnid);
		AskquestionsDAO askdao = new AskquestionsDAO();
		Askquestions asq=new Askquestions();
		asq=askdao.findById(aqnid);
		List<Askquestions> listqtn=new ArrayList<>();
		listqtn.add(asq);
		session.setAttribute("integral", asq.getAqnIgl());
		AnswerquestionsDAO andao=new AnswerquestionsDAO();
		List<Answerquestions> listaq=andao.findByProperty("aqnId", aqnid);
		request.setAttribute("listqtn", listqtn);
		request.setAttribute("listaq", listaq);
		request.getRequestDispatcher("answerquestionbyid.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
