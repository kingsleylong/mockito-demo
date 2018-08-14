package org.kiss.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiss.dao.PersonDao;
import org.kiss.model.Person;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.amqp.core.AmqpTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by kiss on 2018/8/13.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
    @Mock
    private PersonDao personDao;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    public void makePerson() throws Exception {
        when(personDao.createPerson(any(Person.class))).thenReturn(1);
        boolean b = personService.makePerson(new Person());
    }

    @Test
    public void findPersonByName() throws Exception {
        when(personDao.findPersonByName(anyString())).thenReturn(mock(Person.class));
        Person personByName = personService.findPersonByName(anyString());
        System.out.println(personByName);
    }

}