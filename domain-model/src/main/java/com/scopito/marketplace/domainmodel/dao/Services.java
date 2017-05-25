package com.scopito.marketplace.domainmodel.dao;

import com.scopito.marketplace.domainmodel.model.ServicesEntity;
import org.jboss.logging.Logger;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class Services extends AbstractDao<ServicesEntity> {
    private final Logger logger = Logger.getLogger(getClass());

    Services() {
        super(ServicesEntity.class);
    }

    public List<ServicesEntity> listAll() {
        logger.info("Reading all from named query 'ServiceView.findAll'");
        return listAll("Services.findAll");
    }

    public List<ServicesEntity> getServicesByID(long scopitoID) {
        return getEntityManager().createNamedQuery("Services.findByID", ServicesEntity.class).setParameter("serviceID", scopitoID).getResultList();
    }

    public List<ServicesEntity> listRange(int pageCount, int pageSize) {
        logger.info("Reading range from named query 'ServiceView.findAll'");
        return listAllRange("Services.findAll", pageCount, pageSize);
    }
}