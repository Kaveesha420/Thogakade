package Service;

import Model.dto.CustomerDto;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public interface CustomerService {
    void DeleteCus(TextField txtCusId);
    void UpdateCus(String cusId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode);
    void AddCusDetails(String cusId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode);
    ObservableList<CustomerDto> getAllCustomer();
}