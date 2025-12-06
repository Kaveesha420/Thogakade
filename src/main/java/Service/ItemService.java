package Service;

import Model.dto.ItemDto;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public interface ItemService {
    void addItemsDetails(String itemCode, String description, String category, int qtyOnHand, double unitPrice);
    void UpdateItemsDetails(String itemCode, String description, String category, int qtyOnHand, double unitPrice);
    void DeleteItemsDetails(TextField txtItemCode);

    ObservableList<ItemDto> getAllItems();
}
