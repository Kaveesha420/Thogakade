package Repositry;

import db.DBConnection;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierRepositryImpl implements SupplierRepositry{

    @Override
    public void addSuplier(String supId, String name, String companyName, String address, String city, String province, String postalCode, String phone, String email) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO supplier VALUES(?,?,?,?,?,?,?,?,?)")) {
                preparedStatement.setObject(1, supId);
                preparedStatement.setObject(2, name);
                preparedStatement.setObject(3, companyName);
                preparedStatement.setObject(4, address);
                preparedStatement.setObject(5, city);
                preparedStatement.setObject(6, province);
                preparedStatement.setObject(7, postalCode);
                preparedStatement.setObject(8, phone);
                preparedStatement.setObject(9, email);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSuplier(String supId, String name, String companyName, String address, String city, String province, String postalCode, String phone, String email) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "UPDATE supplier SET name = ?, companyName = ?, address = ?, city = ?, province = ?, postalCode = ?, phone = ?, email = ? WHERE supplier_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                preparedStatement.setObject(1, name);
                preparedStatement.setObject(2, companyName);
                preparedStatement.setObject(3, address);
                preparedStatement.setObject(4, city);
                preparedStatement.setObject(5, province);
                preparedStatement.setObject(6, postalCode);
                preparedStatement.setObject(7, phone);
                preparedStatement.setObject(8, email);
                preparedStatement.setObject(9, supId);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteSuplier(TextField txtSupID) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM supplier WHERE supplier_id = ?")) {
                preparedStatement.setObject(1, txtSupID.getText());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet getAllSupllier() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM supplier");
        return preparedStatement.executeQuery();
    }
}
