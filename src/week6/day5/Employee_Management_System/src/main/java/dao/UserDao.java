package dao;

import entity.User;

import java.sql.SQLException;

public interface UserDao {
    public User getUserByUsername(String username) throws SQLException, ClassNotFoundException;
    public User addUser(User user) throws SQLException, ClassNotFoundException;
    public boolean deleteUser(String username) throws SQLException, ClassNotFoundException;
    public boolean updateUser(User user) throws SQLException, ClassNotFoundException;
    public boolean verfiyUser(String username, String password) throws SQLException, ClassNotFoundException;
}
