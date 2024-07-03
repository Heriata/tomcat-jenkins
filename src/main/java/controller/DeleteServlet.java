package controller;

import config.UserDAO;
import model.User;
import sun.util.resources.cldr.ext.CurrencyNames_en_CX;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {

    UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            userDAO.delete(id);
            resp.sendRedirect(req.getContextPath()+"/index");
        }catch (Exception e){
            resp.sendRedirect(req.getContextPath()+"/error");
            e.printStackTrace();
        }
    }
}
