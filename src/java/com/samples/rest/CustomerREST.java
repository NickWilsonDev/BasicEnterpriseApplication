/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Customer;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author nick
 */
@Path("customer")
@RequestScoped
public class CustomerREST {

    @Context
    private UriInfo context;

    @Inject
    private CustomerFacade customerFacade;
    /**
     * Creates a new instance of CustomerREST
     */
    public CustomerREST() {
    }

    /**
     * Retrieves representation of an instance of com.samples.rest.CustomerREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public List<Customer> getJson() {
        //TODO return proper representation object
        return customerFacade.findAll();
    }

    /**
     *
     * @param name
     * @return
     */
    @GET
    @Path("/search/{name}")
    public List<Customer> findByName(@PathParam("name") String name) {
        return customerFacade.findByName(name);
    }
    
    /**
     * PUT method for updating or creating an instance of CustomerREST
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    } 
}
