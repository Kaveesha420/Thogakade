package Service;

import Model.dto.SupplierDto;
import Repositry.SupplierRepositry;
import Repositry.SupplierRepositryImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import java.util.List;

public class SuplierDb implements SuplierService {
    SupplierRepositry supplierRepositry = new SupplierRepositryImpl();

    @Override
    public void addSuplierDetails(String supId, String name, String companyName, String address, String city, String province, String postalCode, String phone, String email) {
        SupplierDto supplier = new SupplierDto(supId,name,companyName,address,city,province,postalCode,phone,email);
        supplierRepositry.addSuplier(supplier);
    }

    @Override
    public void UpdateSuplierDetails(String supId, String name, String companyName, String address, String city, String province, String postalCode, String phone, String email) {
        SupplierDto supplier = new SupplierDto(supId, name, companyName, address, city, province, postalCode, phone, email);
        supplierRepositry.updateSuplier(supplier);
    }

    @Override
    public void DeleteSuplierDetails(TextField txtSupID) {
        supplierRepositry.deleteSuplier(txtSupID.getText());
    }

    @Override
    public ObservableList<SupplierDto> getAllDetails() {
        List<SupplierDto> list = supplierRepositry.getAllSupllier();
        return FXCollections.observableArrayList(list);
    }
}