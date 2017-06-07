package propertymodels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Participant{

    IntegerProperty id;
    StringProperty name;
    StringProperty password;
    StringProperty DTYPE;

    public Participant() {
    }

    public Participant(int id, String name,String DTYPE, String password) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.password = new SimpleStringProperty(password);
        this.DTYPE = new SimpleStringProperty(DTYPE);
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

    public String getDTYPE() {
        return DTYPE.get();
    }

    public void setDTYPE(String DTYPE) {
        this.DTYPE.set(DTYPE);
    }

}
