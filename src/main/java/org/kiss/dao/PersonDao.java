package org.kiss.dao;

import org.kiss.model.Person;

/**
 * Created by kiss on 2018/8/13.
 */
public interface PersonDao {
    Person findPersonByName(String name);

    int createPerson(Person person);
}
