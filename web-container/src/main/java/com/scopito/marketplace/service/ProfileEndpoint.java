package com.scopito.marketplace.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import com.scopito.marketplace.DroneOperatorProfileBean;
import com.scopito.marketplace.model.ProfileResponse;
import org.jboss.logging.Logger;

@Path("/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileEndpoint {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private DroneOperatorProfileBean droneOperatorProfileBean;

    @GET
    @Path("/{id}")
    public Response getByID(@PathParam("id") long scopitoID) {
        logger.info(String.format("Requesting profile with scopito ID '%d'", scopitoID));
        return Response.ok(ProfileResponse.getByID(droneOperatorProfileBean.getByID(scopitoID))).build();
    }

    @GET
    @Path("/list")
    public Response getList() {
        return Response.ok(droneOperatorProfileBean.list(0, 5)).build();
    }

}
