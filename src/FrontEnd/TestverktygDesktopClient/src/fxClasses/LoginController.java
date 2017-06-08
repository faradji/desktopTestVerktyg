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
import javafx.scene.input.KeyEvent;

import javafx.stage.Stage;
import javax.swing.JOptionPane;
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
        if(p != null){
        if (p.getDTYPE().equalsIgnoreCase("Teacher")) {

            try {
                models.Teacher teacher = tr.getTeacher(p.getId());
                if (txtPassword.getText().equals(teacher.getPassword())) {
                    currentTeacher = new propertymodels.Teacher(teacher.getId(), teacher.getName(),
                            teacher.getPassword(), teacher.getDTYPE(), teacher.getSubject());

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

                if (txtPassword.getText().equals(student.getPassword())) {
                    System.out.println("student");
                    currentStudent = new propertymodels.Student(student.getId(), student.getName(),
                            student.getDTYPE(), student.getPassword());
                    System.out.println("student");
                    Parent studentScene = FXMLLoader.load(getClass().getResource("StudentStartPage.fxml"));
                    System.out.println("student");
                    Scene scene = new Scene(studentScene);
                    System.out.println("student");
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    System.out.println("student");
                    stage.setScene(scene);
                    System.out.println("student");
                    stage.show();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }} else {
            JOptionPane.showMessageDialog(null, "User doesnt exist.", "Inane error", JOptionPane.ERROR_MESSAGE);
            txtUserName.setText("");
            txtPassword.setText("");

        }

    }

    public void userNamevalidation() {
        txtUserName.setOnKeyReleased((KeyEvent event) -> {
            String regex = "[A-Za-z\\s]+";
            if (!txtUserName.getText().matches(regex)) {
                JOptionPane.showMessageDialog(null, "Username can only contain letters.", "Inane error", JOptionPane.ERROR_MESSAGE);
                txtUserName.setText("");

            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userNamevalidation();
    }
}
