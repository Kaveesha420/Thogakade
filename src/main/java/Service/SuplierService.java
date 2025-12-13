package Service;

import Model.dto.SupplierDto;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public interface SuplierService {
    void addSuplierDetails(String supId, String name, String companyName, String address, String city, String province, String postalCode, String phone, String email);
    void UpdateSuplierDetails(String supId, String name, String companyName, String address, String city, String province, String postalCode, String phone, String email);
    void DeleteSuplierDetails(TextField txtSupID);
    ObservableList<SupplierDto> getAllDetails();
}