package org.kava;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("org.kava.person");
        EntityManager entityManager = factory.createEntityManager();

        Person person = new Person();
        person.setId(2);
        person.setFirstName("first");
        person.setLastName("last");
        person.setAge(13);
        person.setPhoneNumber("111222333");

        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();

        factory.close();
        entityManager.close();
    }
}