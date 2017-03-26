package com.regcontract.DB;

import com.regcontract.Model.Clients;
import com.regcontract.Model.Contract;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kabanaus on 19.02.2017.
 */
public interface ContractDAO {
    public boolean addContract(Contract ct) throws SQLException;
    public List<Contract> getAllContracts() throws SQLException;
    public List<Contract> getContracts(HttpServletRequest req) throws SQLException;
    public List<Clients> getClients(HttpServletRequest req) throws SQLException;
}
