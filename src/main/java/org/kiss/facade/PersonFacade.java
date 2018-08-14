package org.kiss.facade;

import org.kiss.model.Person;

/**
 * Created by kiss on 2018/8/13.
 */
public interface PersonFacade {
    boolean makePerson(Person personA);

    Person findPersonByName(String name);

    void testMQ();
}
