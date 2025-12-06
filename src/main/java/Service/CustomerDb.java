package Service;

import Model.dto.CustomerDto;
import Repositry.CustomerRepositry;
import Repositry.CustomerRepositryImpl;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.*;

public class CustomerDb implements CustomerService {

    CustomerRepositry customerRepositry = new CustomerRepositryImpl();

    @Override
    public void AddCusDetails(String cusId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode){
       customerRepositry.addCustomer(cusId,title,name,dob,salary,address,city,province,postalCode);
    }

    @Override
    public void UpdateCus(String cusId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode){
        customerRepositry.updateCustomer(cusId,title,name,dob,salary,address,city,province,postalCode);
    }

    @Override
    public void DeleteCus(TextField txtCusId){
        customerRepositry.deleteCustomer(txtCusId);
    }

    @Override
    public ObservableList<CustomerDto> getAllCustomer(){
        ObservableList<CustomerDto> customerDetails = javafx.collections.FXCollections.observableArrayList();
        try {
            CustomerRepositryImpl customerRepositry1 = new CustomerRepositryImpl();
            ResultSet resultSet = customerRepositry1.getAllCustomer();

            while (resultSet.next()){
                customerDetails.add(new CustomerDto(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDouble(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9)

                        )
                );

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerDetails;
    }

}
