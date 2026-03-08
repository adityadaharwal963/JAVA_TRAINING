package dao;

import DB.DBConnection;
import entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements EmployeeDao {
    private static Connection conn = DBConnection.getConnection();

    private Employee mapResultSetToEmployee(ResultSet rs) throws SQLException {
        Employee emp = new Employee();
        emp.setId(rs.getInt("id"));
        emp.setName(rs.getString("name"));
        emp.setEmail(rs.getString("email"));
        emp.setPhone(rs.getString("phone"));
        emp.setDepartment(rs.getString("department"));
        emp.setDesignation(rs.getString("designation"));
        emp.setSalary(rs.getDouble("salary"));
        emp.setAddress(rs.getString("address"));
        emp.setCity(rs.getString("city"));
        emp.setGender(rs.getString("gender"));
        emp.setUserId(rs.getInt("id"));
        return emp;
    }

    @Override
    public Employee findById(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return mapResultSetToEmployee(rs);
        }
        return null;
    }

    @Override
    public Employee findByUsername(String username) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = conn
                .prepareStatement("SELECT e.* FROM Employee e JOIN Users u ON e.id = u.id WHERE u.username = ?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return mapResultSetToEmployee(rs);
        }
        return null;
    }

    @Override
    public List<Employee> findByDepartment(String department) throws SQLException, ClassNotFoundException {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE department LIKE ?");
        ps.setString(1, "%" + department + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(mapResultSetToEmployee(rs));
        }
        return list;
    }

    @Override
    public List<Employee> findByCity(String city) throws SQLException, ClassNotFoundException {
        return List.of();
    }

    public List<Employee> searchByName(String name) throws SQLException, ClassNotFoundException {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE name LIKE ?");
        ps.setString(1, "%" + name + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(mapResultSetToEmployee(rs));
        }
        return list;
    }

    @Override
    public Employee addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO Employee (id, name, email, phone, address, department, city, designation, gender, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setInt(1, employee.getUserId());
        ps.setString(2, employee.getName());
        ps.setString(3, employee.getEmail());
        ps.setString(4, employee.getPhone());
        ps.setString(5, employee.getAddress());
        ps.setString(6, employee.getDepartment());
        ps.setString(7, employee.getCity());
        ps.setString(8, employee.getDesignation());
        ps.setString(9, employee.getGender());

        ps.setDouble(10, employee.getSalary());

        ps.executeUpdate();
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE Employee SET name=?, email=?, phone=?, department=?, designation=?, salary=?, address=?, city=?, gender=? WHERE id=?");
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getEmail());
        ps.setString(3, employee.getPhone());
        ps.setString(4, employee.getDepartment());
        ps.setString(5, employee.getDesignation());

        ps.setDouble(6, employee.getSalary());

        ps.setString(7, employee.getAddress());
        ps.setString(8, employee.getCity());
        ps.setString(9, employee.getGender());
        ps.setInt(10, employee.getId());
        ps.executeUpdate();
        return employee;
    }

    @Override
    public void deleteEmployee(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = conn.prepareStatement("DELETE FROM Employee WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Employee> findAllEmployees() throws SQLException, ClassNotFoundException {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(mapResultSetToEmployee(rs));
        }
        return list;
    }
}
