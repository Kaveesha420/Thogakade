package Service;

import Model.dto.ItemDto;
import Repositry.ItemRepositry;
import Repositry.ItemRepositryImpl;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDb implements ItemService {

    ItemRepositry itemRepositry = new ItemRepositryImpl();

    @Override
    public void addItemsDetails(String itemCode, String description, String category, int qtyOnHand, double unitPrice) {
        itemRepositry.addItem(itemCode, description, category, qtyOnHand, unitPrice);
    }

    @Override
    public void UpdateItemsDetails(String itemCode, String description, String category, int qtyOnHand, double unitPrice) {
       itemRepositry.updateItem(itemCode,description,category,qtyOnHand,unitPrice);
    }

    @Override
    public void DeleteItemsDetails(TextField txtItemCode) {
        itemRepositry.deleteItem(txtItemCode);
    }

    @Override
    public ObservableList<ItemDto> getAllItems() {
        ObservableList<ItemDto> itemDetails = javafx.collections.FXCollections.observableArrayList();

        try {
            ItemRepositryImpl itemRepositry = new ItemRepositryImpl();
            ResultSet resultSet = itemRepositry.getAllItem();
                while (resultSet.next()){
                    itemDetails.add(new ItemDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getDouble(5)
                    ));
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemDetails;
    }
}
