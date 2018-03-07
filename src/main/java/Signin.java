import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Signin")
public class Signin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out=response.getWriter();
        UserDetails userDetails=new UserDetails();
        userDetails.setUsername(request.getParameter("username"));
        userDetails.setName(request.getParameter("name"));
        userDetails.setAge(Integer.parseInt(request.getParameter("age")));
        userDetails.setPassword(request.getParameter("pass"));
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
//out.println(request.getParameter("username") +"    "+ request.getParameter("name")+"   "+request.getParameter("age")+"   " +request.getParameter("pass") );
        response.sendRedirect("Home.jsp");
    }
}
