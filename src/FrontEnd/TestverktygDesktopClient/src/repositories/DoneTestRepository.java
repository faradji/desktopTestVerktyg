/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import models.DoneTest;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;


public class DoneTestRepository {
    
    Client client;
    
    public List <DoneTest> getDoneTests(){
        client = ClientBuilder.newClient();
        
        List <DoneTest> doneTests;
        doneTests = client.target("http://localhost:8080/TestverktygDesktop/webapi/donetests")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<DoneTest>>(){});
        
        client.close();
        return doneTests;
        
    }
    
}
