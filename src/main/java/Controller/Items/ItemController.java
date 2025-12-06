package Controller.Items;

import Model.dto.ItemDto;
import Service.ItemDb;
import Service.ItemService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemController implements Initializable {

    ItemService itemService = new ItemDb();
    ObservableList <ItemDto> itemDtos = FXCollections.observableArrayList(

    );

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<ItemDto> tblItemInfo;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

    public void btnDelete(ActionEvent actionEvent) {

        itemDtos.clear();

        itemService.DeleteItemsDetails(txtItemCode);
        clearField();
        loadDetails();
    }

    public void btnClear(ActionEvent actionEvent) {
        txtItemCode.setText("");
        txtDescription.setText("");
        txtCategory.setText("");
        txtQtyOnHand.setText("");
        txtUnitPrice.setText("");
    }

    public void btnUpdate(ActionEvent actionEvent) {
       itemDtos.clear();

        String ItemCode = txtItemCode.getText();
        String Description = txtDescription.getText();
        String Category = txtCategory.getText();
        int QtyOnHand = Integer.parseInt(txtQtyOnHand.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());

        itemService.UpdateItemsDetails(ItemCode,Description,Category,QtyOnHand,unitPrice);
        clearField();
        loadDetails();

    }

    public void btnAdd(ActionEvent actionEvent) {

        itemDtos.clear();

        String ItemCode = txtItemCode.getText();
        String Description = txtDescription.getText();
        String Category = txtCategory.getText();
        int QtyOnHand = Integer.parseInt(txtQtyOnHand.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());

        itemService.addItemsDetails(ItemCode,Description,Category,QtyOnHand,unitPrice);

        clearField();
        loadDetails();
    }

    @FXML
    void ReloadOnAction(ActionEvent event) {
        loadDetails();
    }

    public void loadDetails(){
        tblItemInfo.setItems(itemService.getAllItems());
    }
    public void clearField(){
        txtCategory.clear();
        txtItemCode.clear();
        txtDescription.clear();
        txtUnitPrice.clear();
        txtQtyOnHand.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            tblItemInfo.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue )-> {
                if (newValue != null){
                    txtItemCode.setText(newValue.getItemCode());
                    txtDescription.setText(newValue.getDescription());
                    txtCategory.setText(newValue.getCategory());
                    txtQtyOnHand.setText(String.valueOf(newValue.getQtyOnHand()));
                    txtUnitPrice.setText(String.valueOf(newValue.getUnitPrice()));

                }

            });
            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
            colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
            colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
            loadDetails();

    }
}
