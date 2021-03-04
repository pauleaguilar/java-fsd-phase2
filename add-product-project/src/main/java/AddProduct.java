
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

import com.ecommerce.EProduct;
import com.ecommerce.HibernateUtil;
import java.util.Date;

/**
 * Servlet implementation class AddProduct
 */
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pname = request.getParameter("pname");
		BigDecimal pprice = new BigDecimal(request.getParameter("pprice"));

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();
			session.beginTransaction();

			EProduct ep = new EProduct();
			ep.setName(pname);
			// BigDecimal a = new BigDecimal(pprice);
			ep.setPrice(pprice);
			Date d = new Date();
			ep.setDateAdded(d);

			session.save(ep);
			session.getTransaction().commit();
			// using HQL
			List<EProduct> list = session.createQuery("from EProduct", EProduct.class).list();

			session.close();

			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("Product has been added..");
			out.println("<b>Product Listing</b><br>");
			for (EProduct p : list) {
				out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() + ", Price: "
						+ String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString() + "<br>");
			}
			out.println("<br><a href =\"index.jsp\">Return to home</a>");
			out.println("</body></html>");

		} catch (Exception ex) {
			throw ex;
		}
	}

}
