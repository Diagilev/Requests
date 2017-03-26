package com.regcontract.Servlets;

import com.regcontract.DB.ContractDAO;
import com.regcontract.DB.ContractDAOImp;
import com.regcontract.Model.Contract;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by kabanaus on 13.02.2017.
 */
@WebServlet ("/Main")
public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        ContractDAO dao = null;
        try {
            dao = new ContractDAOImp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Contract contract = new Contract(req.getParameter("id"), req.getParameter("companyName"), req.getParameter("subject"), req.getParameter("status"), req.getParameter("clientName"), req.getParameter("fileName"));
        try {
            resp.setContentType("text/html; charset=UTF-8");
          if(dao.addContract(contract)) {
              String s = "Данные успешно добавлены в базу";
            resp.getWriter().write(s);}
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().write(e.getMessage());
        }
    }

}


