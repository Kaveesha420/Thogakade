package Controller.Supplier;

import Model.dto.SupplierDto;
import Service.SuplierDb;
import Service.SuplierService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplierController implements Initializable {

    SuplierService suplierService = new SuplierDb();
    ObservableList<SupplierDto> supplierDtos = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> ColCompanyName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSupID;

    @FXML
    private TableView<SupplierDto> tblSupplierInfo;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCompanyName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSupID;

    public void btnClear(ActionEvent actionEvent) {
        clearField();
    }

    public void btnDelete(ActionEvent actionEvent) {
        suplierService.DeleteSuplierDetails(txtSupID);
        clearField();
        loadDetails();
    }

    public void btnUpdate(ActionEvent actionEvent) {
        String supId = txtSupID.getText();
        String name = txtName.getText();
        String companyName = txtCompanyName.getText();
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String province = txtProvince.getText();
        String postalCode = txtPostalCode.getText();
        String phone = txtPhoneNumber.getText();
        String email = txtEmail.getText();

        suplierService.UpdateSuplierDetails(supId, name, companyName, address, city, province, postalCode, phone, email);
        clearField();
        loadDetails();
    }

    public void btnAdd(ActionEvent actionEvent) {
        String supId = txtSupID.getText();
        String name = txtName.getText();
        String companyName = txtCompanyName.getText();
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String province = txtProvince.getText();
        String postalCode = txtPostalCode.getText();
        String phone = txtPhoneNumber.getText();
        String email = txtEmail.getText();

        suplierService.addSuplierDetails(supId, name, companyName, address, city, province, postalCode, phone, email);
        clearField();
        loadDetails();
    }

    public void clearField() {
        txtAddress.clear();
        txtCity.clear();
        txtSupID.clear();
        txtName.clear();
        txtEmail.clear();
        txtCompanyName.clear();
        txtPhoneNumber.clear();
        txtPostalCode.clear();
        txtProvince.clear();
    }

    public void loadDetails() {
        tblSupplierInfo.setItems(suplierService.getAllDetails());
    }

    @FXML
    void ReloadOnAction(ActionEvent event) {
        loadDetails();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colSupID.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblSupplierInfo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtSupID.setText(newValue.getSupplierId());
                txtName.setText(newValue.getName());
                txtCompanyName.setText(newValue.getCompanyName());
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(newValue.getCity());
                txtProvince.setText(newValue.getProvince());
                txtPostalCode.setText(newValue.getPostalCode());
                txtPhoneNumber.setText(newValue.getPhone());
                txtEmail.setText(newValue.getEmail());
            }
        });

        loadDetails();
    }
}