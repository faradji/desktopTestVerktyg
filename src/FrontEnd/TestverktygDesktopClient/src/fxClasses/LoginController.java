package fxClasses;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import propertymodels.Participant;

import repositories.ParticipantRepository;
import repositories.StudentRepository;
import repositories.TeacherRepository;

public class LoginController implements Initializable {

    static propertymodels.Teacher currentTeacher;
    static propertymodels.Student currentStudent;

    ParticipantRepository pr = new ParticipantRepository();

    propertymodels.Participant currentParticipant;//= new propertymodels.Participant();

    @FXML
    Button btnLogin;

    @FXML
    TextField txtUserName;

    @FXML
    PasswordField txtPassword;

    @FXML
    Label lblUserName, lblPassword;

    @FXML
    private void btnLoginClicked(ActionEvent event) {
//         Runnable r = ()
//                            -> {
        TeacherRepository tr = new TeacherRepository();
        StudentRepository sr = new StudentRepository();
        
            models.Teacher teacher = tr.getTeacherByName(txtUserName.getText());
            
            propertymodels.Teacher propertyT = new propertymodels.Teacher(teacher.getId(), teacher.getName(), teacher.getPassword(), teacher.getSubject());
           
                currentTeacher = new propertymodels.Teacher(propertyT.getId(), propertyT.getName(),
                        propertyT.getPassword(), propertyT.getSubject());

            models.Student student = sr.getStudentByName(txtUserName.getText());
            
            propertymodels.Student propertyS = new propertymodels.Student(student.getId(), student.getName(), student.getPassword());

                currentStudent = new propertymodels.Student(propertyS.getId(), propertyS.getName(),
                        propertyS.getPassword());
            
        

//                    };
//
//                    Thread thread = new Thread(r);
//
//                    thread.start();
        try {
            if(currentTeacher.getSubject() != null){
                if (txtPassword.getText().equals(currentTeacher.getPassword())) {

                //System.out.println("Subject: "+currentParticipant.getSubject());
                System.out.println("Påväg till TeacherStartPage");

                Parent participant = FXMLLoader.load(getClass().getResource("TeacherStartPage.fxml"));

                Scene s = new Scene(participant);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(s);

                stage.show();

            }
            }else if (txtPassword.getText().equals(currentStudent.getPassword())) {

                //student
                Parent p = FXMLLoader.load(getClass().getResource("StudentStartPage.fxml"));

                Scene s = new Scene(p);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(s);

                stage.show();
            }else{
                System.out.println("användare finns inte");
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {

        txtPassword.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override

            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {

                if (newPropertyValue) {

                }

            }

        });

    }
}
