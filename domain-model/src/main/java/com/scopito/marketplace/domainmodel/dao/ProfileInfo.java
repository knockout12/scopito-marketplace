package com.scopito.marketplace.domainmodel.dao;

import com.scopito.marketplace.domainmodel.model.DroneOperatorProfile;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class ProfileInfo extends AbstractDao<DroneOperatorProfile> {
    private final Logger logger = Logger.getLogger(getClass());

    ProfileInfo() {
        super(DroneOperatorProfile.class);
    }

    public List<DroneOperatorProfile> getProfile() {
        logger.info("Reading all from named query 'DroneOperatorProfile.findAll'");
        return listAll("DroneOperatorProfile.findAll");
    }

    public List<DroneOperatorProfile> listRange(int pageCount, int pageSize) {
        logger.info("Reading range from named query 'DroneOperatorProfile.findAll'");
        return listAllRange("DroneOperatorProfile.findAll", pageCount, pageSize);
    }
}
