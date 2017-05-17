package com.scopito.marketplace.domainmodel.dao;

import com.scopito.marketplace.domainmodel.model.DroneOperatorProfileEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class DroneOperatorProfile extends AbstractDao<DroneOperatorProfileEntity> {
    private final Logger logger = Logger.getLogger(getClass());

    DroneOperatorProfile() {
        super(DroneOperatorProfileEntity.class);
    }

    public List<DroneOperatorProfileEntity> listAll() {
        logger.info("Reading all from named query 'StatusEntity.findAll'");
        return listAll("DroneOperatorProfile.findAll");
    }

    public DroneOperatorProfileEntity get(long scopitoID) {
        return getEntityManager()
                .createNamedQuery("DroneOperatorProfile.findByID", DroneOperatorProfileEntity.class)
                .setParameter("scopitoID", scopitoID)
                .getSingleResult();
    }

    public List<DroneOperatorProfileEntity> listRange(int pageCount, int pageSize) {
        logger.info("Reading range from named query 'StatusEntity.findAll'");
        return listAllRange("DroneOperatorProfile.findAll", pageCount, pageSize);
    }
}