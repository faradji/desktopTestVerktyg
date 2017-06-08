/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Henrik Rosqvist
 */
public class StudentAnswerRepository {

    Client client;

    public StudentAnswerRepository() {
    }

    public void addStudentAnswer(models.StudentAnswer newAnswer) {
        client = ClientBuilder.newClient();
        client.target("http://localhost:8080/TestverktygDesktop/webapi/studentAnswer")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(newAnswer), models.StudentAnswer.class);

    }
}
