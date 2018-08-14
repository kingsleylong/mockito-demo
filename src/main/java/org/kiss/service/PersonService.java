package org.kiss.service;

import org.kiss.model.Person;

/**
 * Created by kiss on 2018/8/13.
 */
public interface PersonService {
    boolean makePerson(Person personA);

    Person findPersonByName(String name);
}
