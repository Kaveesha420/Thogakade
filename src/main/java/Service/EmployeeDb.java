package Service;

import Model.dto.EmployeeDto;
import Repositry.EmployeeRepositry;
import Repositry.EmployeeRepositryImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import java.util.List;

public class EmployeeDb implements EmployeeService {
    EmployeeRepositry employeeRepositry = new EmployeeRepositryImpl();

    @Override
    public void AddEmployeeDetails(String employeeID, String name, String nic, String DOB, String position, double salary, String contactNumber, String address, String joinDate, String status) {
        EmployeeDto employee = new EmployeeDto(employeeID, name, nic, DOB, position, salary, contactNumber, address, joinDate, status);
        employeeRepositry.addEmployee(employee);
    }

    @Override
    public void UpdateEmployeeDetails(String employeeID, String name, String nic, String DOB, String position, double salary, String contactNumber, String address, String joinDate, String status) {
        EmployeeDto employee = new EmployeeDto(employeeID, name, nic, DOB, position, salary, contactNumber, address, joinDate, status);
        employeeRepositry.updateEmployee(employee);
    }

    @Override
    public void DeleteEmployeeDetails(TextField txtEmployeeId) {
        employeeRepositry.deleteEmployee(txtEmployeeId.getText());
    }

    @Override
    public ObservableList<EmployeeDto> getAllEmployee() {
        List<EmployeeDto> list = employeeRepositry.getAllEmployee();
        return FXCollections.observableArrayList(list);
    }
}