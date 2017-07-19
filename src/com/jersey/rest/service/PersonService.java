package com.jersey.rest.service;

import com.jersey.rest.model.Person;
import com.jersey.rest.model.Response;

public interface PersonService {
    public Response addPerson(Person p);

    public Response deletePerson(int id);

    public Person getPerson(int id);

    public Person[] getAllPersons();
}
