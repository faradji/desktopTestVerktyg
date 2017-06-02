package repositories;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import models.Participant;

public class ParticipantRepository {
<<<<<<< HEAD
    Client client;
    public ParticipantRepository() {
       
    }
=======

    Client client;
    
    public ParticipantRepository() {
       
    }
//
//    public Participant getParticipant(int participantId) {
//      
//        return participant;
//    }
//
>>>>>>> henrik2
    public List<Participant> getParticipants() {
        
        client = ClientBuilder.newClient();
        
        List <Participant> participants;
        participants = client.target("http://localhost:8080/TestverktygDesktop/webapi/participants/participantlist")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Participant>>(){});
        
        client.close();

        return participants;
    }
<<<<<<< HEAD
    
    public Participant getParticipant(String name) {
        
        client = ClientBuilder.newClient();
        
        Participant participant;
        participant = client.target("http://localhost:8080/TestverktygDesktop/webapi/participants/participantlist")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<Participant>(){});
        
        client.close();

        return participant;
    }
=======
>>>>>>> henrik2
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
<<<<<<< HEAD
=======
//
//    public Student getParticipant(String participantName) {
//        return 
//    }
>>>>>>> henrik2

}
