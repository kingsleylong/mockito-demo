package org.kiss.facade;

import org.kiss.model.Person;
import org.kiss.service.PersonService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by kiss on 2018/8/13.
 */
@Controller
public class PersonFacadeImpl implements PersonFacade {
    @Autowired
    private PersonService personService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public boolean makePerson(Person personA) {
        boolean b = personService.makePerson(personA);
        if (b) {
            System.out.println("person facade: made success.");
            return true;
        } else {
            System.out.println("person facade: made failure.");
            return false;
        }
    }

    @Override
    public Person findPersonByName(String name) {
        return null;
    }

    @Override
    public void testMQ() {
        amqpTemplate.convertAndSend(new Object());
        System.out.println("Message sent.");
    }
}
