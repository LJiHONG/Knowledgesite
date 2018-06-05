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

import dao.IntegralrecordDAO;
import dao.UserDAO;
import javabean.Integralrecord;
import javabean.User;

/**
 * Servlet implementation class Dosignin
 */
@WebServlet("/Dosignin")
public class Dosignin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dosignin() {
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
		Date cdate=new Date();
		HttpSession session=request.getSession();
		String u_name=(String) session.getAttribute("u_name");
		Integralrecord incd=new Integralrecord();
		incd.setGetTime(cdate);
		incd.setIglRse("签到");
		incd.setUserName(u_name);
		User user=new User();
		UserDAO ud=new UserDAO();
		List<User> ltu=ud.findByProperty("userName", u_name);
		int inegeralfirst=0;
		for(User u:ltu){
			user.setUserId(u.getUserId());
			user.setUserName(u_name);
			user.setUserPwd(u.getUserPwd());
			if(u.getIntegral()!=null){
				inegeralfirst=u.getIntegral();
			}
		}
		int a=0;
		IntegralrecordDAO irdao=new IntegralrecordDAO();
		List<Integralrecord> listir=irdao.findByProperty("userName", u_name);
		if(listir!=null&&!listir.isEmpty()){
				for(Integralrecord igd:listir){
					if(igd.getIglRse().equals("签到")){
						Date date=igd.getGetTime();
						if(date.getYear()==cdate.getYear()&&date.getMonth()==cdate.getMonth()&&date.getDay()==cdate.getDay()){
							a++;
						}
				}
			}
		}
		if(a==0){
			incd.setIglNum(1);
			user.setIntegral(1+inegeralfirst);
			IntegralrecordDAO irdao1=new IntegralrecordDAO();
			irdao1.save(incd);
			UserDAO ud1=new UserDAO();
			ud1.update(user);
			out.print("<h1>签到成功，3秒后跳转到home界面</h1>");
			response.setHeader("refresh", "3;Dofindintegral");
		}else{
			out.print("<h1>今天已签到，3秒后跳转到home界面</h1>");
			response.setHeader("refresh", "3;url=Dofindintegral");
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
