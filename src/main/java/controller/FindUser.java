package controller;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/find")
public class FindUser extends HttpServlet {

    UserService userService;
    @Override
    public void init() throws ServletException {
        super.init();
        getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        User user = userService.getUserById(id);

        req.setAttribute("user", user);
        req.getRequestDispatcher("/find.jsp").forward(req,resp);
    }
}
