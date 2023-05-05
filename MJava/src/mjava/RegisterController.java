/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mjava;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class RegisterController implements Initializable {
      @FXML
    private PasswordField password;

    @FXML
    private Button btn_daftar;

    @FXML
    private TextField nama_lengkap;

    @FXML
    private Hyperlink masuk;

    @FXML
    private TextField email;
    
    
    
     @FXML
     Connection connect;
     PreparedStatement statement;
     int myindex;
     int id;
     
     public  void Connect() throws ClassNotFoundException{
         Class.forName("com.mysql.jbdc.Driver");
          try {
              connect = DriverManager.getConnection("jbdc:mysql//localhost/marsada","root","");
          } catch (SQLException ex) {
         }
         
         
        }
     
    
        public void signup (ActionEvent event) {
            
          try {
              Connect();
          } catch (ClassNotFoundException ex) {
              System.out.print("error");
          }
        
        try {
            String sql = "INSERT INTO user VALUE (?,?,?)";
            
            statement = connect.prepareStatement(sql);
            statement.setString(1, nama_lengkap.getText());
            statement.setString(2, email.getText());
            statement.setString(3, password.getText());
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Successfully Create new Account!", 
            "Message", JOptionPane.INFORMATION_MESSAGE);
        }catch (HeadlessException | SQLException e) {
        }
    }
         public void login (ActionEvent event) {
        try {
            masuk.getScene().getWindow().hide();
            
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            
            Scene scene = new Scene (root);
            
            Stage stage = new Stage ();
            
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
        }
     }

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
