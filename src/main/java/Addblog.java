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

@WebServlet(name = "Addblog")
public class Addblog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sess = request.getSession();
        UserDetails userId = (UserDetails)sess.getAttribute("userId");
        PrintWriter out=response.getWriter();
//        out.print(userId.getPassword());
//        out.print(userId.getName());
//        out.print(userId.getUsername());
        Blog blog = new Blog();
        blog.setUserDetails(userId);
        blog.setContent(request.getParameter("blog"));
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(blog);
        session.getTransaction().commit();
    }
}
