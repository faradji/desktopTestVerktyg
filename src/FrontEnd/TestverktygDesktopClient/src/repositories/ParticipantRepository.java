package repositories;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import models.Participant;
import propertymodels.Student;

public class ParticipantRepository {
    Client client;
    public ParticipantRepository() {
       
    }
    public List<Participant> getParticipants() {
        
        client = ClientBuilder.newClient();
        
        List <Participant> participants;
        participants = client.target("http://localhost:8080/TestverktygDesktop/webapi/participants/participantlist")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Participant>>(){});
        
        client.close();

        return participants;
    }
    
//    public List<Participant> getParticipants() {
//       
//        return participants;
//    }
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

    public Student getParticipant(int participant_Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
