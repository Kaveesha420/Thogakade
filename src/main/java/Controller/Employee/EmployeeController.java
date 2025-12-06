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
        txtEmployeeId.setText("");
        txtName.setText("");
        txtNic.setText("");
        txtDob.setText("");
        txtSalary.setText("");
        txtAddress.setText("");
        txtPosition.setText("");
        txtContactNumber.setText("");
        txtJoinDate.setText("");
        txtStatus.setText("");
    }

    public void btnDelete(ActionEvent actionEvent) {

        employeeDtos.clear();

        employeeService.DeleteEmployeeDetails(txtEmployeeId);

        clearField();
        loadDetails();
    }

    public void btnUpdate(ActionEvent actionEvent) {

        employeeDtos.clear();

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

        employeeService.UpdateEmployeeDetails(EmployeeID,Name,Nic,DOB,Position,Salary,ContactNumber,Address,JoinDate,Status);
        clearField();
        loadDetails();

    }

    public void btnAdd(ActionEvent actionEvent) {

        employeeDtos.clear();

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

        employeeService.AddEmployeeDetails(EmployeeID,Name,Nic,DOB,Position,Salary,ContactNumber,Address,JoinDate,Status);
        clearField();
        loadDetails();
    }

    @FXML
    void ReloadOnAction(ActionEvent event) {
        loadDetails();
    }

    public void clearField(){
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

    public void loadDetails(){
        tblEmployeeInfo.setItems(employeeService.getAllEmployee());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tblEmployeeInfo.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newVallue )->{
            if (newVallue != null){
                txtAddress.setText(newVallue.getAddress());
                txtDob.setText(newVallue.getDob());
                txtEmployeeId.setText(newVallue.getEmployeeId());
                txtName.setText(newVallue.getName());
                txtNic.setText(newVallue.getNic());
                txtContactNumber.setText(newVallue.getContactNumber());
                txtJoinDate.setText(newVallue.getJoinedDate());
                txtPosition.setText(newVallue.getPosition());
                txtSalary.setText(String.valueOf(newVallue.getSalary()));
                txtStatus.setText(newVallue.getStatus());

            }

        });

        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("position"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colJoinDate.setCellValueFactory(new PropertyValueFactory<>("joinedDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        loadDetails();

    }
}
