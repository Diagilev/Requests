package com.regcontract.Servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.regcontract.DB.ContractDAO;
import com.regcontract.DB.ContractDAOImp;
import com.regcontract.Model.Clients;

/**
 * Created by kabanaus on 26.02.2017.
 */
@WebServlet("/viewclients")
public class ViewClients extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        ContractDAO dao = null;
        try {
            dao = new ContractDAOImp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            List<Clients> clientsList = dao.getClients(req);
            List<String> list = new ArrayList<String>();
            for(Clients name: clientsList){
               list.add(name.getClientName());
            }
            String gson = new Gson().toJson(list);
            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().write(gson);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
