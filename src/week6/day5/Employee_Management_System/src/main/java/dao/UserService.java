package dao;

import DB.DBConnection;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserService implements UserDao {
    Logger logger = Logger.getLogger("UserService");
    private static Connection conn = DBConnection.getConnection();

    public boolean verfiyUser(String username, String password) throws SQLException, ClassNotFoundException {
        User user = this.getUserByUsername(username);
        if (user == null) {
            return false;
        }
        logger.info(username + " " + password + " " + user.getPassword() + " " + user.getUsername());
        return user.getPassword().equals(password);
    }

    @Override
    public User getUserByUsername(String username) throws SQLException, ClassNotFoundException {

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setId(rs.getInt("id"));
        }
        return user;
    }

    @Override
    public User addUser(User user) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Users (username,password,role) VALUES (?,?,?)");
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getRole());
        ps.executeUpdate();
        return getUserByUsername(user.getUsername());
    }

    @Override
    public boolean deleteUser(String username) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE username = ?");
            ps.setString(1, username);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
