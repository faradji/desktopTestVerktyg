package fxClasses;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Participant;

import repositories.ParticipantRepository;

public class LoginController implements Initializable {

    static propertymodels.Teacher currentTeacher;
    static propertymodels.Student currentStudent;

    ParticipantRepository pr = new ParticipantRepository();

    propertymodels.Participant currentParticipant = new propertymodels.Participant();

    @FXML
    Button btnLogin;

    @FXML
    TextField txtUserName;

    @FXML
    PasswordField txtPassword;

    @FXML
    Label lblUserName, lblPassword;

    @FXML
    private void btnLoginClicked(ActionEvent event) throws IOException {
        if (currentParticipant instanceof propertymodels.Teacher) {
            if (txtPassword.getText().equals(currentParticipant.getPassword())) {

                //System.out.println("Subject: "+currentParticipant.getSubject());
                System.out.println("Påväg till TeacherStartPage");

                Parent p = FXMLLoader.load(getClass().getResource("TeacherStartPage.fxml"));

                Scene s = new Scene(p);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(s);

                stage.show();

            }
        } else {
            //student
            Parent p = FXMLLoader.load(getClass().getResource("StudentStartPage.fxml"));

            Scene s = new Scene(p);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(s);

            stage.show();

        }

    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {

        txtPassword.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override

            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {

                if (newPropertyValue) {

                    Runnable r = ()
                            -> {

                        Participant p = pr.getParticipant(txtUserName.getText());

                        if (p.getName().equalsIgnoreCase(txtUserName.getText())) {

                            currentParticipant.setId(p.getId());
                            currentParticipant.setName(p.getName());
                            currentParticipant.setPassword(p.getPassword());
                        }
                        System.out.println(currentParticipant.getName());

                    };

                    Thread thread = new Thread(r);

                    thread.start();

                }

            }

        });

    }
}
