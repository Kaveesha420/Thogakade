package Repositry;

import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepositry {
    void addCustomer(String cusId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode);
    void updateCustomer(String cusId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode);
    void deleteCustomer(TextField txtCusId);
    ResultSet getAllCustomer() throws SQLException;
}
