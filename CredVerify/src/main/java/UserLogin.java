import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
import com.example.UserValidate;
import com.example.HibernateUtil;
import java.util.Date;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.sendRedirect("login-success.jsp");
		//PrintWriter pw = response.getWriter();
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        try {
			            authenticate(request, response);
			        } catch (Exception e) {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			        }
			    }

			    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
			        String username = request.getParameter("username");
			        String password = request.getParameter("password");

			        if (UserValidate.validate(username, password)) {
			            RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
			            dispatcher.forward(request, response);
			        } else {
			        	 RequestDispatcher disp = request.getRequestDispatcher("login-failed.jsp");
			            disp.forward(request, response);
			        }
			    }
			}

