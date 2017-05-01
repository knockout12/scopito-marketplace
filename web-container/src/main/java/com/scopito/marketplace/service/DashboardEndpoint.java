package com.scopito.marketplace.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import com.scopito.marketplace.DashboardBean;
import org.jboss.logging.Logger;

@Path("/dashboard")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DashboardEndpoint {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private DashboardBean dashboardBean;

    @GET
    public Response getList() {
        logger.info("Requesting to list the first 40 dashboard status entries");
        return Response.ok(dashboardBean.list(0, 40)).build();
    }
}