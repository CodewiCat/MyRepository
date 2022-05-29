package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("password");
        System.out.println(username+" "+pwd);
        //req.getRequestDispatcher("/Main/main.jsp").forward(req,resp);
        System.out.println(req.getContextPath());
        resp.sendRedirect(req.getContextPath()+"/Main/main.jsp");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
