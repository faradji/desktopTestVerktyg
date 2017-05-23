package com.mycompany.testverktygdesktop.repositories;

import com.mycompany.testverktygdesktop.models.Participant;
import com.mycompany.testverktygdesktop.models.Test;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author louiseahokas
 */
public class ParticipantRepository
{

    SessionFactory sessionFactory;

    public ParticipantRepository()
    {
        sessionFactory = myHibernateUtil.getSessionFactory();
    }

    public Participant getParticipant(int participantId)
    {
        Session session = sessionFactory.openSession();
        Participant participant = (Participant) session.get(Participant.class, participantId);

        session.close();
        System.out.println("repo");
        return participant;
    }

    public List<Participant> getParticipants()
    {
        Session session = sessionFactory.openSession();
        List<Participant> participants = session.createCriteria(Participant.class).list();

        System.out.println("repo");
        session.close();
        return participants;
    }

    public Participant addParticipant(Participant participant)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(participant);
        session.getTransaction().commit();
        session.close();
        return participant;
    }

    public Participant updateParticipant(Participant participant)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(participant);

        session.getTransaction().commit();
        session.close();
        return participant;
    }

    public void deleteParticipant(int participantId)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Participant participant = (Participant) session.get(Participant.class, participantId);

        session.delete(participant);
        session.getTransaction().commit();
        session.close();
    }

}
