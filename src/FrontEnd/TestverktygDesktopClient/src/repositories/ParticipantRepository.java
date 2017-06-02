package repositories;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class ParticipantRepository {

    Client client;

    public ParticipantRepository() {

    }

    public List<models.Participant> getParticipants() {

        client = ClientBuilder.newClient();

        List<models.Participant> participants;
        participants = client.target("http://localhost:8080/TestverktygDesktop/webapi/participants")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<models.Participant>>() {
                });

        client.close();

        return participants;
    }

    public models.Participant getParticipant(String name) {

        client = ClientBuilder.newClient();

        models.Participant participant;
        participant = client.target("http://localhost:8080/TestverktygDesktop/webapi/participants")
                .path(name)
                .request(MediaType.APPLICATION_JSON)
                .get(models.Participant.class);

        client.close();

        return participant;
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

}
