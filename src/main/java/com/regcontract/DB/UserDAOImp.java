package com.regcontract.DB;

import com.regcontract.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kabanaus on 20.03.2017.
 */
public class UserDAOImp implements UserDAO{
    private static final String SQL_INSERT = "INSERT INTO users (name, surname, email, password) VALUES (?, ?, ?, ?)";
    private static final String SQL_USERBYID = "SELECT * FROM users where id = ?";
    private static String SQL_USERBYEMAIL = "SELECT * FROM users where email = ?";

    public Connection conn;
    public UserDAOImp() throws Exception{
            conn = DBUtil.getConnection();
    }

    public boolean addUser(User user) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
        ps.setString(1, user.getName());
        ps.setString(2, user.getSurname());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        int count = ps.executeUpdate();
        if (count>0) return true;
        else return false;
    }

    public User getById(User user) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(SQL_USERBYID);
        ps.setInt(1, user.getId());
        ResultSet rs = ps.executeQuery();
        rs.next();
        User dbuser = new User();
        dbuser.setId(rs.getInt("id"));
        dbuser.setName(rs.getString("name"));
        dbuser.setSurname(rs.getString("surname"));
        dbuser.setEmail(rs.getString("email"));
        dbuser.setPassword(rs.getString("password"));
        return dbuser;
    }


    public User getByEmail(User user) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(SQL_USERBYEMAIL);
        ps.setString(1, user.getEmail());
        ResultSet rs = ps.executeQuery();
        boolean s = rs.next();
        User dbuser = new User();
        dbuser.setId(rs.getInt("id"));
        dbuser.setName(rs.getString("name"));
        dbuser.setSurname(rs.getString("surname"));
        dbuser.setEmail(rs.getString("email"));
        dbuser.setPassword(rs.getString("password"));
        return dbuser;
    }
}
