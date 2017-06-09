package org.jboss.arquillian.wildfly.embedded.example;

import org.jboss.arquillian.wildfly.embedded.example.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by guidev on 6/3/17.
 */

@Stateless
public class MyService {

    @PersistenceContext
    EntityManager em;

    public String callMe(String number) {
        em.persist(new Person("Gui"));

        Query q = em.createQuery("select p from Person p");

        List<Person> list = q.getResultList();
        Person p = list.get(0);

        return "Fetched list from database of size : "+list.size() + " - "
                + p.getId();
    }
}
