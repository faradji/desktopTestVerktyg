package fxClasses;

import java.io.IOException;

import java.net.URL;

import java.util.ResourceBundle;

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

        TeacherRepository tr = new TeacherRepository();

        StudentRepository sr = new StudentRepository();

        models.Participant p = pr.getParticipant(txtUserName.getText());
        System.out.println(p.getDTYPE() + "--------------------------------------------------");
        if (p.getDTYPE().equalsIgnoreCase("Teacher")) {

            try {

                models.Teacher teacher = tr.getTeacher(p.getId());

                propertymodels.Teacher propertyT = new propertymodels.Teacher(teacher.getId(), teacher.getName(),
                        teacher.getPassword(), teacher.getDTYPE(), teacher.getSubject());

                currentTeacher = propertyT;
                System.out.println(currentTeacher.getName());

                Parent teacherScene = FXMLLoader.load(getClass().getResource("TeacherStartPage.fxml"));

                Scene s = new Scene(teacherScene);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(s);

                stage.show();

            } catch (IOException ex) {

                System.out.println(ex.getMessage());

            }

        } else if (p.getDTYPE().equalsIgnoreCase("Student")) {

            try {

                models.Student student = sr.getStudent(p.getId());
                System.out.println("Blabla");
                propertymodels.Student propertyS = new propertymodels.Student(student.getId(), student.getName(), student.getDTYPE(),
                        student.getPassword());

                currentStudent = propertyS;
                System.out.println("lasjglasrihgnioasrhg<arg");
                Parent studentScene = FXMLLoader.load(getClass().getResource("StudentStartPage.fxml"));
                System.out.println("jag vill inte debugga");
                Scene scene = new Scene(studentScene);
                System.out.println("jag vill inte debugga2");

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                System.out.println("aliörshgäaorijgreag    ");
                stage.setScene(scene);

                stage.show();
                
            } catch (IOException ex) {

                System.out.println(ex.getMessage());

            }

        } else {

            System.out.println("användare finns inte");

        }

    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {

    }

}
