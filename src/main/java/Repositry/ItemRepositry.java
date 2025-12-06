package Repositry;

import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemRepositry {
    ResultSet getAllItem() throws SQLException;
    void addItem(String itemCode, String description, String category, int qtyOnHand, double unitPrice);
    void updateItem(String itemCode, String description, String category, int qtyOnHand, double unitPrice);
    void deleteItem(TextField txtItemCode);
}
