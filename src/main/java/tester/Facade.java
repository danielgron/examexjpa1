/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.ProjectUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 Create user
 Find user
 Get all users
 Create project
 Assign user to project
 Find project
 CreateTaskAndAssignToProject
 Etc.
 */

public class Facade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        
        
    
    public void createUser(String name, String email, Date date){
        em = emf.createEntityManager();
        ProjectUser pu = new ProjectUser(name, email, date);
        try{
            em.getTransaction().begin();
            em.persist(pu);
            em.getTransaction().commit();
        }
        finally{
            if (em!=null) em.close();
        }
    }
    public ProjectUser findUser(Long id){
        em = emf.createEntityManager();
        ProjectUser user;
        try{
            em.getTransaction().begin();
            user = em.find(ProjectUser.class, id);
            em.getTransaction().commit();
        }
        finally{
            if (em!=null) em.close();
        }
        return user;
    }
    
    public List<ProjectUser> getAllUsers(){
        em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT u FROM ProjectUser u");
        return q1.getResultList();
        
}
}

