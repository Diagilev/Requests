package com.regcontract.DB;

import com.regcontract.Model.User;

import java.sql.SQLException;

/**
 * Created by kabanaus on 20.03.2017.
 */
public interface UserDAO {
    public boolean addUser(User user) throws SQLException;
    public User getById(User user) throws SQLException;
    public User getByEmail(User user) throws SQLException;

}
