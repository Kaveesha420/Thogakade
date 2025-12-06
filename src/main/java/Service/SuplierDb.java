package Service;

import Model.dto.SupplierDto;
import Repositry.SupplierRepositry;
import Repositry.SupplierRepositryImpl;
import db.DBConnection;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SuplierDb implements SuplierService {

    SupplierRepositry supplierRepositry = new SupplierRepositryImpl();

    @Override
    public void addSuplierDetails(String supId, String name, String companyName, String address, String city, String province, String postalCode, String phone, String email) {
        supplierRepositry.addSuplier(supId,name,companyName,address,city,province,postalCode,phone,email);
    }

    @Override
    public void UpdateSuplierDetails(String supId, String name, String companyName, String address, String city, String province, String postalCode, String phone, String email) {
        supplierRepositry.updateSuplier(supId,name,companyName,address,city,province,postalCode,phone,email);
    }

    @Override
    public void DeleteSuplierDetails(TextField txtSupID) {
       supplierRepositry.deleteSuplier(txtSupID);
    }

    @Override
    public ObservableList<SupplierDto> getAllDetails() {
        ObservableList<SupplierDto> supplierDetails = javafx.collections.FXCollections.observableArrayList();

        try {
            SupplierRepositryImpl supplierRepositry1 = new SupplierRepositryImpl();
            ResultSet resultSet = supplierRepositry1.getAllSupllier();

            while (resultSet.next()){
                supplierDetails.add(new SupplierDto(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return supplierDetails;
    }
}
