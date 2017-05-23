package com.mycompany.testverktygdesktop.resources;

<<<<<<< HEAD
public class UserResource {
    
=======
import com.mycompany.testverktygdesktop.models.Participant;
import com.mycompany.testverktygdesktop.models.Student;
import com.mycompany.testverktygdesktop.repositories.StudentRepository;
import com.mycompany.testverktygdesktop.repositories.ParticipantRepository;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author louiseahokas
 */
public class ParticipantResource {
        ParticipantRepository sr = new ParticipantRepository();

    @GET
    @Path("/{participantId}")
    public Participant getParticipant(@PathParam("userId") int participantId)
    {
        System.out.println("resource");
        return sr.getParticipant(participantId);
    }

    @GET
    public List<Participant> getParticipants()
    {
        System.out.println("resource");
        return sr.getParticipants();
    }

    @POST
    public Participant addParticipant(Participant participant)
    {
        return sr.addParticipant(participant);
    }

    @PUT
    public Participant updateParticipant(Participant participant)
    {
        return sr.updateParticipant(participant);
    }

    @DELETE
    @Path("/{participantId}")
    public void deleteParticipant(@PathParam("participantId") int participantId)
    {
        sr.deleteParticipant(participantId);
    }
>>>>>>> magnus
}
