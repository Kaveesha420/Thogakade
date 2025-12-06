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

//    Customer_Db_Controller customer_db_controller = new Customer_Db_Controller();
    CustomerService customerService = new CustomerDb();

    ObservableList <CustomerDto> customerDtos = FXCollections.observableArrayList(

//            new CustomerDto("C001","Mr.","Danapala","1981-02-06",40000,"No.20 walana","Panadura","Western","12500"),
//            new CustomerDto("C002","Mr.","Gunapala","1992-03-07",50000,"No.21 Keselwatta","Panadura","Western","12500"),
//            new CustomerDto("C003","Mr.","Sumanapala","1985-02-16",60000,"No.22 Hirana","Panadura","Western","12500"),
//            new CustomerDto("C004","Mr.","Somapala","1986-04-26",70000,"No.23 Dibbaddaa","Panadura","Western","12500"),
//            new CustomerDto("C005","Mr.","Giripala","1989-08-09",80000,"No.24 moravinna","Panadura","Western","12500"),
//            new CustomerDto("C006","Mr.","Siripala","1998-03-28",90000,"No.25 Nalluruwa","Panadura","Western","12500"),
//            new CustomerDto("C007","Mr.","Henapala","1985-11-24",20000,"No.26 pinwatta","Panadura","Western","12500")

    );

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
        txtCusId.setText("");
        txtTitle.setText("");
        txtname.setText("");
        txtDob.setText("");
        txtSalary.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtProvince.setText("");
        txtPostalCode.setText("");
    }

    public void btnDelete(ActionEvent actionEvent) {
//        CustomerDto SelectInfo = tblCustomerInfo.getSelectionModel().getSelectedItem();
//        customerDtos.remove(SelectInfo);
//        tblCustomerInfo.refresh();
//
//        txtCusId.setText("");
//        txtTitle.setText("");
//        txtname.setText("");
//        txtDob.setText("");
//        txtSalary.setText("");
//        txtAddress.setText("");
//        txtCity.setText("");
//        txtProvince.setText("");
//        txtPostalCode.setText("");

        customerDtos.clear();

        customerService.DeleteCus(txtCusId);

        clearFields();
        loadDetails();
    }

    public void btnUpdate(ActionEvent actionEvent) {
//        CustomerDto SelectUpdateInfo = tblCustomerInfo.getSelectionModel().getSelectedItem();
//        SelectUpdateInfo.setCusId(txtCusId.getText());
//        SelectUpdateInfo.setTitle(txtTitle.getText());
//        SelectUpdateInfo.setName(txtname.getText());
//        SelectUpdateInfo.setDob(txtDob.getText());
//        SelectUpdateInfo.setSalary(Double.parseDouble(txtSalary.getText()));
//        SelectUpdateInfo.setAddress(txtAddress.getText());
//        SelectUpdateInfo.setCity(txtCity.getText());
//        SelectUpdateInfo.setProvince(txtProvince.getText());
//        SelectUpdateInfo.setPostalCode(txtPostalCode.getText());
//
//        tblCustomerInfo.refresh();
//
//        txtCusId.setText("");
//        txtTitle.setText("");
//        txtname.setText("");
//        txtDob.setText("");
//        txtSalary.setText("");
//        txtAddress.setText("");
//        txtCity.setText("");
//        txtProvince.setText("");
//        txtPostalCode.setText("");

        customerDtos.clear();

        String CusId = txtCusId.getText();
        String Title = txtTitle.getText();
        String name = txtname.getText();
        String dob = txtDob.getText();
        double Salary = Double.parseDouble(txtSalary.getText());
        String Address = txtAddress.getText();
        String City = txtCity.getText();
        String Province = txtProvince.getText();
        String PostalCode = txtPostalCode.getText();

        customerService.UpdateCus(CusId,Title,name,dob,Salary,Address,City,Province,PostalCode);

        clearFields();
        loadDetails();
    }

    public void btnAdd(ActionEvent actionEvent) {

        customerDtos.clear();

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
//        CustomerDto customerDto = new CustomerDto(CusId,Address,name,City,Salary,PostalCode,dob,Title,Province);
//        customerDtos.add(customerDto);
//        tblCustomerInfo.refresh();



//        txtCusId.setText("");
//        txtTitle.setText("");
//        txtname.setText("");
//        txtDob.setText("");
//        txtSalary.setText("");
//        txtAddress.setText("");
//        txtCity.setText("");
//        txtProvince.setText("");
//        txtPostalCode.setText("");

    }

    public void loadDetails(){
     tblCustomerInfo.setItems(customerService.getAllCustomer());
    }

    @FXML
    void ReloadOnAction(ActionEvent event) {
        loadDetails();
    }

    public void clearFields(){
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
        loadDetails();


        tblCustomerInfo.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue )->{
            if (newValue != null){
                txtCusId.setText(newValue.getCusId());
                txtname.setText(newValue.getName());
                txtCity.setText(newValue.getCity());
                txtDob.setText(newValue.getDob());
                txtAddress.setText(newValue.getAddress());
                txtPostalCode.setText(newValue.getPostalCode());
                txtProvince.setText(newValue.getProvince());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtTitle.setText(newValue.getTitle());
            }

        } );

    }
}
