package Repositry;

import db.DBConnection;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositryImpl implements CustomerRepositry{
    @Override
    public void addCustomer(String cusId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setObject(1, cusId);
            preparedStatement.setObject(2, title);
            preparedStatement.setObject(3, name);
            preparedStatement.setObject(4, dob);
            preparedStatement.setObject(5, salary);
            preparedStatement.setObject(6, address);
            preparedStatement.setObject(7, city);
            preparedStatement.setObject(8, province);
            preparedStatement.setObject(9, postalCode);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCustomer(String cusId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "UPDATE customers SET title = ?, name = ?, dob = ?, salary = ?, address = ?, city = ?, province = ?, postalCode = ? WHERE customer_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);


            preparedStatement.setObject(1, title);
            preparedStatement.setObject(2, name);
            preparedStatement.setObject(3, dob);
            preparedStatement.setObject(4, salary);
            preparedStatement.setObject(5, address);
            preparedStatement.setObject(6, city);
            preparedStatement.setObject(7, province);
            preparedStatement.setObject(8, postalCode);
            preparedStatement.setObject(9, cusId);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCustomer(TextField txtCusId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement psvm = connection.prepareStatement("DELETE FROM customers WHERE customer_id = ?");

            psvm.setObject(1,txtCusId.getText());
            psvm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public ResultSet getAllCustomer() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers");
        return preparedStatement.executeQuery();
    }
}
