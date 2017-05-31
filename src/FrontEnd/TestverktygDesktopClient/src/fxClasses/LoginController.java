/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */
package fxClasses;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import models.Participant;
import repositories.ParticipantRepository;
import models.Teacher;
import propertymodels.Student;

public class LoginController implements Initializable {

    ParticipantRepository pr = new ParticipantRepository();

    Participant currentParticipant = new Participant();

    @FXML Button btnLogin;
    @FXML TextField txtUserName;
    @FXML PasswordField txtPassword;
    @FXML Label lblUserName, lblPassword;

    @FXML private void btnLoginClicked(ActionEvent event) throws IOException
    {        
        if (txtPassword.getText().equals(currentParticipant.getPassword()))
        {
            System.out.println("Dtype: " + currentParticipant.getDtype());
            Parent p = FXMLLoader.load(getClass().getResource("TeacherStartPage.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(s);
            stage.show();
        }

    }
    
    @Override

    public void initialize(URL url, ResourceBundle rb)
    {

        txtPassword.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    Runnable r = ()-> 
                    {
                        List<Participant> participantList;
                        participantList = pr.getParticipants();
                        System.out.println("participantList värde: " + participantList);

                        for (int i = 0; i < participantList.size(); i++)
                        {
                            Participant loopParticipant = participantList.get(i);
                            if (loopParticipant.getName().equals(txtUserName.getText()))
                            {
                                currentParticipant.setId(loopParticipant.getId());
                                currentParticipant.setName(loopParticipant.getName());
                                currentParticipant.setPassword(loopParticipant.getPassword());

                                System.out.println(currentParticipant.getName());
                            }
                        }

                    };

                    Thread thread = new Thread(r);
                    thread.start();
                }
            }
        });
    }
}
