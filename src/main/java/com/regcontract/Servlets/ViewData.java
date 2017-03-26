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
import java.util.List;

/**
 * Created by kabanaus on 20.02.2017.
 */

@WebServlet("/View")
public class ViewData extends HttpServlet {

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
        StringBuilder html = new StringBuilder();
        try {
            List<Contract> contractList = dao.getContracts(req);
            if(!contractList.isEmpty()){
            html.append("<table cellspacing=\"0\">\n");
            html.append("<tr id=\"title\">\n");
            html.append("<td id=\"t_contractId\" class=\"t_contractId\">№ договора</td>\n");
            html.append("<td id=\"t_company\" class=\"t_company\">Предприятие</td>\n");
            html.append("<td id=\"t_subject\" class=\"t_subject\">Предмет договора</td>\n");
            html.append("<td id=\"t_status\" class=\"t_status\">Статус</td>\n");
            html.append("<td id=\"t_client\" class=\"t_client\">Вторая сторона договора</td>\n");
            html.append("<td id=\"t_document\" class=\"t_document\">Файл</td>\n");
            html.append("<td id=\"t_date\" class=\"t_date\">Дата добавления</td>\n");
            html.append("</tr>\n");
            for(int i=0; i<contractList.size(); i++ ) {
                Contract c = contractList.get(i);
                html.append("<tr>\n");
                html.append("<td id=\"t_contractId\" class=\"t_contractId\">"+c.getId()+"</td>\n");
                html.append("<td class=\"t_company\">" + c.getCompanyName() +"</td>\n");
                html.append("<td class=\"t_subject\">" + c.getSubject() +"</td>\n");
                html.append("<td class=\"t_subject\">" + c.getStatus() +"</td>\n");
                html.append("<td class=\"t_client\">" + c.getClientName() +"</td>\n");
                html.append("<td class=\"t_document\"><a href=\"uploads/"+c.getFileName()+"\"><img src=\"img/imgres.png\" width=\"12\"</a></td>\n");
                html.append("<td class=\"t_date\">" + c.getDate().substring(0, c.getDate().indexOf(".")) +"</td>\n");
                html.append("</tr>\n");
            }
            html.append("</table>");
            }
            else html.append("База пуста/Совпадений не найдено");
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().write(html.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }



