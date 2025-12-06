package Service;

import Model.dto.EmployeeDto;
import Repositry.EmployeeRepositry;
import Repositry.EmployeeRepositryImpl;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.*;

public class EmployeeDb implements EmployeeService {

    EmployeeRepositry employeeRepositry = new EmployeeRepositryImpl();

        @Override
        public void AddEmployeeDetails(String employeeID, String name, String nic, String DOB, String position, double salary, String contactNumber, String address, String joinDate, String status){
            employeeRepositry.addEmployee(employeeID,name,nic,DOB,position,salary,contactNumber,address,joinDate,status);
        }

        public void UpdateEmployeeDetails(String employeeID, String name, String nic, String DOB, String position, double salary, String contactNumber, String address, String joinDate, String status){
            employeeRepositry.updateEmployee(employeeID,name,nic,DOB,position,salary,contactNumber,address,joinDate,status);
        }

        public void DeleteEmployeeDetails(TextField txtEmployeeId) {
            employeeRepositry.deleteEmployee(txtEmployeeId);
        }


    public ObservableList<EmployeeDto> getAllEmployee() {

            ObservableList<EmployeeDto> employeeDetails = javafx.collections.FXCollections.observableArrayList();

        try {
           EmployeeRepositryImpl employeeRepositry1 = new EmployeeRepositryImpl();
           ResultSet resultSet = employeeRepositry1.getAllEmployee();
            while (resultSet.next()){
                employeeDetails.add(new EmployeeDto(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getDouble(6),
                                resultSet.getString(7),
                                resultSet.getString(8),
                                resultSet.getString(9),
                                resultSet.getString(10)
                        )
                );

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeDetails;
    }

}
