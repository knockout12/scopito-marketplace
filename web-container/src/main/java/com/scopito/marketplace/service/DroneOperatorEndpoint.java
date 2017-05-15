package com.scopito.marketplace.service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.scopito.marketplace.;
import com.scopito.marketplace.domainmodel.model.DroneOperatorProfile;
import com.scopito.marketplace.model.ProfileResponse;
import org.jboss.logging.Logger;

@Path("/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DroneOperatorProfileBean {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private DroneOperatorProfileBean droneOperatorProfileBean;

    // /service/dashboard/2
    /*@GET
    @Path("{id}")
    public Response get(@PathParam("id") int id) {
        logger.info("Requesting to list the first 40 dashboard status entries");
        return Response.ok(StatusResponse.fromList(dashboardBean.get(0, 40))).build();
    }*/

    @GET
    public Response getList() {
        logger.info("Requesting to list the first 40 dashboard status entries");
        return Response.ok(ProfileResponse.fromList(droneOperatorProfileBean.list(0, 40))).build();
    }
}