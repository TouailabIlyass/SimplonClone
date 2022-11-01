package com.simplonclone.simplonclone.services;

import com.simplonclone.simplonclone.config.Config;
import com.simplonclone.simplonclone.entity.Apprenant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ApprenantService {

    public boolean add(Apprenant apprenant)
    {
        try{
            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            em.persist(apprenant);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Apprenant findById(int id)
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();
            return em.find(Apprenant.class, id);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public boolean update(Apprenant apprenant)
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();
            em.getTransaction().begin();
            em.merge(apprenant);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteByID(int id)
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();

            em.getTransaction().begin();
            Apprenant apprenant = em.find(Apprenant.class, id);
            em.remove(apprenant);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Apprenant> getAll(int limit)
    {
        try{

            EntityManager em = Config.getConfig().getEntityManager();

            em.getTransaction().begin();
            // TypedQuery<AdminEntity> query = entityManager.createQuery("SELECT e FROM AdminEntity e WHERE e.email = :email",AdminEntity.class);
            //        query.setParameter("email",email);
            TypedQuery<Apprenant> query = em.createQuery("SELECT a FROM Apprenant a", Apprenant.class);
            //query.setParameter("limit",limit);

            List<Apprenant> list = query.getResultList();
            //List<Apprenant> list = em.createQuery("select a FROM Apprenant a", Apprenant.class).getResultList();
            em.getTransaction().commit();
            return list;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
