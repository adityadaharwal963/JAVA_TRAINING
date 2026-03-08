package org.example;

import java.sql.*;
import java.util.UUID;


public class Operation extends DBConnection {

    private String getEID(){
        String sql = "SELECT MAX(eid) FROM employees";
        String eid = "E000";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String id = rs.getString("eid");
                Integer i = Integer.parseInt(id.substring(1, id.length()-1));
                if(i<10){
                    eid = "E00"+i;
                } else if (i<100) {
                    eid = "E0"+i;
                } else if (i<1000) {
                    eid = "E"+i;
                }else {
                    System.out.println("OVERFLOW");
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eid;
    }
    void insert(String name, String designation, int salary) throws SQLException {
        String eid = getEID();
        if(eid==null){
            System.out.println("OVERFLOW");
            return;
        }
        String sql = "INSERT INTO employee (eid, name, designation, salary) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, eid);
            ps.setString(2, name);
            ps.setString(3, designation);
            ps.setInt(4, salary);
            ps.executeUpdate();
            System.out.println("Employee inserted successfully!");
        }
    }

    void delete(int eid) throws SQLException {
        String sql = "DELETE FROM employee WHERE eid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, eid);
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");
        }
    }

    void deleteAll() throws SQLException {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("TRUNCATE TABLE employee;");
            System.out.println("Table cleared.");
        }
    }


    void update(String column, String value, int id) throws SQLException {

        String sql = "UPDATE employee SET " + column.toLowerCase().trim() + " = ? WHERE eid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            if (column.equalsIgnoreCase("salary")) {
                ps.setInt(1, Integer.parseInt(value));
            } else {
                ps.setString(1, value);
            }
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " row(s).");
        }
    }

    void view(String query, Object param) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            if (param != null) {
                if (param instanceof Integer) ps.setInt(1, (Integer) param);
                else ps.setString(1, (String) param);
            }

            ResultSet rs = ps.executeQuery();
            System.out.println("\nEID | Name | Designation | Salary");
            System.out.println("-----------------------------------");
            while (rs.next()) {
                System.out.printf("%s | %s | %s | %d\n",
                        rs.getString("eid"), rs.getString("name"),
                        rs.getString("designation"), rs.getInt("salary"));
            }
        }
    }

}