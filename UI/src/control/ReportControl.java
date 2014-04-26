package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReportBean;
import model.ReportBeanOperations;

/**
 * Servlet implementation class ReportControl
 */
@WebServlet("/ReportControl")
public class ReportControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get flag
				String flag = request.getParameter("flag");
				
		
		
		//----------------------paging---------------
		System.out
				.println("pageing function is controlled by ReportControl");
		// get pageNow
		int pageNow = Integer.parseInt(request.getParameter("pageNow"));
		
		//when jump to UserAccount.jsp, organize the data which we want to show in UserAccount.jsp
		ReportBeanOperations rbo = new ReportBeanOperations();
		ArrayList<ReportBean> al = rbo.getResultByPage(pageNow);
		int pageCount = rbo.getPageCount();
		
		//put al, pageCount, pageNow into request
		request.setAttribute("result",al);
		request.setAttribute("pageCount",pageCount+"");
		request.setAttribute("pageNow", pageNow+"");
		
		//it's like sendRedirect, but more efficient
		//and keep the content in the request
		request.getRequestDispatcher("UserAccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
