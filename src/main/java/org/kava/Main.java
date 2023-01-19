package org.kava;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("org.kava.person");
        EntityManager entityManager = factory.createEntityManager();

        House house1 = new House("warszawa1", 120);
        House house2 = new House("poznan23", 120);
        Person person1 = new Person(1, "Jan", "Kowalski", 40, "111222333", house1);
        Person person2 = new Person(2, "Anna", "Kowalska", 38, "777888999", house2);

        // Inserting houses.
        System.out.println("Inserting houses.");
        entityManager.getTransaction().begin();
        entityManager.persist(house1);
        entityManager.persist(house2);
        entityManager.getTransaction().commit();

        // Inserting new objects.
        System.out.println("Inserting new objects.");
        entityManager.getTransaction().begin();
        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.getTransaction().commit();

        // Reading objects.
        System.out.println("Reading objects.");
        Person readPerson1 = entityManager.find(Person.class, 1);
        Person readPerson2 = entityManager.find(Person.class, 2);
        System.out.println("Printing objects.");
        System.out.println(readPerson1);
        System.out.println("Printing only name.");
        System.out.println(readPerson2.getFirstName());
        System.out.println();

        // Deleting one object.
        System.out.println("Deleting one object.");
        entityManager.getTransaction().begin();
        entityManager.remove(readPerson1);
        entityManager.getTransaction().commit();

        // Reading objects again.
        System.out.println("Reading objects again.");
        readPerson1 = entityManager.find(Person.class, 1);
        readPerson2 = entityManager.find(Person.class, 2);
        System.out.println(readPerson1);
        System.out.println(readPerson2);
        System.out.println();

        // Removing remaining object.
        System.out.println("Removing remaining object.");
        entityManager.getTransaction().begin();
        entityManager.remove(readPerson2);
        entityManager.getTransaction().commit();

        factory.close();
        entityManager.close();
    }
}