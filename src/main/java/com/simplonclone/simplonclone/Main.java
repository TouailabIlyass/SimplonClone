package com.simplonclone.simplonclone;

import com.simplonclone.simplonclone.entity.*;
import com.simplonclone.simplonclone.services.ApprenantService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApprenantService apprenantService = new ApprenantService();
        Apprenant apprenant = new Apprenant();
        apprenant.setLastname("lname");
        apprenant.setEmail("email");
        apprenant.setPassword("pwd");
        //apprenantService.add(apprenant);

        System.out.println(apprenant);

       List<Apprenant> list = apprenantService.getAll(10);
        System.out.println(list.size());

    }

    public static void addApprenant()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simplonClone");
        EntityManager em = emf.createEntityManager();

        Apprenant apprenant = new Apprenant();
        apprenant.setFirstname("fname");
        apprenant.setLastname("lname");
        apprenant.setEmail("email");
        apprenant.setPassword("pwd");

        System.out.println(apprenant.getId());

        em.getTransaction().begin();

        em.persist(apprenant);

        em.getTransaction().commit();

        System.out.println(apprenant.getId());
    }
    public static void addFormateur()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simplonClone");
        EntityManager em = emf.createEntityManager();

        Formateur formateur = new Formateur();
        formateur.setFirstname("fname");
        formateur.setLastname("lname");
        formateur.setEmail("email");
        formateur.setPassword("pwd");

        System.out.println(formateur.getId());

        em.getTransaction().begin();

        em.persist(formateur);

        em.getTransaction().commit();

        System.out.println(formateur.getId());
    }

    public static void addPromo()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simplonClone");
        EntityManager em = emf.createEntityManager();

        Promos promos = new Promos();
        promos.setName("JAVA1");
        System.out.println(promos.getId());

        em.getTransaction().begin();

        em.persist(promos);

        em.getTransaction().commit();

        System.out.println(promos.getId());
    }

    public static void addBrief()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simplonClone");
        EntityManager em = emf.createEntityManager();

        Brief brief = new Brief();
        brief.setName("JAVA1");
        brief.setDescription("desc");
        System.out.println(brief.getId());

        em.getTransaction().begin();
        Promos promos = em.find(Promos.class,9);
        brief.setPromosByPromoId(promos);

        em.persist(brief);

        em.getTransaction().commit();

        System.out.println(brief.getId());
    }

    public static void addPromoApprenant()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simplonClone");
        EntityManager em = emf.createEntityManager();

        /*Promostoapprenant promostoapprenant = new Promostoapprenant();
        promostoapprenant.setApprenantId(5);
        promostoapprenant.setPromoId(5);
        System.out.println(promostoapprenant.getPromoId());
        em.getTransaction().begin();
        em.persist(promostoapprenant);
        em.getTransaction().commit();
        System.out.println(promostoapprenant.getPromoId());*/

//         Promostoapprenant promostoapprenant = new Promostoapprenant();
//        promostoapprenant.setApprenantId(5);
//        promostoapprenant.setPromoId(5);
//        System.out.println(promostoapprenant.getPromoId());
        em.getTransaction().begin();
        Promos promos = em.find(Promos.class,9);
        Apprenant apprenant = em.find(Apprenant.class,5);
        promos.getApprenantsById().add(apprenant);
        //promos.setApprenantsPerPromo(promos.getApprenantsById());
//        em.persist(promostoapprenant);
        em.merge(promos);
        em.getTransaction().commit();
//        System.out.println(promostoapprenant.getPromoId());
    }

    public static void addPromoApprenant2()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simplonClone");
        EntityManager em = emf.createEntityManager();

        /*Promostoapprenant promostoapprenant = new Promostoapprenant();
        promostoapprenant.setApprenantId(5);
        promostoapprenant.setPromoId(5);
        System.out.println(promostoapprenant.getPromoId());
        em.getTransaction().begin();
        em.persist(promostoapprenant);
        em.getTransaction().commit();
        System.out.println(promostoapprenant.getPromoId());*/

//         Promostoapprenant promostoapprenant = new Promostoapprenant();
//        promostoapprenant.setApprenantId(5);
//        promostoapprenant.setPromoId(5);
//        System.out.println(promostoapprenant.getPromoId());
        em.getTransaction().begin();
        Promos promos = em.find(Promos.class,9);
        Apprenant apprenant = em.find(Apprenant.class,5);
        apprenant.getPromosByPromoId().add(promos);
        apprenant.setPromosByPromoId(apprenant.getPromosByPromoId());
//        em.persist(promostoapprenant);
        em.merge(apprenant);
        em.getTransaction().commit();
//        System.out.println(promostoapprenant.getPromoId());
    }



}
