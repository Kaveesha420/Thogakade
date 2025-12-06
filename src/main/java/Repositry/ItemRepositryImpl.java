package Repositry;

import db.DBConnection;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepositryImpl implements ItemRepositry {

    @Override
    public ResultSet getAllItem() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM items");
        return preparedStatement.executeQuery();
    }

    @Override
    public void addItem(String itemCode, String description, String category, int qtyOnHand, double unitPrice){

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO items VALUES(?,?,?,?,?)")) {
                preparedStatement.setObject(1, itemCode);
                preparedStatement.setObject(2, description);
                preparedStatement.setObject(3, category);
                preparedStatement.setObject(4, qtyOnHand);
                preparedStatement.setObject(5, unitPrice);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateItem(String itemCode, String description, String category, int qtyOnHand, double unitPrice){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "UPDATE items SET description = ?, category = ?, qtyOnHand = ?, unitPrice = ? WHERE itemCode = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                preparedStatement.setObject(1, description);
                preparedStatement.setObject(2, category);
                preparedStatement.setObject(3, qtyOnHand);
                preparedStatement.setObject(4, unitPrice);
                preparedStatement.setObject(5, itemCode);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteItem(TextField txtItemCode){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM items WHERE itemCode = ?")) {
                preparedStatement.setObject(1, txtItemCode.getText());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
