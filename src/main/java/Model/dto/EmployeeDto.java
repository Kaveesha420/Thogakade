package Model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employee")
public class EmployeeDto {
    @Id
    @Column(name = "employee_id")
    private String employeeId;
    private String name;
    private String nic;
    private String dob;
    private String position;
    private double salary;
    private String contactNumber;
    private String address;
    private String joinDate;
    private String status;

}


