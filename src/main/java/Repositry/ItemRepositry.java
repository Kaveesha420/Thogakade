package Repositry;

import Model.dto.ItemDto;
import java.util.List;

public interface ItemRepositry {
    List<ItemDto> getAllItem();
    void addItem(ItemDto item);
    void updateItem(ItemDto item);
    void deleteItem(String itemCode);
}