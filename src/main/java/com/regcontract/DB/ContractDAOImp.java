package com.regcontract.DB;

import com.regcontract.Model.Clients;
import com.regcontract.Model.Contract;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabanaus on 19.02.2017.
 */
public class ContractDAOImp implements ContractDAO {
    public Connection conn;
    private static final String SQL_INSERT = "INSERT INTO contracts (company_name, subject, status, client_name, file_name) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM contracts";
    private static final String SQL_CLIENTS = "SELECT name FROM clients WHERE name ILIKE ?";
    private static String SQL_DYNAMIC_SELECT;

    public ContractDAOImp() throws Exception {
        conn = DBUtil.getConnection();
    }

    public boolean addContract(Contract contract) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
        ps.setString(1, contract.getCompanyName());
        ps.setString(2, contract.getSubject());
        ps.setString(3, contract.getStatus());
        ps.setString(4, contract.getClientName());
        ps.setString(5, contract.getFileName());

        int count = ps.executeUpdate();
        if (count > 0) return true;
        else return false;
    }

    public List<Contract> getAllContracts() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(SQL_SELECT_ALL);
        List<Contract> contractList = new ArrayList<Contract>();
        Contract contract = null;
        while (rs.next()) {
            contract = new Contract();
            contract.setId(rs.getString("id"));
            contract.setCompanyName(rs.getString("company_name"));
            contract.setSubject(rs.getString("subject"));
            contract.setStatus(rs.getString("status"));
            contract.setClientName(rs.getString("client_name"));
            contract.setFileName(rs.getString("file_name"));
            contract.setDate(rs.getString("date"));
            contractList.add(contract);
        }
        return contractList;
    }

    public List<Contract> getContracts(HttpServletRequest req) throws SQLException {
        SQL_DYNAMIC_SELECT = null;
        SQL_DYNAMIC_SELECT = SQL_SELECT_ALL;
        String criteriaName = req.getParameter("criteriaName");
        String criteriaDate = req.getParameter("criteriaDate");
        String criteriaSubject = req.getParameter("criteriaSubject");
        PreparedStatement ps = null;
        Statement st = conn.createStatement();
        ResultSet rs;
        List<Contract> contractList = new ArrayList<Contract>();
        boolean res = false;
        if (!criteriaName.equals("")) {
            SQL_DYNAMIC_SELECT += " WHERE client_name ILIKE \'%" + criteriaName + "%\'";
            res = true;
        }
        if (!criteriaSubject.equals("") && res == true){
            SQL_DYNAMIC_SELECT += " AND subject ILIKE \'%" + criteriaSubject + "%\'";
        }
        else if (!criteriaSubject.equals("") && res == false){
            SQL_DYNAMIC_SELECT += " WHERE subject ILIKE \'%" + criteriaSubject + "%\'";
        }

            if (criteriaDate.equals("asc")) {
                SQL_DYNAMIC_SELECT += " ORDER BY date asc";
            }
            if (criteriaDate.equals("desc")) {
                SQL_DYNAMIC_SELECT += " ORDER BY date desc";
            }

            st = conn.createStatement();
            rs = st.executeQuery(SQL_DYNAMIC_SELECT);
            while (rs.next()){
                Contract contract = new Contract();
                contract.setId(rs.getString("id"));
                contract.setCompanyName(rs.getString("company_name"));
                contract.setSubject(rs.getString("subject"));
                contract.setStatus(rs.getString("status"));
                contract.setClientName(rs.getString("client_name"));
                contract.setFileName(rs.getString("file_name"));
                contract.setDate(rs.getString("date"));
                contractList.add(contract);
            }

        return contractList;
    }

    public List<Clients> getClients(HttpServletRequest req) throws SQLException {
        String term = req.getParameter("term");
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_CLIENTS);
        ps.setString(1, "%"+term+"%");
        ResultSet rs = ps.executeQuery();
        List<Clients> clientsList = new ArrayList<Clients>();
        while (rs.next()) {
            Clients clients = null;
            clients = new Clients();
            clients.setClientName(rs.getString("name"));
            clientsList.add(clients);
        }
        return clientsList;
    }
}
