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

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out=response.getWriter();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails signin=(UserDetails)session.get(UserDetails.class,request.getParameter("username"));
        String password=(String)signin.getPassword();
        if(password.equals(request.getParameter("password"))){
            HttpSession sess=request.getSession();
            sess.setAttribute("userId",signin);
            response.sendRedirect("Home.jsp");
        }
        else
            out.print("Invalid password");
//        response.sendRedirect("Home.jsp");


    }
}
