package Repositry;

import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SupplierRepositry {
    void addSuplier(String supId, String name, String companyName, String address, String city, String province, String postalCode, String phone, String email);
    void updateSuplier(String supId, String name, String companyName, String address, String city, String province, String postalCode, String phone, String email);
    void deleteSuplier(TextField txtSupID);
    ResultSet getAllSupllier() throws SQLException;
}
