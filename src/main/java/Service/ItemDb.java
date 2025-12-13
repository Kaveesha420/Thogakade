package Service;

import Model.dto.ItemDto;
import Repositry.ItemRepositry;
import Repositry.ItemRepositryImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import java.util.List;

public class ItemDb implements ItemService {
    ItemRepositry itemRepositry = new ItemRepositryImpl();

    @Override
    public void addItemsDetails(String itemCode, String description, String category, int qtyOnHand, double unitPrice) {
        ItemDto item = new ItemDto(itemCode, description, category, qtyOnHand, unitPrice);
        itemRepositry.addItem(item);
    }

    @Override
    public void UpdateItemsDetails(String itemCode, String description, String category, int qtyOnHand, double unitPrice) {
        ItemDto item = new ItemDto(itemCode, description, category, qtyOnHand, unitPrice);
        itemRepositry.updateItem(item);
    }

    @Override
    public void DeleteItemsDetails(TextField txtItemCode) {

        itemRepositry.deleteItem(txtItemCode.getText());
    }

    @Override
    public ObservableList<ItemDto> getAllItems() {
        List<ItemDto> items = itemRepositry.getAllItem();
        return FXCollections.observableArrayList(items);
    }
}