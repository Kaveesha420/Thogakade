package Repositry;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
