package com.scopito.marketplace.service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.scopito.marketplace.DashboardBean;
import com.scopito.marketplace.model.StatusResponse;
import org.jboss.logging.Logger;

@Path("/dashboard")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DashboardEndpoint {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private DashboardBean dashboardBean;

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
        return Response.ok(StatusResponse.fromList(dashboardBean.list(0, 40))).build();
    }


    @GET
    public Response getList(int pageIndex, int pagSize) {
        logger.info("Requesting to list the first 40 dashboard status entries");
        return Response.ok(StatusResponse.fromList(dashboardBean.list(pageIndex, pagSize))).build();
    }


    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload() {
        return Response.ok().build();
    }
}