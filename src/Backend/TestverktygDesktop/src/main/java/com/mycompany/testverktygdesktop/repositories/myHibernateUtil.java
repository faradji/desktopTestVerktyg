/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygdesktop.repositories;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author louiseahokas
 */

public class myHibernateUtil 
{

    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() 
    {
        if(sessionFactory== null) 
        {
            Configuration configuration= new Configuration().configure();
            StandardServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory= configuration.buildSessionFactory(registry); 
        } 
        return sessionFactory;
    }
    
    public static Session getSession(){
        Session session= getSessionFactory().openSession();
        return session;

    }
}
