package com.jersey.rest.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jersey.rest.model.Person;
import com.jersey.rest.model.Response;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonServiceImpl implements PersonService {
    private static Map<Integer, Person> persons = new HashMap<>();

    @Override
    @POST
    @Path("/add")
    public Response addPerson(Person p) {
        Response response = new Response();
        if (persons.get(p.getId()) == null) {
            persons.put(p.getId(), p);
            response.setStatus(true);
            response.setMessage("Person created successfully");
            return response;
        }
        response.setStatus(false);
        response.setMessage("Person already exists");
        return response;
    }

    @Override
    @GET
    @Path("/{id}/delete")
    public Response deletePerson(@PathParam("id") int id) {
        Response response = new Response();
        if (persons.get(id) == null) {
            response.setStatus(false);
            response.setMessage("Person doesn't exist");
            return response;
        }
        persons.remove(id);
        response.setStatus(true);
        response.setMessage("Person deleted successfully");
        return response;
    }

    @Override
    @GET
    @Path("/{id}/get")
    public Person getPerson(@PathParam("id") int id) {
        return persons.get(id);
    }

    @Override
    @GET
    @Path("/getAll")
    public Person[] getAllPersons() {
        return persons.values().toArray(new Person[0]);
    }
}
