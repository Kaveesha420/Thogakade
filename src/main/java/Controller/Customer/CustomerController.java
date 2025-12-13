package Controller.Customer;

import Model.dto.CustomerDto;
import Service.CustomerDb;
import Service.CustomerService;
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

public class CustomerController implements Initializable {

    CustomerService customerService = new CustomerDb();
    ObservableList<CustomerDto> customerDtos = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCusId;

    @FXML
    private TableColumn<?, ?> colDoB;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<CustomerDto> tblCustomerInfo;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCusId;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtname;

    public void btnClear(ActionEvent actionEvent) {
        clearFields();
    }

    public void btnDelete(ActionEvent actionEvent) {
        customerService.DeleteCus(txtCusId);
        clearFields();
        loadDetails();
    }

    public void btnUpdate(ActionEvent actionEvent) {
        String CusId = txtCusId.getText();
        String Title = txtTitle.getText();
        String name = txtname.getText();
        String dob = txtDob.getText();
        double Salary = Double.parseDouble(txtSalary.getText());
        String Address = txtAddress.getText();
        String City = txtCity.getText();
        String Province = txtProvince.getText();
        String PostalCode = txtPostalCode.getText();

        customerService.UpdateCus(CusId, Title, name, dob, Salary, Address, City, Province, PostalCode);
        clearFields();
        loadDetails();
    }

    public void btnAdd(ActionEvent actionEvent) {
        String CusId = txtCusId.getText();
        String Title = txtTitle.getText();
        String name = txtname.getText();
        String dob = txtDob.getText();
        double Salary = Double.parseDouble(txtSalary.getText());
        String Address = txtAddress.getText();
        String City = txtCity.getText();
        String Province = txtProvince.getText();
        String PostalCode = txtPostalCode.getText();

        customerService.AddCusDetails(CusId, Title, name, dob, Salary, Address, City, Province, PostalCode);
        clearFields();
        loadDetails();
    }

    public void loadDetails() {
        tblCustomerInfo.setItems(customerService.getAllCustomer());
    }

    @FXML
    void ReloadOnAction(ActionEvent event) {
        loadDetails();
    }

    public void clearFields() {
        txtCusId.clear();
        txtTitle.clear();
        txtname.clear();
        txtDob.clear();
        txtSalary.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvince.clear();
        txtPostalCode.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCusId.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDoB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        tblCustomerInfo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtCusId.setText(newValue.getCusId());
                txtTitle.setText(newValue.getTitle());
                txtname.setText(newValue.getName());
                txtDob.setText(newValue.getDob());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(newValue.getCity());
                txtProvince.setText(newValue.getProvince());
                txtPostalCode.setText(newValue.getPostalCode());
            }
        });

        loadDetails();
    }
}