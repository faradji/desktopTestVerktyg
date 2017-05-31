/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxClasses;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import models.Participant;
import repositories.ParticipantRepository;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class LoginController implements Initializable {
    
    ParticipantRepository pr = new ParticipantRepository();
    
    Participant currentParticipant = new Participant();
    
    @FXML Button btnLogin;
    @FXML TextField txtUserName;
    @FXML PasswordField txtPassword;
    @FXML Label lblUserName, lblPassword;
    
    @FXML private void btnLoginClicked()
    {
        if (txtPassword.getText().equals(currentParticipant.getPassword()))
        {
            //Återkom hit senare
        }
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtPassword.textProperty().addListener(new ChangeListener()
        {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue)
            {
                Runnable r = ()-> {
                    Participant temp = pr.getParticipant(txtUserName.getText().toLowerCase());
                    currentParticipant.setId(temp.getId());
                    currentParticipant.setName(temp.getName());
                    currentParticipant.setPassword(temp.getPassword());
                    
                    
                };
                
                Thread thread = new Thread(r);
                thread.start();
            }
            
        });
    }    
    
}
