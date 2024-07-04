package controller;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebListener("/adduser")
public class AddUser extends HttpServlet {

    private UserService userService;
    @Override
    public void init() throws ServletException {
        super.init();
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        Integer age = Integer.valueOf(req.getParameter("age"));

        try{
            userService.addUser(name, surname, age);
            resp.sendRedirect("/index.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
