package propertymodels;

import models.*;
import java.io.Serializable;

public class Participant implements Serializable {

    int id;
    String name;
    String password;
    String dtype;

    public Participant() {
    }

    public Participant(int id, String name, String password, String dtype) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.dtype = dtype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
