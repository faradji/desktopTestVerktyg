package propertymodels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Participant{

<<<<<<< HEAD
    IntegerProperty id;
    StringProperty name;
    StringProperty password;
=======
    int id;
    String name;
    String password;
    String dtype;
>>>>>>> henrik2

    public Participant() {
    }

<<<<<<< HEAD
    public Participant(int id, String name, String password) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.password = new SimpleStringProperty(password);
=======
    public Participant(int id, String name, String password, String dtype) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.dtype = dtype;
>>>>>>> henrik2
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
    
    public String getDtype()
    {
        return dtype;
    }
    
    public void setDtype(String dtype)
    {
        this.dtype = dtype;
    }
}
