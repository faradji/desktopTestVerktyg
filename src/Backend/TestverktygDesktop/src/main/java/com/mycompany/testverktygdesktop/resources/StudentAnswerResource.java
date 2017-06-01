/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygdesktop.resources;

import com.mycompany.testverktygdesktop.models.Participant;
import com.mycompany.testverktygdesktop.models.StudentAnswer;
import com.mycompany.testverktygdesktop.repositories.StudentAnswerRepository;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Allan
 */
public class StudentAnswerResource
{
    StudentAnswerRepository sRepo = new StudentAnswerRepository();
    
//    @GET
//    public StudentAnswer getStudentAnswer()
//    {
//        
//    }

    @GET
    public List<StudentAnswer> getStudentAnswers()
    {
        System.out.println("resource");
        return sRepo.getStudentAnswers();
    }
//
//    @POST
//    public StudentAnswer addParticipant(StudentAnswer studentAnswer)
//    {
//        return sRepo.addParticipant(participant);
//    }
//
//    @PUT
//    public Participant updateParticipant(Participant participant)
//    {
//        return sRepo.updateParticipant(participant);
//    }
//
//    @DELETE
//    @Path("/{participantId}")
//    public void deleteParticipant(@PathParam("participantId") int participantId)
//    {
//        sRepo.deleteParticipant(participantId);
//    }
//        
//    @Path("/teachers")
//    public TeacherResource teachers() {
//        return new TeacherResource();
//    }
//        
//    @Path("/students")
//    public StudentResource students() {
//        return new StudentResource();
//    }
}
