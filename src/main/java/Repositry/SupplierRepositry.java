package Repositry;

import javafx.scene.control.TextField;

public interface SupplierRepositry {
    void addSuplier(String supId, String name, String companyName, String address, String city, String province, String postalCode, String phone, String email);
    void updateSuplier(String supId, String name, String companyName, String address, String city, String province, String postalCode, String phone, String email);
    void deleteSuplier(TextField txtSupID);
}
