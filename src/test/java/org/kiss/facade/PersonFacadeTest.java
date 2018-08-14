package org.kiss.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiss.model.Person;
import org.kiss.service.PersonService;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.amqp.core.AmqpTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by kiss on 2018/8/13.
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonFacadeTest {
    @Mock
    PersonService personService;

    @InjectMocks
    PersonFacadeImpl personFacade;

    @Mock
    private AmqpTemplate amqpTemplate;

    @Test
    public void makePerson() throws Exception {
        when(personService.makePerson(any(Person.class))).thenReturn(true);
        boolean status = personFacade.makePerson(new Person());
        verifyZeroInteractions(personService);

        ArgumentCaptor<Person> personArgumentCaptor = ArgumentCaptor.forClass(Person.class);
        verify(personService).makePerson(personArgumentCaptor.capture());
        System.out.println(personArgumentCaptor.getAllValues());
        verify(personService, never()).findPersonByName(anyString());
        verify(personService, times(2)).makePerson(any(Person.class));
//        verifyNoMoreInteractions(personService);
        System.out.println(status);
    }

    @Test
    public void findPersonByName() throws Exception {
        when(personService.findPersonByName(anyString())).thenReturn(any(Person.class));
        Person personByName = personService.findPersonByName("test");
        verifyZeroInteractions(personService);
        System.out.println(personByName);
    }

    @Test
    public void testMQ() throws Exception {
        when(amqpTemplate.convertSendAndReceive(anyObject())).thenReturn(Void.TYPE);
        personFacade.testMQ();
    }

}