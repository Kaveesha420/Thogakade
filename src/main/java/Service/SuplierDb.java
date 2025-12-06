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
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "UPDATE supplier SET name = ?, companyName = ?, address = ?, city = ?, province = ?, postalCode = ?, phone = ?, email = ? WHERE supplier_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,name);
            preparedStatement.setObject(2,companyName);
            preparedStatement.setObject(3,address);
            preparedStatement.setObject(4,city);
            preparedStatement.setObject(5,province);
            preparedStatement.setObject(6,postalCode);
            preparedStatement.setObject(7,phone);
            preparedStatement.setObject(8,email);
            preparedStatement.setObject(9,supId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void DeleteSuplierDetails(TextField txtSupID) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM supplier WHERE supplier_id = ?");
            preparedStatement.setObject(1,txtSupID.getText());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<SupplierDto> getAllDetails() {
        ObservableList<SupplierDto> supplierDetails = javafx.collections.FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM supplier");
            ResultSet resultSet = preparedStatement.executeQuery();

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
