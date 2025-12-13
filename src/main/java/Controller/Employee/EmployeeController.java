package Controller.Employee;

import Model.dto.EmployeeDto;
import Service.EmployeeDb;
import Service.EmployeeService;
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

public class EmployeeController implements Initializable {

    EmployeeService employeeService = new EmployeeDb();
    ObservableList<EmployeeDto> employeeDtos = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContactNumber;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colEmployeeId;

    @FXML
    private TableColumn<?, ?> colJoinDate;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colPosition;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableView<EmployeeDto> tblEmployeeInfo;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContactNumber;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtEmployeeId;

    @FXML
    private TextField txtJoinDate;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtStatus;

    public void btnClear(ActionEvent actionEvent) {
        clearField();
    }

    public void btnDelete(ActionEvent actionEvent) {
        employeeService.DeleteEmployeeDetails(txtEmployeeId);
        clearField();
        loadDetails();
    }

    public void btnUpdate(ActionEvent actionEvent) {
        String EmployeeID = txtEmployeeId.getText();
        String Name = txtName.getText();
        String Nic = txtNic.getText();
        String DOB = txtDob.getText();
        String Position = txtPosition.getText();
        double Salary = Double.parseDouble(txtSalary.getText());
        String ContactNumber = txtContactNumber.getText();
        String Address = txtAddress.getText();
        String JoinDate = txtJoinDate.getText();
        String Status = txtStatus.getText();

        employeeService.UpdateEmployeeDetails(EmployeeID, Name, Nic, DOB, Position, Salary, ContactNumber, Address, JoinDate, Status);
        clearField();
        loadDetails();
    }

    public void btnAdd(ActionEvent actionEvent) {
        String EmployeeID = txtEmployeeId.getText();
        String Name = txtName.getText();
        String Nic = txtNic.getText();
        String DOB = txtDob.getText();
        String Position = txtPosition.getText();
        double Salary = Double.parseDouble(txtSalary.getText());
        String ContactNumber = txtContactNumber.getText();
        String Address = txtAddress.getText();
        String JoinDate = txtJoinDate.getText();
        String Status = txtStatus.getText();

        employeeService.AddEmployeeDetails(EmployeeID, Name, Nic, DOB, Position, Salary, ContactNumber, Address, JoinDate, Status);
        clearField();
        loadDetails();
    }

    @FXML
    void ReloadOnAction(ActionEvent event) {
        loadDetails();
    }

    public void clearField() {
        txtAddress.clear();
        txtDob.clear();
        txtEmployeeId.clear();
        txtName.clear();
        txtNic.clear();
        txtContactNumber.clear();
        txtJoinDate.clear();
        txtPosition.clear();
        txtSalary.clear();
        txtStatus.clear();
    }

    public void loadDetails() {
        tblEmployeeInfo.setItems(employeeService.getAllEmployee());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colJoinDate.setCellValueFactory(new PropertyValueFactory<>("joinDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tblEmployeeInfo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtEmployeeId.setText(newValue.getEmployeeId());
                txtName.setText(newValue.getName());
                txtNic.setText(newValue.getNic());
                txtDob.setText(newValue.getDob());
                txtPosition.setText(newValue.getPosition());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtContactNumber.setText(newValue.getContactNumber());
                txtAddress.setText(newValue.getAddress());
                txtJoinDate.setText(newValue.getJoinDate());
                txtStatus.setText(newValue.getStatus());
            }
        });

        loadDetails();
    }
}