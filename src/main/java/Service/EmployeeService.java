package Service;

import Model.dto.EmployeeDto;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public interface EmployeeService {
    void AddEmployeeDetails(String employeeID, String name, String nic, String DOB, String position, double salary, String contactNumber, String address, String joinDate, String status);
    void UpdateEmployeeDetails(String employeeID, String name, String nic, String DOB, String position, double salary, String contactNumber, String address, String joinDate, String status);
    void DeleteEmployeeDetails(TextField txtEmployeeId);
    ObservableList<EmployeeDto> getAllEmployee();
}