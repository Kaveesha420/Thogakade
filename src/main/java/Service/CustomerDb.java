package Service;

import Model.dto.CustomerDto;
import Repositry.CustomerRepositry;
import Repositry.CustomerRepositryImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import java.util.List;

public class CustomerDb implements CustomerService {
    CustomerRepositry customerRepositry = new CustomerRepositryImpl();

    @Override
    public void AddCusDetails(String cusId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode) {
        CustomerDto customer = new CustomerDto(cusId, title, name, dob, salary, address, city, province, postalCode);
        customerRepositry.addCustomer(customer);
    }

    @Override
    public void UpdateCus(String cusId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode) {
        CustomerDto customer = new CustomerDto(cusId, title, name, dob, salary, address, city, province, postalCode);
        customerRepositry.updateCustomer(customer);
    }

    @Override
    public void DeleteCus(TextField txtCusId) {
        customerRepositry.deleteCustomer(txtCusId.getText());
    }

    @Override
    public ObservableList<CustomerDto> getAllCustomer() {
        List<CustomerDto> list = customerRepositry.getAllCustomer();
        return FXCollections.observableArrayList(list);
    }
}