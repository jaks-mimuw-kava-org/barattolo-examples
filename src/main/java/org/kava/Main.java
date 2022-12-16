package org.kava;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("org.kava.person");
        EntityManager entityManager = factory.createEntityManager();

        Person person1 = new Person(1, "Jan", "Kowalski", 40, "111222333");
        Person person2 = new Person(2, "Anna", "Kowalska", 38, "777888999");

        // Inserting new objects.
        entityManager.getTransaction().begin();
        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.getTransaction().commit();

        // Reading objects.
        Person readPerson1 = entityManager.find(Person.class, 1);
        Person readPerson2 = entityManager.find(Person.class, 2);
        System.out.println(readPerson1);
        System.out.println(readPerson2);
        System.out.println();

        // Deleting one objet.
        entityManager.getTransaction().begin();
        entityManager.remove(readPerson1);
        entityManager.getTransaction().commit();

        // Reading objects again.
        readPerson1 = entityManager.find(Person.class, 1);
        readPerson2 = entityManager.find(Person.class, 2);
        System.out.println(readPerson1);
        System.out.println(readPerson2);
        System.out.println();

        // Removing remaining object.
        entityManager.getTransaction().begin();
        entityManager.remove(readPerson2);
        entityManager.getTransaction().commit();

        // Adding an object to see in the db ui.
        int id = 42;
        Person personX = new Person(id, "Anna", "Kowalska", 34, "111222333");

        entityManager.getTransaction().begin();
        entityManager.persist(personX);
        entityManager.getTransaction().commit();

        factory.close();
        entityManager.close();
    }
}