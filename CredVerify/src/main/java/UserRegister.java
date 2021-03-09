

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;

import javax.transaction.*;
import javax.xml.bind.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.User;
import com.example.HibernateUtil;
import java.util.Date;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		{
			// TODO Auto-generated method stub
			String username = request.getParameter("name");
			String password = request.getParameter("password");
			String email = request.getParameter("email");

			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();

				Session session = factory.openSession();
				session.beginTransaction();

				User u = new User();
				u.setName(username);
				u.setEmail(email);
				u.setPassword(password);

				session.save(u);
				session.getTransaction().commit();
				// using HQL
				//List<User> list = session.createQuery("from User", User.class).list();

				session.close();

				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				out.println(username +" you have been successfully registered");
				out.println("<br><a href =\"index.jsp\">Return to home</a>");
				out.println("</body></html>");

			} catch (Exception ex) {
				throw ex;
			}
		}
	}

}
