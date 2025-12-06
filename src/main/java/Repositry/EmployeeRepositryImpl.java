package Repositry;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeRepositryImpl implements EmployeeRepositry{
    @Override
    public void addEmployee(String employeeID, String name, String nic, String dob, String position, double salary, String contactNumber, String address, String joinDate, String status) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setObject(1, employeeID);
            preparedStatement.setObject(2, name);
            preparedStatement.setObject(3, nic);
            preparedStatement.setObject(4, dob);
            preparedStatement.setObject(5, position);
            preparedStatement.setObject(6, salary);
            preparedStatement.setObject(7, contactNumber);
            preparedStatement.setObject(8, address);
            preparedStatement.setObject(9, joinDate);
            preparedStatement.setObject(10, status);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
