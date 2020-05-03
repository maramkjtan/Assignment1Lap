/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication48;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Maram Tanani
 */
public class EmployeeController implements Initializable {

    @FXML
    private TextField tfId;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfSalary;
    @FXML
    private TextField tfField;
    @FXML
    private TableView<Employee> tableview;
    @FXML
    private TableColumn<Employee, Integer> tcId;
    @FXML
    private TableColumn<Employee, String> tcName;
    @FXML
    private TableColumn<Employee, Double> tcSalary;
    @FXML
    private TableColumn<Employee, String> tcField;
    @FXML
    private Button btnView;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDELETE;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnExit;
    Statement st;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
               DriverManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/company?serverTimezone=UTC",
                        "root", "");
            this.st = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tcId.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcSalary.setCellValueFactory(new PropertyValueFactory("salary"));
        tcField.setCellValueFactory(new PropertyValueFactory("field"));
        tableview.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedEmployee() );

    }  
    private void showSelectedEmployee() {
        Employee doc = tableview.getSelectionModel().getSelectedItem();
        if (doc != null) {
            tfId.setText(String.valueOf(doc.getId()));
            tfName.setText(doc.getName());
            tfSalary.setText(String.valueOf(doc.getSalary()));
            tfField.setText(doc.getField());
        }

    }


    @FXML
    private void buttonViewHandle(ActionEvent event) throws Exception{
         ResultSet resultSet = this.st.executeQuery("select * From employee");
        tableview.getItems().clear();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setSalary(resultSet.getDouble("salary"));
            employee.setFeild(resultSet.getString("field"));
            tableview.getItems().add(employee);
        }

    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws Exception{
        
        Integer id = Integer.parseInt(tfId.getText());
        String name = tfName.getText();
        Double salary = Double.parseDouble(tfSalary.getText());
        String field = tfField.getText();
        String str = "Insert Into employee values(" + id + ",'" + name + "',"
                + salary + ",'" + field + "')";
        this.st.executeUpdate(str);

    }

    @FXML
    private void btnUpdateHandle(ActionEvent event)throws Exception{
         Integer id = Integer.parseInt(tfId.getText());
        String name = tfName.getText();
        Integer salary = Integer.parseInt(tfSalary.getText());
        String field = tfField.getText();
        String str = "Update employee Set name='" + name + "', salary="
                + salary + ", field='" + field + "' Where id=" + id;
        this.st.executeUpdate(str);

    }
    @FXML
    private void buttonDELETEHandle(ActionEvent event) throws Exception{
        Integer id = Integer.parseInt(tfId.getText());
        String name = tfName.getText();
        Double salary = Double.parseDouble(tfSalary.getText());
        String field = tfField.getText();
        String str = "Delete From employee Where id=" + id;
        this.st.executeUpdate(str);

    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        tfId.setText("");
        tfName.setText("");
        tfSalary.setText("");
        tfField.setText("");
        tableview.getItems().clear();

    }
    

    @FXML
    private void buttonExitHandle(ActionEvent event) {
        System.exit(0);
    }
    
}
