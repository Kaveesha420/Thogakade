package Repositry;

import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeRepositry {
    void addEmployee(String employeeID, String name, String nic, String dob, String position, double salary, String contactNumber, String address, String joinDate, String status);
    void updateEmployee(String employeeID, String name, String nic, String dob, String position, double salary, String contactNumber, String address, String joinDate, String status);
    void deleteEmployee(TextField txtEmployeeId);
    ResultSet getAllEmployee() throws SQLException;
}
