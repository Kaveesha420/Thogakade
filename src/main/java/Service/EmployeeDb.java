package Service;

import Model.dto.EmployeeDto;
import Repositry.EmployeeRepositry;
import Repositry.EmployeeRepositryImpl;
import db.DBConnection;
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
            try {
                Connection connection = DBConnection.getInstance().getConnection();
                String SQL = "UPDATE employee SET name = ?, nic = ?, dob = ?, position = ?, salary = ?, contactNumber = ?, address = ?, joinDate = ?, status = ? WHERE employee_id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setObject(1, name);
                preparedStatement.setObject(2, nic);
                preparedStatement.setObject(3, DOB);
                preparedStatement.setObject(4, position);
                preparedStatement.setObject(5, salary);
                preparedStatement.setObject(6, contactNumber);
                preparedStatement.setObject(7, address);
                preparedStatement.setObject(8, joinDate);
                preparedStatement.setObject(9, status);
                preparedStatement.setObject(10, employeeID);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public void DeleteEmployeeDetails(TextField txtEmployeeId) {
            try {
                Connection connection = DBConnection.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE employee_id = ?");
                preparedStatement.setObject(1 , txtEmployeeId.getText());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    public ObservableList<EmployeeDto> getAllEmployee() {

            ObservableList<EmployeeDto> employeeDetails = javafx.collections.FXCollections.observableArrayList();

        try {
           Connection connection = DBConnection.getInstance().getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
           ResultSet resultSet = preparedStatement.executeQuery();

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
