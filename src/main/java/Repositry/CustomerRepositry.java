package Repositry;

import Model.dto.CustomerDto;
import java.util.List;

public interface CustomerRepositry {
    void addCustomer(CustomerDto customer);
    void updateCustomer(CustomerDto customer);
    void deleteCustomer(String cusId);
    List<CustomerDto> getAllCustomer();
}