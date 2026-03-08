package dao;

import entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    public Employee findById(int id) throws SQLException, ClassNotFoundException;

    public Employee findByUsername(String username) throws SQLException, ClassNotFoundException;

    public List<Employee> findByDepartment(String department) throws SQLException, ClassNotFoundException;

    public List<Employee> findByCity(String city) throws SQLException, ClassNotFoundException;

    public Employee addEmployee(Employee employee) throws SQLException, ClassNotFoundException;

    public Employee updateEmployee(Employee employee) throws SQLException, ClassNotFoundException;

    public void deleteEmployee(int id) throws SQLException, ClassNotFoundException;

    public List<Employee> findAllEmployees() throws SQLException, ClassNotFoundException;

    public List<Employee> searchByName(String name) throws SQLException, ClassNotFoundException;
}
