package Model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDto {
    private String employeeId;
    private String name;
    private String nic;
    private String dob;
    private String position;
    private double salary;
    private String ContactNumber;
    private String address;
    private String joinedDate;
    private String status;
}
