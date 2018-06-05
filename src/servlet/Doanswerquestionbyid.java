package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnswerquestionsDAO;
import dao.IntegralrecordDAO;
import dao.UserDAO;
import javabean.Answerquestions;
import javabean.Integralrecord;
import javabean.User;

/**
 * Servlet implementation class Doanswerquestionbyid
 */
@WebServlet("/Doanswerquestionbyid")
public class Doanswerquestionbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doanswerquestionbyid() {
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
		String content=request.getParameter("content");
		if(content==null||content.length()<=0){
			out.println("<h1>你的回答内容为空！请检查，3秒后跳转到回答问题界面</h1>");
			response.setHeader("refresh", "3;url=Doqueryquestion");
		}else{
			Date date=new Date();
			HttpSession session=request.getSession();
			String u_name=(String) session.getAttribute("u_name");
			int qid=(int) session.getAttribute("questionid");
			int integral=(int) session.getAttribute("integral");
			Answerquestions ansq=new Answerquestions();
			ansq.setAqnId(qid);
			ansq.setAsqnTime(date);
			ansq.setAsqnContent(content);
			ansq.setUserName(u_name);
			AnswerquestionsDAO adao=new AnswerquestionsDAO();
			adao.save(ansq);
			Integralrecord ird=new Integralrecord();
			ird.setGetTime(date);
			ird.setIglNum(integral);
			ird.setIglRse("回答问题");
			ird.setUserName(u_name);
			IntegralrecordDAO idao=new IntegralrecordDAO();
			idao.save(ird);
			UserDAO ud=new UserDAO();
			User user = new User();
			List<User> ltu=ud.findByProperty("userName", u_name);
			for(User u:ltu){
				user.setUserId(u.getUserId());
				user.setUserName(u_name);
				user.setUserPwd(u.getUserPwd());
				if(u.getIntegral()!=null){
					user.setIntegral(u.getIntegral()+integral);
				}else{
					user.setIntegral(integral);
				}
				ud.getSession().evict(u);
			}
			UserDAO ud2=new UserDAO();
			ud2.update(user);
			out.println("<h1>回答成功，3秒后跳转到回答问题界面</h1>");
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
