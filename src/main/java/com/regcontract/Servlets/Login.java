package com.regcontract.Servlets;

import com.regcontract.DB.UserDAO;
import com.regcontract.DB.UserDAOImp;
import com.regcontract.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static com.regcontract.Servlets.Registration.md5generator;

/**
 * Created by kabanaus on 10.03.2017.
 */

@WebServlet(value = "/Login", loadOnStartup = 0)

public class Login extends HttpServlet {
    String password;
    String email;
    public static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        email = req.getParameter("email");
        password = req.getParameter("password");
        User user = md5generator(new User(email, password));
        UserDAO userDAO = null;
        try {
            userDAO = new UserDAOImp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (user.equals(userDAO.getByEmail(user))) {

                HttpSession session = req.getSession();
                session.setAttribute("email", req.getParameter("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/");
    }
}
