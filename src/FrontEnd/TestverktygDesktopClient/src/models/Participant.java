package models;

import java.io.Serializable;

public class Participant implements Serializable {

    int id;
    String name;
    String password;
    String DTYPE;

    public Participant() {
    }

    public Participant(int id, String name, String DTYPE, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.DTYPE = DTYPE;
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

    public String getDTYPE() {
        return DTYPE;
    }

    public void setDTYPE(String DTYPE) {
        this.DTYPE = DTYPE;
    }

}
