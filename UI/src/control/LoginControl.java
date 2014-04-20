package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBeanOperations;

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	
	//override init()
	@Override
	public void init() {
		try {
			//will only be called by once
			
			//===========add a counter for page visit=============
			//the counter will add one when the login is successful
			//create a FileReader
			FileReader fr = new FileReader("E:\\myCounter.txt");
			BufferedReader br = new BufferedReader(fr);
			
			//read a line
			String counter = br.readLine();
			
			//must close file stream
			br.close();
			
			//put counter into servletContext
			this.getServletContext().setAttribute("visit", counter);
			
			System.out.println("init() is called");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//override destroy()
	@Override
	public void destroy() {
		try {
			//create a FileWriter
			FileWriter fw = new FileWriter("E:\\myCounter.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			//write data into file
			bw.write(this.getServletContext().getAttribute("visit").toString());
			
			//close file inputStream
			bw.close();
			
			System.out.println("destroy() is called");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String name = request.getParameter("username");
			String password = request.getParameter("password");

			// call UserBeanControl, create an instance
			UserBeanOperations ubo = new UserBeanOperations();
			//call the method of UserBeanControl
			System.out.println(name);
			if (ubo.checkUser(name, password)) {
				
				//legal user
				String keep = request.getParameter("keep");

				if (keep != null) {
					// put username and password into cookie
					Cookie unCookie = new Cookie("myName", name);
					Cookie pwCookie = new Cookie("myPassword", password);
					// set time of cookie
					unCookie.setMaxAge(14 * 24 * 3600);
					pwCookie.setMaxAge(14 * 24 * 3600);

					// write back to client
					response.addCookie(unCookie);
					response.addCookie(pwCookie);
				}
				
				//-------------session--------------------
				// write authentication into session
				// get session
				HttpSession hs = request.getSession(true);
				// revise the time length of session
				hs.setMaxInactiveInterval(30);
				hs.setAttribute("username", name);
				
				//===========add a counter for page visit=============
				//=====by using servletContext combined with servlet file operation====
				//get counter from servletContext 
				String counter = this.getServletContext().getAttribute("visit").toString();
				
				//put counter back into servlet
				this.getServletContext().setAttribute("visit",(Integer.parseInt(counter)+1)+"");
				
				System.out.println("use controller to jump to main.jsp");
				
				System.out.println("use ");
//				//when jump to wel.jsp, organize the data which we want to show in wel.jsp
//				ArrayList<UserBean> al = ubo.getResultByPage(1);
//				int pageCount = ubo.getPageCount();
//				
//				//put al, pageCount, pageNow into request
//				request.setAttribute("result",al);
//				request.setAttribute("pageCount",pageCount+"");
//				request.setAttribute("pageNow", "1");
				
				//it's like sendRedirect, but more efficient
				//and keep the content in the request
				
				 
				request.getRequestDispatcher("home.jsp").forward(request, response);
				
			} else {
				// indicate user is not existing
				request.getRequestDispatcher("ReportReview.jsp").forward(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.doGet(request, response);
	}
}
