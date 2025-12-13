package Repositry;

import Model.dto.EmployeeDto;
import java.util.List;

public interface EmployeeRepositry {
    void addEmployee(EmployeeDto employee);
    void updateEmployee(EmployeeDto employee);
    void deleteEmployee(String employeeId);
    List<EmployeeDto> getAllEmployee();
}