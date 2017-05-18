package com.scopito.marketplace.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import com.scopito.marketplace.ServicesViewBean;
import com.scopito.marketplace.model.ServicesViewResponse;
import org.jboss.logging.Logger;

@Path("/services")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ServicesViewEndpoint {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private ServicesViewBean servicesViewBean;

    @GET
    @Path("/{id}")
    public Response getServicesByID(@PathParam("id") long scopitoID) {
        logger.info(String.format("Requesting profile with scopito ID '%d'", scopitoID));
        return Response.ok(ServicesViewResponse.getServicesByID(servicesViewBean.getServicesByID(scopitoID))).build();
    }

    @GET
    @Path("/list")
    public Response getServicesList() {
        return Response.ok(servicesViewBean.list(0, 5)).build();
    }
}
