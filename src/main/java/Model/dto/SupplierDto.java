package Model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupplierDto {
    private String supplierId;
    private String name;
    private String companyName;
    private String address;
    private String City;
    private String province;
    private String postalCode;
    private String phone;
    private String email;
}
