package com.regcontract.Servlets;

import com.regcontract.DB.UserDAO;
import com.regcontract.DB.UserDAOImp;
import com.regcontract.Model.User;
import org.apache.commons.codec.digest.DigestUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kabanaus on 22.03.2017.
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
    String name;
    String surname;
    String email;
    String password;
    String role;

    protected static User md5generator(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        String md5pass = DigestUtils.md5Hex(user.getEmail() + user.getPassword());
        user.setPassword(md5pass);
        return user;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        name = req.getParameter("name");
        surname = req.getParameter("surname");
        email = req.getParameter("email");
        password = req.getParameter("password");
        role = req.getParameter("role");
        User user = new User(0, name, surname, email, password, role);
        try {
            if (user.checkProperties()) {
                user = md5generator(user);
                UserDAO userDAO = new UserDAOImp();
                boolean addResult = userDAO.addUser(user);
                if (addResult == true) {
                    resp.getWriter().write("Пользователь успешно добавлен!");
                } else {
                    resp.getWriter().write("Ошибка добавления пользователя!");
                }
            } else resp.getWriter().write("Необходимо заполнить все обязательные поля");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
