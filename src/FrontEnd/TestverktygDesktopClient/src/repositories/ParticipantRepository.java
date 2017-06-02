package repositories;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import models.Participant;

public class ParticipantRepository {
    Client client;
    
    public ParticipantRepository() {
       
    }
//
//    public Participant getParticipant(int participantId) {
//      
//        return participant;
//    }
//
    public List<Participant> getParticipants() {
        
        client = ClientBuilder.newClient();
        
        List <Participant> participants;
        participants = client.target("http://localhost:8080/TestverktygDesktop/webapi/participants/participantlist")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Participant>>(){});
        
        client.close();

        return participants;
    }

//
//    public Participant addParticipant(Participant participant) {
//       
//        return participant;
//    }
//
//    public Participant updateParticipant(Participant participant) {
//      
//        return participant;
//    }
//
//    public void deleteParticipant(int participantId) {
//       
//    }

//
//    public Student getParticipant(String participantName) {
//        return 
//    }

    public Participant getParticipant(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
