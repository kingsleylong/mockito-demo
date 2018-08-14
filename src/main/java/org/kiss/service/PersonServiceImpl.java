package org.kiss.service;

import org.kiss.dao.PersonDao;
import org.kiss.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kiss on 2018/8/13.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Override
    public boolean makePerson(Person personA) {
        int i = personDao.createPerson(personA);
        if (1 == i) {
            System.out.println("created 1 person");
            return true;
        } else {
            System.out.println("create person failed");
            return false;
        }
    }

    @Override
    public Person findPersonByName(String name) {
        Person personByName = personDao.findPersonByName(name);
        System.out.println("found person:" + personByName);
        return personByName;
    }
}
